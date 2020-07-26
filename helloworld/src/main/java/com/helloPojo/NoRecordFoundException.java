package com.helloPojo;

public class NoRecordFoundException  extends Exception{
	public String message;
	
	
	

	public NoRecordFoundException(String message) {
		super();
		this.message = message;
	}




	@Override
	public String toString() {
		return  message ;
	}
	

}
