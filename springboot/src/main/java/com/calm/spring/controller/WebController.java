/**
 * 
 */
package com.calm.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("web")
public class WebController {

	@GetMapping("")
	public String demoPage(Model model) throws Exception {
		model.addAttribute("calm", "this is thymeleaf...");
		return "test";
	}
}
