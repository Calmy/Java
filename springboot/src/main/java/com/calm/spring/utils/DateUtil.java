/**
 * 
 */
package com.calm.spring.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DateUtils;

/**
 * 
 * <pre>
 * 日期工具类 。
 * </pre>
 * 
 * @author chenzhuo
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class DateUtil extends DateUtils{

	/**
	 * yyyy-MM-dd
	 */
	public static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * HH-mm-ss
	 */
	public static final DateFormat TIMEFORMAT = new SimpleDateFormat("HH-mm-ss");
}
