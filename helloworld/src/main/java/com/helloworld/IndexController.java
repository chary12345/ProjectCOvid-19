package com.helloworld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Idao.Idao;
import com.helloPojo.NoRecordFoundException;
import com.helloPojo.UserPojo;

@Controller
public class IndexController {//com.helloworld.IndexController
	@Autowired
	Idao dao;
	
	
	@RequestMapping(value = "/wishuser", method = RequestMethod.GET)
	public String helloWorld() {
		System.out.println("action enters into hello world method");
		return "hello";
		
	}
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public String saveUser(UserPojo user,Model m) {
		System.out.println("enters into save user method");
		System.out.println("email : "+user.getEmail());
		dao.saveUser(user);
		System.out.println("data saved here at controller");
		m.addAttribute("user",user.getEmail());
		System.out.println("exit from saveUser method");
		return "Profile";
		
	}
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String logUser(UserPojo user,Model m) {
		System.out.println("enters into logUser method");
		System.out.println("email : "+user.getEmail());
		m.addAttribute("user",user);
		System.out.println("exit from logUser method");
		return "Profile";
		
	}
	@SuppressWarnings("unused")
	@RequestMapping(value = "/searchByEmail" ,method = RequestMethod.POST)
	public String searchUser(@RequestParam("email") String email, Model m) {
		System.out.println("enteres into Search user Method");
		if(email==null) {
			System.out.println("please enter record");
			m.addAttribute("noRecord"," please enter any user name");
			return "Profile";
		}
		List<UserPojo> list=null;
		
		try {
			 list = dao.searchUser(email);
			if(list.isEmpty()) {
				//customize exception handling
				throw new NoRecordFoundException(" no record found");
			}else {
				m.addAttribute("users", list);
				System.out.println("1 ->method Close search User");

				return "Profile";
			}
				
		}catch (NoRecordFoundException e) {
			m.addAttribute("noRecord", email+e);
			System.out.println("2 ->method Close search User");
			return "Profile";
		}
		
		
		
		
		
	}

}
