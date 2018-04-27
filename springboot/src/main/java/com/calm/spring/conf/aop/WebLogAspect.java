/**
 * 
 */
package com.calm.spring.conf.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * <pre>
 * AOP 切面 。
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
@Aspect
@Component
public class WebLogAspect {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * com.calm.spring.controller..*.*(..))")
	public void webLog() {

	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinpoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String isDebug = (String) request.getAttribute("debug");
		if (isDebug != null) {
			org.apache.log4j.Logger rootLogger = LogManager.getRootLogger();
			logger.info("动态改变日志级别:{}->{}", rootLogger.getLevel().toString(), "DEBUG");
			rootLogger.setLevel(Level.toLevel("DEBUG"));
		}
		logger.info("URL:{}", request.getRequestURL().toString());
		logger.info("Http Methon:{}", request.getMethod());
		logger.info("IP:{}", request.getRemoteAddr());
		logger.info("CLASS_METHOD:{}",
				joinpoint.getSignature().getDeclaringTypeName() + joinpoint.getSignature().getName());
		logger.info("ARGS :{}", Arrays.toString(joinpoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
	}
}
