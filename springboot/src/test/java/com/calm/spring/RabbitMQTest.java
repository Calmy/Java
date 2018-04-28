/**
 * 
 */
package com.calm.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.calm.spring.mq.RabbitMQSender;

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
public class RabbitMQTest extends CalmBaseTransactionContextTest {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@Test
	public void testSend() {
		rabbitMQSender.send();
	}

	@Test
	public void testReciever() {
		//rabbitMQSender.
	}
}
