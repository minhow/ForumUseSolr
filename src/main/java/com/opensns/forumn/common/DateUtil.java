package com.opensns.forumn.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class DateUtil {
	public static String getCurrentDate() {
		java.util.Date dateNow = Calendar.getInstance(
				new SimpleTimeZone(0x1ee6280, "KST")).getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd",
				Locale.getDefault());
		return formatter.format(dateNow);
	}

	public static String getMonthAgoDate() {
		Calendar cal = Calendar
				.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
		cal.add(Calendar.MONTH, -1); // �Ѵ��� ��¥ ��������
		java.util.Date monthago = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd",
				Locale.getDefault());
		return formatter.format(monthago);
	}

	public static String get7DayAgoDate() {
		Calendar cal = Calendar
				.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
		cal.add(Calendar.DATE, -7);
		java.util.Date weekago = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd",
				Locale.getDefault());
		return formatter.format(weekago);
	}

	public static String get1YearAgoDate() {
		Calendar cal = Calendar
				.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
		cal.add(Calendar.YEAR, -1);
		java.util.Date weekago = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd",
				Locale.getDefault());
		return formatter.format(weekago);
	}
}
