/**
 * 
 */
package com.calm.spring;

import java.util.concurrent.Future;

import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.calm.spring.service.async.AsyncTasks;

/**
 * 
 * <pre>
 * 异步 。
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
public class AsyncTest extends CalmBaseTransactionContextTest {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsyncTasks asyncTasks;

	/**
	 * 异步回调
	 * 
	 * @author chenzhuo
	 * @param void
	 * @throws Exception
	 * @throws InterruptedException
	 */
	@Test
	public void testAsynCall() throws InterruptedException, Exception {
		Future<String> task2 = asyncTasks.doTask2();
		Future<String> task3 = asyncTasks.doTask3();
		while (true) {
			if (task2.isDone() && task3.isDone()) {
				break;
			}
			Thread.sleep(1000);
		}
		logger.info("--------testAsynCall-----------");
	}

	/**
	 * 异步
	 * 
	 * @author chenzhuo
	 * @param void
	 */
	@Test
	public void testAsyn() {
		try {
			asyncTasks.doTask1();
			asyncTasks.doTask2();
			asyncTasks.doTask3();
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("--------testAsyn-----------");
	}

	/**
	 * 同步执行
	 * 
	 * @author chenzhuo
	 * @param void
	 */
	@Test
	public void testSequence() {
		try {
			asyncTasks.doTask1();
			asyncTasks.doTask2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("--------testSequence-----------");
	}

	/**
	 * 测试高并发
	  * @author chenzhuo
	  * @param 
	  * void
	 * @throws Exception 
	 */
	@Test
	public void testConCurrent() throws Exception {
		for (int i = 0; i < 1000; i++) {
			try {
				asyncTasks.doTask3();
				asyncTasks.doTask2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 199) {
				System.exit(0);
			}
		}
		logger.info("--------{}-----------",this.getClass());
	}
	
	
}
