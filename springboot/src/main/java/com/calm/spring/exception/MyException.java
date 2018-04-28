
package com.calm.spring.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
//@ControllerAdvice
public class MyException {
	public static final String DEFAULT_ERROR_VIEW = "error";

	/*@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}*/

	@ExceptionHandler(value = CalmException.class)
	@ResponseBody
	public ErrorInfo<String> RestErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("data...");
		errorInfo.setMessage("msg...");
		errorInfo.setUrl(req.getRequestURI());
		return errorInfo;
	}
}
