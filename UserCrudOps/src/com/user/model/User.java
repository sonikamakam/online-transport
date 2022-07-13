package com.user.model;

public class User {
	private int id;
	private String name;
	private String uname;
	private String password;
	private int contactno;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", uname=" + uname + ", password=" + password + ", contactno="
				+ contactno + "]";
	}
	public User(int id,String name,String uname,String password, int contactno)
	{
		super();
		this.id=id;
		this.name=name;
		this.uname=uname;
		this.password=password;
		this.contactno=contactno;
		
	}
}
