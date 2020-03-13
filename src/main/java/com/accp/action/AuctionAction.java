package com.accp.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.AuctionBiz;
import com.accp.biz.WaresBiz;
import com.accp.pojo.Auction;
import com.accp.pojo.Users;
import com.accp.pojo.Wares;

@RestController
@RequestMapping("/api/auction")
public class AuctionAction {
	
	@Resource
	private  AuctionBiz biz;
	
	@Resource
	private  WaresBiz ab;
		
	@PostMapping("add")
	public  String  add(HttpSession session,Auction au) {
		Users user= (Users)session.getAttribute("user");
		Wares ware=ab.queryBiId(au.getWareid());
		if(ware.getFloorprice()>=au.getPrice()) {
			return "no";
		}else {
			au.setTime(new Date());
			au.setUserid(user.getUserid());
			au.setUname(user.getUname());
			biz.addAu(au);
			//更新底价
			ware.setFloorprice(au.getPrice());
			ab.modifyByAll(ware);
			return "ok";
		}
	}
}
