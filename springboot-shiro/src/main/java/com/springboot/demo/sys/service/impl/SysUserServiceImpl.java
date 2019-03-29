package com.springboot.demo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.demo.sys.entity.SysUser;
import com.springboot.demo.sys.mapper.SysUserMapper;
import com.springboot.demo.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectByPage(Page<SysUser> page) {
        IPage<SysUser> iPage = this.baseMapper.selectPage(page, null);
        return iPage;
    }

    @Override
    public SysUser findByName(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lower(username)", userName.toLowerCase());
        return this.baseMapper.selectOne(queryWrapper);
    }

}
