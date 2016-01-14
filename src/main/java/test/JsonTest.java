package test;

import com.opensns.forumn.common.DateUtil;

public class JsonTest {
	public static void main(String[] args) throws Exception {
		System.out.println(DateUtil.getCurrentDate());
		System.out.println(DateUtil.get7DayAgoDate());
		System.out.println(DateUtil.getMonthAgoDate());				
	}
}
