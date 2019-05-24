package com.sql.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类，一般工具类里的方法都是静态方法
 * 
 * 时间工具类
 */
public class DateUtil {

	/**
	 * 获取日期时间
	 * 
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static String getDateStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	/**
	 * 获取时间
	 * 
	 * @return
	 */
	public static String getTimeStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(date);
	}

}
