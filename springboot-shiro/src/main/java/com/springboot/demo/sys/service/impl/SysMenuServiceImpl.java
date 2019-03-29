package com.springboot.demo.sys.service.impl;

import com.springboot.demo.sys.entity.SysMenu;
import com.springboot.demo.sys.mapper.SysMenuMapper;
import com.springboot.demo.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> findUserPermissions(String userName) {
        return menuMapper.findUserPermissions(userName);
    }
}
