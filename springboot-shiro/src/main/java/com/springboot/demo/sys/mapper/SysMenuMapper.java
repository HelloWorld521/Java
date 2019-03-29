package com.springboot.demo.sys.mapper;

import com.springboot.demo.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> findUserPermissions(String userName);
}
