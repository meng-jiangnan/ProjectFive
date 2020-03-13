package com.accp.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.UsersMapper;
import com.accp.pojo.Users;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UsersBiz {
		
	@Resource
	private UsersMapper dao;
	
	//用户名注册验证
	public  Integer provingByName(String userName) {
		QueryWrapper<Users> qw  = Wrappers.query();
		qw.eq("uname", userName);
		return dao.selectCount(qw);
	}
	
	//身份证注册验证
	public  Integer provingByIdCard(String idCard) {
		QueryWrapper<Users> qw  = Wrappers.query();
		qw.eq("uidcard", idCard);
		return dao.selectCount(qw);
	}
	
	//注册
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int register(Users user) {
		return dao.insert(user);
	}
	
	//登录
	public Users loginByUser(String userName,String  userPwd) {
		QueryWrapper<Users> qw  = Wrappers.query();
		qw.eq("uname", userName).eq("upwd", userPwd);
		return dao.selectOne(qw);
	}
	
	
	
}
