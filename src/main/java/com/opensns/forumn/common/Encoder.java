package com.opensns.forumn.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Encoder {
	public static String encodingQueryToUTF8(String q){
		try {
			return URLEncoder.encode(q, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
