/**
 * 
 */
package com.calm.spring;

import java.io.File;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

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
public class MailTest extends CalmBaseTransactionContextTest {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@SuppressWarnings("deprecation")
	@Test
	public void testMail() throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("903947422@qq.com");
		message.setTo("3162623078@qq.com");
		message.setSubject("简单邮件");
		message.setText("这是邮件内容");
		mailSender.send(message);
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("903947422@qq.com");
		helper.setTo("3162623078@qq.com");
		helper.setSubject("主题：有附件");
		// 嵌入静态资源
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);
		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addInline("weixin", file);
		// 附件
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		//内容动态替换
		HashMap<String, Object> map = new HashMap<>(2);
		map.put("userName", "calm");
		VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine , "notify.vm", "UTF-8", map);
		
		mailSender.send(mimeMessage);
	}
	
	
}
