package com.opensns.forumn.service.status;

import java.util.ArrayList;
import java.util.List;

public class Shard {
	private int id = 0;
	private String name;
	private String state;
	private List<Node> nodes;
	private Collection parent;
	
	public Shard(String name, String state, List<Node> nodes) {
		super();
		this.name = name;
		this.state = state;
		this.nodes = nodes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shard() {
		super();
		init();
	}
	
	public void init() {
		nodes = new ArrayList<Node>();
	}
	
	public Shard(Collection collection, String name) {
		this.name = name;
		this.parent = collection;
		init();
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
}
