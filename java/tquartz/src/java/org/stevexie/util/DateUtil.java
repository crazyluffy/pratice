package org.stevexie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// 返回值格式：2017-01-05 18:00:34
	public static String currentDatetime() {
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return df.format(new Date());
	}
	
	public static void main(String args[]) {
		System.out.println(DateUtil.currentDatetime());
	}
}
