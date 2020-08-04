package com.helloPojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UserPojo {
	@Id
	private String email;
	private String psw;
	@Transient
	private String psw_repeat;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getPsw_repeat() {
		return psw_repeat;
	}
	public void setPsw_repeat(String psw_repeat) {
		this.psw_repeat = psw_repeat;
	}
	
	private String dob;
	private String mobile;
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
