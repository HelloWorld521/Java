package com.springboot.demo.sys.service.impl;

import com.springboot.demo.sys.entity.SysRole;
import com.springboot.demo.sys.mapper.SysRoleMapper;
import com.springboot.demo.sys.service.SysRoleService;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }
}
