package com.message;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Idao.Idao;
import com.google.gson.Gson;
import com.helloPojo.UserPojo;
import com.pojo.Account;
import com.pojo.Messages;
import com.pojo.TextMsg;

@RestController
public class MessagingService {
	@Autowired
	Idao dao;
	//localhost:8081/rest/service
	@RequestMapping(value = "/alert",method = RequestMethod.POST)
	public String mobileSms(@RequestParam("mobile") String mobile ,Model m) {
		
		String text ="Dear CitiZen, Your request submitted successfully. Use Token No.U1S738472T to check status.";
		final String url = "https://www.smsgatewayhub.com/api/mt/SendSMS";
		
		Account account = new Account();
		account.setUser("Chary@123");
		account.setPassword("chary@123");
		account.setSenderid("SMSTST");
		account.setChannel(2);
		account.setDCS(0);
		
		Messages msg = new Messages();
		msg.setNumber("mobile="+mobile);
		msg.setText(text);
		
		List<Messages> mesgs = new ArrayList<Messages>();
		mesgs.add(msg);
		
		
		
		TextMsg input = new TextMsg();
		input.setAccount(account);
		input.setMessages(mesgs);
		
		Gson json = new Gson();
		String payload = json.toJson(input);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		System.out.println("mobile number : "+mobile);
		System.out.println("texted message : "+text);
		
		HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
		List<UserPojo> user = dao.searchUser(mobile);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		SmsResponse res = json.fromJson(exchange.getBody(), SmsResponse.class);
		m.addAttribute("data", res.getErrorCode());
		//m.addAttribute("user", user);
		return "Profile";
	}

}
