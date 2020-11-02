package com.yyovo.adam.admin.system.model.dto;

import com.yyovo.adam.admin.system.constant.GenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class UserEditDTO {
    @ApiModelProperty(value = "机构id 可同时属多部门")
    private Long deptId;

    @NotBlank(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    @ApiModelProperty(value = "用户名")
    private String userAccount;

    @ApiModelProperty(value = "用户类型 0:管理员 1:普通会员 2:游客")
    private String userType;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别 1:男 2:女")
    private GenderEnum gender;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @NotNull(message = "用户手机不能为空")
    @ApiModelProperty(value = "手机")
    private String phone;

    @NotBlank(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "备注")
    private String remark;

}
