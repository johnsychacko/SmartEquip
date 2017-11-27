package com.smart.equip.utils;

import java.io.Serializable;
/*
 * DTO implementation for the response 
 * Version: 1.0 
 * @author Johnsy
 */


public class Response implements Serializable {

	private static final long serialVersionUID = 1247126400996602399L;

	//----------------------------------------------- Attributes --------------------------------------------
	private int operationCode;
	private String message;
	private boolean dataAvailable;
	private Object data;
	
	//--------------------------------------------------------------------------------------------------------
	
	public int getOperationCode() {
		return operationCode;
	}
	public void setOperationCode(int operationCode) {
		this.operationCode = operationCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isDataAvailable() {
		return dataAvailable;
	}
	public void setDataAvailable(boolean dataAvailable) {
		this.dataAvailable = dataAvailable;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
