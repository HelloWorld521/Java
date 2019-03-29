package com.springboot.demo.sys.controller;

import com.springboot.demo.common.domain.ResponseBo;
import com.springboot.demo.common.util.MD5Utils;
import com.springboot.demo.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * example
 *
 * @author hjy
 * @date 2019/3/20
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, Boolean rememberMe) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseBo.ok();
        } catch (UnknownAccountException | LockedAccountException | IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
