/**
 * 
 */
package com.calm.spring.mq;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
@RabbitListener(queues = "hello")
public class RabbitMQReciever {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@RabbitHandler
	public void process(String msg) {
		logger.info("Reciever:{}", msg);
	}
}
