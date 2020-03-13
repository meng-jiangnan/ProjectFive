package com.accp.clg;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = { "com.accp.dao" })
public class BeansConfig {
	

}
