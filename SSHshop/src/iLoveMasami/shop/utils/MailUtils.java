package iLoveMasami.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * 
 * @author iLoveMasami
 * @date 2018年1月24日 下午7:43:44
 */
public class MailUtils {
	/**
	 * 发送邮件的方法
	 * 
	 * @param to：收件人
	 * @param code：激活码
	 */
	public static void sendMail(String to, String code) {

		// 1.获得Session对象
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", "smtp.126.com");// 发件人的邮箱的 SMTP服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		
		String fromAdd = "yzZhu19940228@126.com"; //发送的邮箱（服务器）	
		String password = "iLoveMasami1314";//126邮箱的授权码
		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(fromAdd, password);
			}

		};
		Session session = Session.getInstance(props, authenticator);//authenticator：认证
		// 2.创建一个代表邮件的对象Message
		Message message = new MimeMessage(session);
		try {
			// 设置发件人
			message.setFrom(new InternetAddress(fromAdd));
			//设置收件人  抄送CC  暗送BCC
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//设置标题
			message.setSubject("来自东南购物商场的官方激活邮件");
			//设置正文     这里IP地址使用的是内网地址
			message.setContent("<h1>东南购物商场的官方激活邮件！点下方链接完成激活操作</h1><h3><a href='http://127.0.0.1:8080/SSHshop/user_active.action?code="+code+"'>http://10.4.32.165:8080/SSHshop/user_active.action?code="+code+"</a></h3>", 
					"text/html;charset=UTF-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			// 3.发送邮件Transport
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
