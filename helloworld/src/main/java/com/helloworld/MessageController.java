package com.helloworld;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.Idao.Idao;

@Controller
public class MessageController {
	@Autowired
	Idao dao;
	@PostMapping("/alert")
	public String alertSend(@PathParam("mobile") String mobile,Model m) {
		String url = "localhost:8081/rest/service?";
		dao.searchUser(mobile);
		System.out.println("mobile number : "+mobile);
		 url = url.concat(mobile);//http://localhost:8081/rest/service?mobile=8985202363
		 RestTemplate rt = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		 
		 m.addAttribute("alert",mobile+" alert Recived successfully.");
		return "Profile";
		
	}

}
