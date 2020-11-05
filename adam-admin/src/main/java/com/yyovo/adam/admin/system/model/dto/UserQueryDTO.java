package com.yyovo.adam.admin.system.model.dto;

import com.yyovo.adam.admin.system.constant.GenderEnum;
import com.yyovo.adam.common.base.model.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserQueryDTO extends BasePage {

    @ApiModelProperty(value = "用户名")
    private String userAccount;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别 1:男 2:女")
    private String gender;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

}
