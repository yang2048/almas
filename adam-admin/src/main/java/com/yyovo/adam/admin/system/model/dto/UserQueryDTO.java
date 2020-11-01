package com.yyovo.adam.admin.system.model.dto;

import com.yyovo.adam.common.base.model.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryDTO extends BasePage {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String userAccount;
}
