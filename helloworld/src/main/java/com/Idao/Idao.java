package com.Idao;

import java.util.List;

import com.helloPojo.UserPojo;

public interface Idao {
	public void saveUser(UserPojo user);
	public List<UserPojo> searchUser(String email
			);
	public List<UserPojo> searchAllUser(UserPojo user);
	public List<UserPojo> loguser(String email, String psw);
	

}
