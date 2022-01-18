package com.ibm.cars.bean;

import java.util.Date;



public class PreUpldAuditRequestBean {
	private String mcn;
    private String action_code ;
    private Date date;
    private String userName ;
	public String getMcn() {
		return mcn;
	}
	public void setMcn(String mcn) {
		this.mcn = mcn;
	}
	public String getAction_code() {
		return action_code;
	}
	public void setAction_code(String action_code) {
		this.action_code = action_code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
