package com.opensns.forumn.service.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Collection {
	private String name;
	private List<Shard> shards;
	private int id = 0;
	private int curNodeNum = 0;
	private int curEdgeNum = 0;
	private JSONArray jsonNodes = new JSONArray();
	private JSONArray jsonEdges = new JSONArray();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void init() {
		shards = new ArrayList<Shard>();
	}
	
	public Collection(String name, List<Shard> shards) {
		super();
		this.name = name;
		this.shards = shards;
	}

	public Collection() {
		super();
		init();
	}
	
	public Collection(String name) {
		super();
		this.name = name;
		init();
	}
	
	public void addShard(Shard shard) {
		shards.add(shard);
	}
	
	public JSONObject toCyElementsJson() {
		JSONObject jsonElements = new JSONObject();
		JSONObject jsonData = new JSONObject();
		JSONObject jsonNode = new JSONObject();
		jsonData.put("id", "node-" + this.curNodeNum);
		jsonData.put("name", this.name);
		jsonNode.put("data", jsonData);
		jsonNodes.add(jsonNode);
		appendCyShard(jsonNodes, jsonEdges, curNodeNum);
		
		jsonElements.put("nodes", jsonNodes);
		jsonElements.put("edges", jsonEdges);
		
		return jsonElements;
	}
	
	@SuppressWarnings("unchecked")
	public void appendCyShard(JSONArray jsonNodes, JSONArray jsonEdges, int parentId) {
		for( Iterator<Shard> iter = this.shards.iterator(); iter.hasNext(); ) {
			curNodeNum++;
			curEdgeNum++;
			Shard shard = iter.next();
			JSONObject jsonData = new JSONObject();
			JSONObject jsonNode = new JSONObject();
			jsonData.put("id", "node-" + this.curNodeNum);
			jsonData.put("name", shard.getName());
			jsonNode.put("data",  jsonData);
			jsonNodes.add(jsonNode);
			
			jsonData = new JSONObject();
			jsonNode = new JSONObject();
			
			jsonData.put("id", "edge-" + curEdgeNum);
			jsonData.put("source", "node-" + curNodeNum);
			jsonData.put("target", "node-" + parentId);
			jsonNode.put("data",  jsonData);
			jsonEdges.add(jsonNode);
			
			
			appendCyNode(shard.getNodes(), jsonNodes, jsonEdges, curNodeNum);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void appendCyNode(List<Node> nodes, JSONArray jsonNodes, JSONArray jsonEdges, int parentId) {
		for( Iterator<Node> iter = nodes.iterator(); iter.hasNext(); ) {
			curNodeNum++;
			curEdgeNum++;
			Node node = iter.next();
			JSONObject jsonData = new JSONObject();
			JSONObject jsonNode = new JSONObject();
			jsonData.put("id", "node-" + this.curNodeNum);
			jsonData.put("name", node.getName());
			jsonNode.put("data", jsonData);
			jsonNodes.add(jsonNode);
			
			jsonData = new JSONObject();
			jsonNode = new JSONObject();
			
			jsonData.put("id", "edge-" + curEdgeNum);
			jsonData.put("source", "node-" + curNodeNum);
			jsonData.put("target", "node-" + parentId);
			jsonNode.put("data", jsonData);
			jsonEdges.add(jsonNode);
		}
	}
}
