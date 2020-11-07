package com.yyovo.adam.admin.system.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yyovo.adam.admin.system.model.enums.GenderEnum;
import com.yyovo.adam.common.base.model.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author Yang.Yong
 * @since 2020-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("y_sys_user")
@ApiModel(value="SysUser对象", description="系统用户表")
public class SysUser extends SuperModel {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构id 可同时属多部门")
    private Long deptId;

    @ApiModelProperty(value = "用户名")
    private String userAccount;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "暗号")
    private String cipher;

    @ApiModelProperty(value = "用户类型 0:管理员 1:普通会员 2:游客")
    private String userType;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别 1:男 2:女")
    private GenderEnum gender;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "注册ip")
    private String registerIp;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "最后登录ip")
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "状态 0:否 1:是")
    private Integer disable;
}
