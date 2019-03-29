package com.springboot.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjy
 * @since 2019-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUserRole对象", description="")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableField("USER_ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    @TableField("ROLE_ID")
    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
