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
public class SysUser extends SuperModel {
    private static final long serialVersionUID = 1L;

    /**
     * 机构id 可同时属多部门
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String userAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 暗号
     */
    private String cipher;

    /**
     * 用户类型 0:管理员 1:普通会员 2:游客
     */
    private String userType;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别 1:男 2:女
     */
    private GenderEnum gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 注册ip
     */
    private String registerIp;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 状态 0:否 1:是
     */
    private Integer disable;
}
