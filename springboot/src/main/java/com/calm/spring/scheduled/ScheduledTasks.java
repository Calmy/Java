/**
 * 
 */
package com.calm.spring.scheduled;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.calm.spring.utils.DateUtil;

/**
 * 
 * <pre>
 * 定时任务 。
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
//@EnableScheduling
@Component
public class ScheduledTasks {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

//	@Scheduled(fixedDelay = 5000)
	public void testScheduledTasks() {
		logger.info("{}执行一次...",DateUtil.TIMEFORMAT.format(new Date()));
	}
}
