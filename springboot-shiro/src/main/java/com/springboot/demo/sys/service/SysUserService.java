package com.springboot.demo.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.demo.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> selectByPage(@Param("page") Page<SysUser> page);

    SysUser findByName(String userName);
}
