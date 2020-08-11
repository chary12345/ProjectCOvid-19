package com.message;

public class SmsResponse {
	private String ErrorCode;
	private String ErrorMessage;
	private String JobId;
	private MessageData MessageData;
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getJobId() {
		return JobId;
	}
	public void setJobId(String jobId) {
		JobId = jobId;
	}
	public MessageData getMessageData() {
		return MessageData;
	}
	public void setMessageData(MessageData messageData) {
		MessageData = messageData;
	}
	

}
