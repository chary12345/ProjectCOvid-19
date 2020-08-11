package com.pojo;

public class Account {
	private String user;
	private String password;
	private String senderid;
	private Integer channel;
	private Integer DCS;
	private String schedtime;
	private String groupid;

	public final String getUser() {
		return user;
	}

	public final void setUser(String user) {
		this.user = user;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getSenderid() {
		return senderid;
	}

	public final void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public final Integer getChannel() {
		return channel;
	}

	public final void setChannel(Integer channel) {
		this.channel = channel;
	}

	public final Integer getDCS() {
		return DCS;
	}

	public final void setDCS(Integer dCS) {
		DCS = dCS;
	}

	public final String getSchedtime() {
		return schedtime;
	}

	public final void setSchedtime(String schedtime) {
		this.schedtime = schedtime;
	}

	public final String getGroupid() {
		return groupid;
	}

	public final void setGroupid(String groupid) {
		this.groupid = groupid;
	}

}
