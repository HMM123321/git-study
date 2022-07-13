package com.hmm.realm;

import com.hmm.entity.User;
import com.hmm.service.userServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hmm
 * @Date 2021/9/13 14:15
 */
public class myRealm extends AuthorizingRealm {

    @Autowired
    userServiceImpl userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(username);
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        System.out.println("认证" + username);
        User user = new User();
        user.setUsername(username);
        User user1 = userService.find(username);
        if (user1 == null)
            return null;
        return new SimpleAuthenticationInfo(token.getUsername(), user.getPassword(), "myRealm");
    }
}
