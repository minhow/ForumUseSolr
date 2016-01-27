package com.opensns.forumn.service;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.ui.Model;

import com.opensns.forumn.service.status.Collection;
import com.opensns.forumn.service.status.Node;
import com.opensns.forumn.service.status.Shard;

public class StatusService {
	private String URI_SOLR="http://1.234.16.50:9000/solr/";
	
	public final static String ACTION_CLUSTERSTATUS = "CLUSTERSTATUS";
	
	private String getActionUrl(String action) {
		return URI_SOLR + "admin/collections?wt=json&action=" + ACTION_CLUSTERSTATUS;
	}
	
	public Collection getClusterStatus() {
		String collectionName = "topic_posts";
		Collection collection = new Collection(collectionName);
		String clusterStatusUri = getActionUrl(ACTION_CLUSTERSTATUS);
		System.out.println(clusterStatusUri);
		try {
			URLConnection conn = new URL(clusterStatusUri).openConnection();
			JSONParser parser = new JSONParser();
			JSONObject jObj = (JSONObject) parser.parse(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			JSONObject resp = (JSONObject) jObj.get("cluster");
			JSONObject jCollections = (JSONObject)((JSONObject) resp.get("collections")).get(collectionName);
			JSONObject jsonShards = (JSONObject)jCollections.get("shards");
			System.out.println(jsonShards.toJSONString());
			addShards(collection, jsonShards);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return collection;
	}
	
	public void addShards(Collection collection, JSONObject jsonShards) {
		for( Iterator<String> iter = jsonShards.keySet().iterator(); iter.hasNext(); ) {
			String shardName = iter.next();
//			System.out.println(jsonShards.get(jsonShard));
			System.out.println(shardName);
			Shard shard = new Shard(collection, shardName);
			JSONObject jsonShard = (JSONObject)jsonShards.get(shardName);
			shard.setState((String)jsonShard.get("state"));
			addNodes(shard, (JSONObject)jsonShard.get("replicas"));
			collection.addShard(shard);
		}
	}
	
	public void addNodes(Shard shard, JSONObject jsonNodes) {
		System.out.println("Call addNodes");
		for( Iterator<String> iter = jsonNodes.keySet().iterator(); iter.hasNext(); ) {
			String nodeName = iter.next();
			JSONObject jsonNode = (JSONObject)jsonNodes.get(nodeName);
			Node node = new Node(shard, (String)jsonNode.get("node_name"));
			node.setBaseUrl((String)jsonNode.get("base_url"));
			node.setCore((String)jsonNode.get("core"));
			try {
				node.setLeader(Boolean.parseBoolean((String)jsonNode.get("leader")));
			} catch (Exception e) {  }
			System.out.println(node.isLeader());
			node.setState((String)jsonNode.get("state"));
			System.out.println(node.getName());
			shard.addNode(node);
		}
	}
}
