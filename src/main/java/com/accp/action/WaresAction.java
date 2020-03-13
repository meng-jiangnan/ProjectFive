package com.accp.action;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.AuctionBiz;
import com.accp.biz.WaresBiz;
import com.accp.pojo.Wares;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/wares")
public class WaresAction {
	
	@Resource
	private WaresBiz biz;
	
	@Resource
	private AuctionBiz ab;
	
	@PostMapping("addWare")
	public  void addWare(Wares ware) {
		biz.addWare(ware);
	}
	
	@PostMapping("queryTerm")
	public  PageInfo<Wares> queryTerm(Wares ware, Integer currentPage, Integer pageSize,Integer status){
		return biz.queryByTerm(ware, currentPage, pageSize,status);
	}
	
	
	@GetMapping("queryOne/{wareid}")
	public  Wares queryOne(@PathVariable Integer wareid){
		Wares ware =biz.queryBiId(wareid);
		ware.setList(ab.queryByWareid(wareid));
		return ware;
	}
	
	@GetMapping("remove/{wareid}")
	public  String remove  (@PathVariable Integer wareid){
		biz.removeByid(wareid);
		return "ok";
	}
	
	@PostMapping("modifyware")
	public  void modifyware(Wares ware) {
		biz.modifyById(ware);
	}
	
	@GetMapping("modifyStatus/{wareid}")
	public  String modifyStatus  (@PathVariable Integer wareid){
		Wares ware =biz.queryBiId(wareid);
		if(new Date().before(ware.getEndtime())) {
			return "ok";
		}else {
			ware.setState(0);
			biz.modifyByAll(ware);
			return  "no";
		}
		
	}
	 
}
