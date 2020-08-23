package com.helloworld;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
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
	
	//welcome page 
	@RequestMapping(value = "/wishuser", method = RequestMethod.GET)
	public String helloWorld() {
		System.out.println("action enters into hello world method");
		return "hello";
		
	}//registering user details from hello.jsp
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public String saveUser(UserPojo user,Model m) {
		System.out.println("user name :"+user.getEmail()+"-------"+"user password after encrpted"+user.getPsw());
		System.out.println("enters into save user method");
		System.out.println("email : "+user.getEmail());
		try {
			
			dao.saveUser(user);
			System.out.println("data saved here at controller");
		}catch (ConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("record already stored");
			m.addAttribute("noRecord", "Student Email ALready Registerd");
		}

		List<UserPojo> users = dao.searchAllUser(user);
	
		
		m.addAttribute("user",users);
		System.out.println("exit from saveUser method");
		return "Profile";
		
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String logUser(UserPojo user1,@RequestParam("email") String email,@RequestParam("generatedPassword") String generatedPassword, Model m) {
		
		user1.setPsw(generatedPassword);
		 List loguser = dao.loguser(email, user1.getPsw());
		if(loguser.isEmpty()) {
			m.addAttribute("noRecord", "invalid credentials");
			return "login";
		}
		System.out.println("enters into logUser method");
		System.out.println("email : "+email);
		m.addAttribute("user",loguser);
		System.out.println("exit from logUser method");
        return "Profile";
		
	}
	//search user only one user details from profile.jsp
	@SuppressWarnings("unused")
	@RequestMapping(value = "/fetchAll" ,method = RequestMethod.POST)
	public String searchAllUser(UserPojo user, Model m) {
		System.out.println("enteres into Search user Method");
		if(user==null) {
			System.out.println("please enter record");
			m.addAttribute("noRecord"," please enter any user name");
			return "Profile";
		}
		List<UserPojo> list=null;
		
		try {
			 list = dao.searchAllUser(user);
			if(list.isEmpty()) {
				//customize exception handling
				throw new NoRecordFoundException(" no record found");
			}else {
				m.addAttribute("user", list);
				System.out.println("1 ->method Close search User");

				return "Profile";
			}
			
			
				
		}catch (NoRecordFoundException e) {
			m.addAttribute("noRecord", e);
			System.out.println("2 ->method Close search User");
			return "Profile";
		}
		
		
		
		
		
	}@RequestMapping(value = "/searchByEmail" ,method = RequestMethod.POST)
	public String searchUser(@RequestParam("mobile") String mobile, Model m) {
		System.out.println("enteres into Search user Method");
		if(mobile==null) {
			System.out.println("please enter record");
			m.addAttribute("noRecord"," please enter any user name");
			return "Profile";
		}
		List<UserPojo> list=null;
		
		try {
			 list = dao.searchUser(mobile);
			if(list.isEmpty()) {
				//customize exception handling
				throw new NoRecordFoundException(" no record found");
			}else {
				m.addAttribute("user", list);
				System.out.println("1 ->method Close search User");

				return "Profile";
			}
			
				
		}catch (NoRecordFoundException e) {
			m.addAttribute("noRecord", mobile
				+e);
			System.out.println("2 ->method Close search User");
			return "Profile";
		}

}}
