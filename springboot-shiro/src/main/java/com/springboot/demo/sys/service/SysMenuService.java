package com.springboot.demo.sys.service;

import com.springboot.demo.sys.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findUserPermissions(String userName);
}
