package com.sjtu.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sjtu.constant.Constant;

public class EmailUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	private static final String CHARSET = "utf-8";
	private static boolean IS_DEBUG = true;
	private static String HOST = "stmp.163.com";
	private static String USER_NAME = "kargozhu@163.com";
	private static String PWD = "kargocard";
	
	public static boolean sendEmal(String subject, String htmlMsg, String from, String to) {
		List<String> toList = new ArrayList<String>();
		toList.add(to);
		return sendEmail(subject,htmlMsg,from,toList);
	}
	
	public static boolean sendEmail(String subject, String htmlMsg, String from, List<String> toList) {
		return sendEmail(subject,htmlMsg,from,toList,null,null);
	}
	
	public static boolean sendEmail(String subject,String htmlMsg,String from, List<String> toList, List<String> ccList, List<String> bccList) {
		return sendEmail(IS_DEBUG, CHARSET, HOST,USER_NAME,PWD, subject, htmlMsg, from, toList, ccList, bccList);
	}
	
	public static boolean sendEmail(boolean isDebug, String charset, String hostName,String username,String password,String subject, String htmlMsg, String from, List<String> toList, List<String> ccList, List<String> bccList) {
		System.setProperty("mail.mime.charset", charset);
		try
		{
			HtmlEmail email = new HtmlEmail();
			email.setDebug(isDebug);
			email.setHostName(hostName);
			email.setAuthentication(username, password);
			email.setFrom(from);
			if(toList != null) {
				for(String to : toList) {
					email.addTo(to);
				}
			}
			if(ccList != null) {
				for(String cc : ccList) {
					email.addCc(cc);
				}
			}
			if(bccList != null) {
				for(String bcc : bccList) {
					email.addBcc(bcc);
				}
			}
			email.setCharset(charset);
			email.setSubject(subject);
			email.setHtmlMsg(htmlMsg);
			email.send();
			return true;
		} catch(EmailException e) {
			LOGGER.error("sendEmail error: ",e);
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		Constant.GetParameters();
		
	}
}
