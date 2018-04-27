/**
 * 
 */
package com.calm.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.calm.spring.entity.User;
import com.calm.spring.service.UserRepository;
import com.calm.spring.service.mapper.UserMapper;

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
@Sql(scripts = "classpath:sql/user.sql")
public class UserServiceTest extends CalmBaseTransactionContextTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testMongodb() {
		User user = userRepository.findByUserName("test");
		Assert.assertNotNull(user);
	}

	@Test
	public void testMyBatis() {
		/*
		 * Integer count = userMapper.getUserCount(); Assert.assertNotNull(count);
		 * 
		 * Map<String, Object> map = new HashMap<>(2); map.put("userName", "t");
		 * map.put("id", "231"); Assert.assertTrue(userMapper.updateName(map));
		 * 
		 * userMapper.delete((long) 231);
		 */

		List<User> users = userMapper.getAllUsers();
		Assert.assertNotNull(users);
	}
}
