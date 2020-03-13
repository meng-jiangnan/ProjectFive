package com.accp.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.UsersBiz;
import com.accp.pojo.Users;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@RestController
@RequestMapping("/api/user")
public class UsersAction {

	@Resource
	private UsersBiz biz;

	// 用户名注册验证
	@GetMapping("provingByName")
	public Integer provingByName(String userName) {
		return biz.provingByName(userName);
	}

	// 身份证注册验证
	@GetMapping("provingByIdCard")
	public Integer provingByIdCard(String idCard) {
		return biz.provingByIdCard(idCard);
	}

	// 注册
	@PostMapping("register")
	public int register(@RequestBody Users user) {
		System.out.println(user.getUname());
		return biz.register(user);
	}

	// 登录
	@GetMapping("login")
	public Object loginByUser(HttpSession session, String userName, String userPwd) {
		Users user = biz.loginByUser(userName, userPwd);
		if (user != null) {
			session.setAttribute("user", user);
			return user;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("power", "no");
			return map;
		}
	}
	
	//退出
	@PostMapping("exit")
	public  void exitUser(HttpSession session) {
		session.removeAttribute("user");
	}
}
