package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.AuctionMapper;
import com.accp.dao.UsersMapper;
import com.accp.dao.WaresMapper;
import com.accp.pojo.Auction;
import com.accp.pojo.Users;
import com.accp.pojo.Wares;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class WaresBiz {

	@Resource
	private WaresMapper dao;

	@Resource
	private AuctionMapper adao;

	@Resource
	private UsersMapper udao;

	// 新增
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addWare(Wares ware) {
		return dao.insert(ware);
	}

	// 条件查询
	public PageInfo<Wares> queryByTerm(Wares ware, Integer currentPage, Integer pageSize, Integer status) {
		if (currentPage != null&&pageSize!=null) {
			PageHelper.startPage(currentPage, pageSize);
		}
		QueryWrapper<Wares> qw = Wrappers.query();
		if (ware.getWarname() != null) {
			qw.like("warname", ware.getWarname());
		}
		if (ware.getDepict() != null) {
			qw.like("depict", ware.getDepict());
		}
		if (ware.getStarttime() != null) {
			qw.eq("starttime", ware.getStarttime());
		}
		if (ware.getEndtime() != null) {
			qw.eq("endtime", ware.getEndtime());
		}
		if (ware.getStartprice() != null) {
			qw.gt("startprice", ware.getStartprice());
		}
		List<Wares> list=null;
		if (ware.getState() != null) {
			qw.eq("state", ware.getState());
			list = dao.selectList(qw);
			if (status!=null&&status==1) {
				
				list.forEach(temp -> {
					QueryWrapper<Auction> qw1 = Wrappers.query();
					temp.setList(adao.selectList(qw1.eq("wareid", temp.getWareid())));
				});
			} else if(status!=null&&status==0){
			
				list.forEach(temp -> {
					QueryWrapper<Users> qw1 = Wrappers.query();
					temp.setUname(udao.selectOne(qw1.eq("userid", temp.getUserid())).getUname());
				});
			}
		}else {
			list = dao.selectList(qw);
		}
		return new PageInfo<Wares>(list);
	}

	// 查询单个
	public Wares queryBiId(int Bid) {
		QueryWrapper<Wares> qw = Wrappers.query();
		return dao.selectOne(qw.eq("wareid", Bid));
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int modifyById(Wares ware) {
		QueryWrapper<Auction> qw = Wrappers.query();
		adao.delete(qw.eq("wareid", ware.getWareid()));
		return dao.updateById(ware);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int modifyByAll(Wares ware) {
		return dao.updateById(ware);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int removeByid(Integer wareid) {
		QueryWrapper<Auction> qw = Wrappers.query();
		adao.delete(qw.eq("wareid", wareid));
		return dao.deleteById(wareid);
	}
}
