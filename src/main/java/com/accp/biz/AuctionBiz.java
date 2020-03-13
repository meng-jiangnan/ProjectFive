package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.AuctionMapper;
import com.accp.pojo.Auction;
import com.accp.pojo.Wares;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class AuctionBiz {
		
	@Resource
	private AuctionMapper dao;
	
	public List<Auction>  queryByWareid(Integer wareid){
		QueryWrapper<Auction> qw= Wrappers.query();
		return dao.selectList(qw.eq("wareid", wareid).orderByDesc("time"));
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int  addAu(Auction au) {
		return dao.insert(au);
	}
	
}
