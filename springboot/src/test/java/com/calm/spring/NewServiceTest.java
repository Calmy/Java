/**
 * 
 */
package com.calm.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.calm.spring.entity.User;
import com.calm.spring.service.NewsJpaService;
import com.calm.spring.service.NewsService;

import junit.framework.Assert;


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
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewServiceTest {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsJpaService newsJpaService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	@Value("${calm}")
	private String calm;

	@Test
	public void testGetNewsCount() {
		logger.info("calm:{}-count:{}", calm, newsService.getNewsCount());
	}

	@Test
	public void testNewsJpaService() {
		logger.info("newsJpaService:{}", newsJpaService.findByTitle("维格娜丝时装股份有限公司"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testStringRedisTemplate() {
		stringRedisTemplate.opsForValue().set("redis", "calm");
		Assert.assertEquals("calm", stringRedisTemplate.opsForValue().get("redis"));
	}
	
	@Test
	public void testRedisTemplate() {
		redisTemplate.opsForValue().set("testRedis", new User("111", "testRedis"));
		Assert.assertEquals("testRedis", redisTemplate.opsForValue().get("testRedis").getUserName());
	}
}
