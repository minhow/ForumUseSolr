package com.opensns.forumn.common;

public class JStringUtil {
	//특수문자를 제거한다.
	public static String removeSpecialLetter(String str) {
		int str_length = str.length();
		String strlistchar = "";
		String str_imsi = "";
		String[] filter_word = { "", "\\.", "\\?", "\\/", "\\~", "\\!", "\\@",
				"\\#", "\\$", "\\%", "\\^", "\\&", "\\*", "\\(", "\\)", "\\_",
				"\\+", "\\=", "\\|", "\\\\", "\\}", "\\]", "\\{", "\\[",
				"\\\"", "\\'", "\\:", "\\;", "\\<", "\\,", "\\>", "\\.", "\\?",
				"\\/" };
		for (int i = 0; i < filter_word.length; i++) {
			str_imsi = str.replaceAll(filter_word[i], "");
			str = str_imsi;
		}
		return str;
	}
}
