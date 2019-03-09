package com.example.eurekademo.csrf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * eureka服务端添加security验证之后，client注册失败 cannot execute any request on any know
 * server
 * 
 * 新版本的security默认开启csrf了，关掉就好了
 *
 *
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // 关闭csrf
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); // 开启认证
	}
}