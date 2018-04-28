/**
 * 
 */
package com.calm.spring.mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send() {
		String msg = "hello mq!" + new Date();
		// arg0 为队列名 ，arg1为值
		amqpTemplate.convertAndSend("hello", msg);
		System.out.println(msg);
	}
}
