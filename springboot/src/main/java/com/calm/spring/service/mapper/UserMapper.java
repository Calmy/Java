/**
 * 
 */
package com.calm.spring.service.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.calm.spring.entity.User;

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
 *    修改后版本:     修改人：  	修改日期:     修改内容:
 *          </pre>
 */
@Mapper
public interface UserMapper {

	Integer getUserCount();

	@Update("UPDATE sys_user SET name=#{userName} WHERE id=#{id}")
	boolean updateName(Map<String, Object> map);

	@Delete("DELETE FROM sys_user WHERE id =#{id}")
	boolean delete(Long id);

	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "userName") })
	@Select("select id,name from sys_user")
	List<User> getAllUsers();
}
