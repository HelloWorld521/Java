package com.springboot.demo.common.auth;

import com.springboot.demo.sys.entity.SysMenu;
import com.springboot.demo.sys.entity.SysRole;
import com.springboot.demo.sys.entity.SysUser;
import com.springboot.demo.sys.service.SysMenuService;
import com.springboot.demo.sys.service.SysRoleService;
import com.springboot.demo.sys.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * shiro realm 配置
 *
 * @author hjy
 * @date 2019/3/8
 **/
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService userService;
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysMenuService menuService;

    /**
     * 授权信息
     * @param principalCollection principal 主要
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        String userName = user.getUsername();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户角色集
        List<SysRole> roleList = roleService.findUserRole(userName);
        Set<String> roleSet = roleList.stream().map(SysRole::getRoleName).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<SysMenu> permissionList = menuService.findUserPermissions(userName);
        Set<String> permissionSet = permissionList.stream().map(SysMenu::getPerms).collect(Collectors.toSet());
        log.info("用户[{}]的权限为：{}", userName, roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    /**
     * 身份验证信息
     * @param authenticationToken AuthenticationToken 身份认证
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        SysUser user = userService.findByName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if ("0".equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        return new SimpleAuthenticationInfo(user, password, userName);
    }
}
