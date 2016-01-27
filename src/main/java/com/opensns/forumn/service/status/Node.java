package com.opensns.forumn.service.status;

public class Node {
	private int id = 0;
	private String state;
	private String nodeName;
	private String core;
	private boolean leader = false;
	private String baseUrl;
	private Shard parent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	public boolean isLeader() {
		return leader;
	}
	public void setLeader(boolean leader) {
		this.leader = leader;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public Node(String name, String state) {
		super();
		this.nodeName = name;
		this.state = state;
		init();
	}
	public Node() {
		super();
		init();
	}
	
	public void init() {
		
	}
	
	public Node(Shard shard, String name) {
		this.nodeName = name;
		this.parent = shard;
		init();
	}
	public String getName() {
		return nodeName;
	}
	public void setName(String name) {
		this.nodeName = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
