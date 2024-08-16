package com.nikhil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userinfo")
public class userinfo 
{
	@Id
	@Column(name="UID")
	private Integer uid;
	@Column(name="UName")
	private String uname;
	@Column(name="UCity")
	private String ucity;
	
	public userinfo()
	{
		System.out.println("Zero param Constructor for Hibernate");
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	@Override
	public String toString() {
		return "userinfo [uid=" + uid + ", uname=" + uname + ", ucity=" + ucity + "]";
	}

}
