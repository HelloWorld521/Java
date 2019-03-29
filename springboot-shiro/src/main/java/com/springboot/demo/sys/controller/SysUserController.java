package com.springboot.demo.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.common.domain.QueryRequest;
import com.springboot.demo.sys.entity.SysRole;
import com.springboot.demo.sys.entity.SysUser;
import com.springboot.demo.sys.service.SysRoleService;
import com.springboot.demo.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {

    @Resource
    private SysUserService userService;


    @ApiOperation(value = "用户列表")
    @GetMapping("list")
    @RequiresPermissions("user:list")
    public IPage<SysUser> userList(QueryRequest request) {
        Page<SysUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        IPage<SysUser> sysUser = userService.selectByPage(page);
        return sysUser;
    }

    @GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.userService.findByName(username) == null;
    }


}

