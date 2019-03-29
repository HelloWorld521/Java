package com.springboot.demo.sys.mapper;

import com.springboot.demo.sys.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> findUserRole(String userName);
}
