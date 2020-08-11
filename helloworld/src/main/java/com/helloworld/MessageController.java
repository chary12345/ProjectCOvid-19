package com.helloworld;

import java.util.List;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.Idao.Idao;
import com.helloPojo.UserPojo;

@Controller
public class MessageController {
	@Autowired
	Idao dao;
	@PostMapping("/")
	public String alertSend(@PathParam("mobile") String mobile,Model m) {
		String url = "localhost:8081/rest/service?";
		List<UserPojo> user = dao.searchUser(mobile);
		System.out.println("mobile number : "+mobile);
		 url = url.concat(user.get(0).getMobile());//http://localhost:8081/rest/service?mobile=8985202363
		 RestTemplate restTemplate = new RestTemplate();

			
		 m.addAttribute("alert",mobile+" alert Recived successfully.");
		return "Profile";
		
	}

}
