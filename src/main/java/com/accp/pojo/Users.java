package com.accp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("users")
public class Users {
	@TableId(type = IdType.AUTO,value = "userid")
	private Integer userid;
	private String uname;
	private String upwd;
	private String uidcard;
	private String uphone;
	private String uaddress;
	private String upost;
	private Integer upower;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUidcard() {
		return uidcard;
	}
	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUpost() {
		return upost;
	}
	public void setUpost(String upost) {
		this.upost = upost;
	}
	public Integer getUpower() {
		return upower;
	}
	public void setUpower(Integer upower) {
		this.upower = upower;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(String uname, String upwd, String uidcard, String uphone, String uaddress, String upost,
			Integer upower) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.uidcard = uidcard;
		this.uphone = uphone;
		this.uaddress = uaddress;
		this.upost = upost;
		this.upower = upower;
	}
	
	
}
