/**
 * 
 */
package com.calm.spring.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping
public class JsonController {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Value("${calm}")
	private String name;

	@GetMapping("")
	public String test() {
		logger.info("info-name:{}", name);
		logger.debug("debug-name:{}", name);
		logger.error("error-name:{}", name);
		return "ok...";
	}

	@PostMapping("")
	public String testPost() {
		logger.info("info-name:{}", name);
		logger.debug("debug-name:{}", name);
		logger.error("error-name:{}", name);
		return "ok...";
	}
}
