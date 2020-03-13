package com.accp.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("auction")
public class Auction {
	
	@TableId(type = IdType.AUTO,value = "aid")
	private Integer aid;
	private Integer wareid;
	private Integer userid;
	private Float price;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date time;
	private String uname;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getWareid() {
		return wareid;
	}
	public void setWareid(Integer wareid) {
		this.wareid = wareid;
	}

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
