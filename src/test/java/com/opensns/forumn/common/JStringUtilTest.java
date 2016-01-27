package com.opensns.forumn.common;

import junit.framework.TestCase;

public class JStringUtilTest extends TestCase{
	public void testRemoveSpecialLetter(){
		String str=JStringUtil.removeSpecialLetter("가나다라 마바사 :=89");
		assertEquals("가나다라 마바사 89", str);
	}
}
