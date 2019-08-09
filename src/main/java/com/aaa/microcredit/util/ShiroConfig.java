package com.aaa.microcredit.util;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * className:ShiroConfig
 * discriptoin:
 * author:
 * createTime:2018-11-29 13:17
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		// 配置不会被拦截的链接 顺序判断
		//放开static resources
		/*filterChainDefinitionMap.put("/image/**", "anon");
		filterChainDefinitionMap.put("/staticDL/images/**", "anon");
		filterChainDefinitionMap.put("/staticDL/css/**", "anon");
		filterChainDefinitionMap.put("/asset/**", "anon");
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/staticDL/js/**", "anon");
		filterChainDefinitionMap.put("/script/**", "anon");
		filterChainDefinitionMap.put("/style/**", "anon");
		//验证token
		filterChainDefinitionMap.put("/checkToken", "anon");
		filterChainDefinitionMap.put("/staticDL/login/**", "anon");
		filterChainDefinitionMap.put("/staticDL/index.html", "anon");

		//未登录放开首页贷款信息
	*//*	filterChainDefinitionMap.put("/indexInformation","anon");
		filterChainDefinitionMap.put("/indexInformationDiYa","anon");
		//未登录放开常见问题
		filterChainDefinitionMap.put("/toproblem","anon");
		//前台公告放开
		filterChainDefinitionMap.put("/getNoteceListMap","anon");
		filterChainDefinitionMap.put("/toNoticelist","anon");
		//未登录放开贷款页信息
		filterChainDefinitionMap.put("/toInvest", "anon");
		filterChainDefinitionMap.put("/toBorrow", "anon");
		filterChainDefinitionMap.put("/toDetail", "anon");
		filterChainDefinitionMap.put("/invest", "anon");
		filterChainDefinitionMap.put("/investment", "anon");
		filterChainDefinitionMap.put("/investmentAmount", "anon");
		filterChainDefinitionMap.put("/investmentInformation", "anon");
		filterChainDefinitionMap.put("/user/**", "anon");
		filterChainDefinitionMap.put("/record/**", "anon");
		filterChainDefinitionMap.put("/getSessoinUserInfo", "anon");
		//未登录放开锦囊
		filterChainDefinitionMap.put("/tojinNang","anon");
		filterChainDefinitionMap.put("/getJinNangListMap","anon");
		filterChainDefinitionMap.put("/getJinNangXinXi","anon");
		filterChainDefinitionMap.put("/getCommentList","anon");*//*

		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
		shiroFilterFactoryBean.setLoginUrl("/emp/login.html");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/back-before-index.html");


		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");*/

		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");

		filterChainDefinitionMap.put("/**", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;

	}

	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		return myShiroRealm;
	}

	//配置加密算法
	@Bean
	public HashedCredentialsMatcher credentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		hashedCredentialsMatcher.setHashIterations(1024);
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}


	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}




}
