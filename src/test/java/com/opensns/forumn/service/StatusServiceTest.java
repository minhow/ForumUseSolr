package com.opensns.forumn.service;

import org.json.simple.JSONObject;

import com.opensns.forumn.service.status.Collection;

public class StatusServiceTest {
	public static void main(String[] args) {
		StatusService service = new StatusService();
		Collection collection = service.getClusterStatus();
		JSONObject jsonElements = collection.toCyElementsJson();
		System.out.println(jsonElements.toJSONString());
	}
}
