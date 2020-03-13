package com.accp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

@TableName("Wares")
public class Wares {
	@TableId(type = IdType.AUTO,value = "wareid")
	private Integer wareid;
	private Integer userid;
	private String warname;
	private Float startprice;
	private Float floorprice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date starttime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endtime;
	private String src;
	private String depict;
	private Integer state;
	@TableField(exist = false)
	private List<Auction> list= new ArrayList<Auction>(0);
	@TableField(exist = false)
	private String uname;
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<Auction> getList() {
		return list;
	}
	public void setList(List<Auction> list) {
		this.list = list;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public String getWarname() {
		return warname;
	}
	public void setWarname(String warname) {
		this.warname = warname;
	}
	public Float getStartprice() {
		return startprice;
	}
	public void setStartprice(Float startprice) {
		this.startprice = startprice;
	}
	public Float getFloorprice() {
		return floorprice;
	}
	public void setFloorprice(Float floorprice) {
		this.floorprice = floorprice;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
}
