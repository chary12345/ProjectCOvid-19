package com.pojo;

import java.util.List;

public class TextMsg {
	private Account Account;
	private List<Messages> Messages;

	public final Account getAccount() {
		return Account;
	}

	public final void setAccount(Account account) {
		Account = account;
	}

	public final List<Messages> getMessages() {
		return Messages;
	}

	public final void setMessages(List<Messages> messages) {
		Messages = messages;
	}
}

