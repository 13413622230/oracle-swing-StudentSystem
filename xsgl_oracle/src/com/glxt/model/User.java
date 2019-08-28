package com.glxt.model;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String pw;
	private int type;
	public User(String id,String pw){
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
