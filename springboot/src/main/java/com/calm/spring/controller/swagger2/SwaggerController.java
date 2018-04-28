/**
 * 
 */
package com.calm.spring.controller.swagger2;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

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
@RestController
@RequestMapping("swagger")
public class SwaggerController {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Value("${calm}")
	private String name;

	/**
	 * 测试Swagger
	 * 
	 * @param
	 * @return
	 */
	@ApiOperation(value = "测试Swagger", notes = "测试Swagger")
//	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("")
	public String test() {
		logger.info("swagger:{}", name);
		return "swagger...";
	}
	/*
	 * @Api：修饰整个类，描述Controller的作用
	 * 
	 * @ApiOperation：描述一个类的一个方法，或者说一个接口
	 * 
	 * @ApiParam：单个参数描述
	 * 
	 * @ApiModel：用对象来接收参数
	 * 
	 * @ApiProperty：用对象接收参数时，描述对象的一个字段
	 * 
	 * @ApiResponse：HTTP响应其中1个描述
	 * 
	 * @ApiResponses：HTTP响应整体描述
	 * 
	 * @ApiIgnore：使用该注解忽略这个API
	 * 
	 * @ApiError ：发生错误返回的信息
	 * 
	 * @ApiImplicitParam：一个请求参数
	 * 
	 * @ApiImplicitParams：多个请求参数
	 */
}
