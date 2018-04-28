/**
 * 
 */
package com.calm.spring.service.async;

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
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
public class AsyncTasks {
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	private static Random random = new Random();
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Async("taskExecutor")
	public void doTask1() throws InterruptedException {
		logger.info("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		logger.info("stringRedisTemplate:{}",stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		logger.info("完成任务一，耗时：{}毫秒", end - start);

	}

	@Async("taskExecutor")
	public Future<String> doTask2() throws InterruptedException {
		logger.info("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		logger.info("stringRedisTemplate:{}",stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		logger.info("完成任务二，耗时：{}毫秒", end - start);
		return new AsyncResult<>("任务二完成");
	}

	@Async("taskExecutor")
	public Future<String> doTask3() throws Exception {
		logger.info("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		logger.info("stringRedisTemplate:{}",stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		logger.info("完成任务三，耗时：{}毫秒", end - start);
		return new AsyncResult<>("任务三完成");
	}
}
