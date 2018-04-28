/**
 * 
 */
package com.calm.spring.db.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.calm.spring.utils.StringUtil;

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
public class RedisObjectSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serializingConverter = new SerializingConverter();
	private Converter<byte[], Object> deserializingConverter = new DeserializingConverter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.redis.serializer.RedisSerializer#deserialize(byte[])
	 */
	@Override
	public Object deserialize(byte[] arg0) throws SerializationException {
		if (StringUtil.isByteEmpty(arg0)) {
			return null;
		}
		return deserializingConverter.convert(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.redis.serializer.RedisSerializer#serialize(java.lang
	 * .Object)
	 */
	@Override
	public byte[] serialize(Object arg0) throws SerializationException {
		if (arg0 == null) {
			return StringUtil.EMPTY_BYTE_ARRAY;
		}
		return serializingConverter.convert(arg0);
	}

}
