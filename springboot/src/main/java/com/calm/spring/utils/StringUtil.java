/**
 * 
 */
package com.calm.spring.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <pre>
 * 。
 * </pre>
 * 
 * @author chenzhuo
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 */
public class StringUtil extends StringUtils {

	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

	public static boolean isByteEmpty(byte[] b) {
		if (b == null || b.length == 0) {
			return true;
		}
		return false;
	}

}
