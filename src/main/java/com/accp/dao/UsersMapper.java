package com.accp.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UsersMapper extends BaseMapper<Users>{

	
}
