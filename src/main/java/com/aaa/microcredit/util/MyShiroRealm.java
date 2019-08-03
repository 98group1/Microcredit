package com.aaa.microcredit.util;

import com.aaa.microcredit.service.RegisterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


/**
 * className:MyShiroRealm
 * discriptoin:
 * author:
 * createTime:2019-7-29 18:37
 */
public class MyShiroRealm extends AuthorizingRealm implements Serializable{

	@Autowired
	private RegisterService service;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取username
		String userName = (String) token.getPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		//通过username查询
		List<Map> login = service.query1(userName);
		Map login1 = null;
		if (login != null && login.size() > 0) {
			login1 = login.get(0);
		}
		if (login1 == null) {
			throw new UnknownAccountException(); //账号不存在异常
		}
		//设置盐
	 	String realmName=getName();
		ByteSource salt = ByteSource.Util.bytes(login1.get("username"));
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				login1.get("username"),//用户名
				login1.get("password"),//密码
				salt,
				realmName//realm name
		);
		//当验证信息都通过后，把用户信息放在session里
		session.setAttribute("login1", login1);
		return authenticationInfo;
	}

	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//全局通过SecurityUtils.getSubject().getPrincipal()获取用户信息
		Object principal = SecurityUtils.getSubject().getPrincipal();
		//通过用户名查出来角色
		//List<String> strings = userInfoService.selectRole(userInfo.getUserName());
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/*for(String role:strings){
			//角色名称
			System.out.println(role);
			info.addStringPermission(role);
		}*/
		//返回角色名称
		return info;
	}
}
