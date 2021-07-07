package com.example.demo.shiro;

import com.example.demo.bean.User;
import com.example.demo.mapper.first.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zsp
 * @Date 2021/6/30 15:41
 * @Version 1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        String password = new String((char[] )authenticationToken.getCredentials());
        System.out.println("用户"+userName +"认证-----ShrioRealm.doGetAuthenticationInfo");
        User user = userMapper.findByUserName(userName);
        if(user==null){
            throw new UnknownAccountException("用户名或密码错误!");
        }
        if(!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if(user.getStatus().equals("0")){
            throw  new LockedAccountException("账号已被锁定，请联系管理员");
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,password,getName());
        return authenticationInfo;
    }
}
