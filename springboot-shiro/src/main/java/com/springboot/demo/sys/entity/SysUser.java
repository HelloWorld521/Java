package com.springboot.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="SysUser对象", description="")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "状态 0锁定 1有效")
    private String status;

    @ApiModelProperty(value = "最近访问时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建时间")
    private Date crateTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
