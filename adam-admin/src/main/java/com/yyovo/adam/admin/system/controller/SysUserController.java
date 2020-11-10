package com.yyovo.adam.admin.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyovo.adam.admin.system.model.dto.UserEditDTO;
import com.yyovo.adam.admin.system.model.dto.UserQueryDTO;
import com.yyovo.adam.admin.system.model.enums.GenderEnum;
import com.yyovo.adam.admin.system.model.enums.SystemError;
import com.yyovo.adam.admin.system.model.pojo.SysUser;
import com.yyovo.adam.admin.system.model.vo.UserVO;
import com.yyovo.adam.admin.system.service.ISysUserService;
import com.yyovo.adam.common.base.model.Result;
import com.yyovo.adam.common.utils.ConvertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author Yang.Yong
 * @since 2020-10-09
 */
@Api(value = "系统用户表")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    private final ISysUserService sysUserService;
    public SysUserController(ISysUserService sysUserService){
        this.sysUserService = sysUserService;
    }

    /**
     * 添加
     * @param userEditDTO 请求参数
     * @return R
     */
    @PostMapping
    @ApiOperation(value = "添加用户")
    public Result<?> save(@RequestBody @Valid UserEditDTO userEditDTO) {
        int count = sysUserService.count(Wrappers.<SysUser>lambdaQuery()
                .or().eq(SysUser::getUserAccount, userEditDTO.getUserAccount())
                .or().eq(SysUser::getEmail, userEditDTO.getEmail())
                .or().eq(SysUser::getPhone, userEditDTO.getPhone()));
        if (count > 0) {
            return Result.failed(SystemError.USER_REGISTERED);
        }
        SysUser user = ConvertUtil.copyToDest(userEditDTO, SysUser.class);
        sysUserService.save(user);
        return Result.success(ConvertUtil.copyToDest(user, UserVO.class));
    }

    /**
     * 修改
     *
     * @param id 主键
     * @param userEditDTO 请求参数
     * @return R
     */
    @PatchMapping("{id}")
    @ApiOperation(value = "修改用户")
    public Result<?> update(@PathVariable("id") Long id, @RequestBody UserEditDTO userEditDTO) {
        SysUser user = ConvertUtil.copyToDest(userEditDTO, SysUser.class);
        user.setId(id);
        sysUserService.updateById(user);
        return Result.success(ConvertUtil.copyToDest(user, UserVO.class));
    }

    /**
     * 获取
     *
     * @param id 主键
     * @return R
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户")
    public Result<?> get(@PathVariable("id") String id) {
        SysUser user = sysUserService.getById(id);
        return Result.success(ConvertUtil.copyToDest(user, UserVO.class));
    }

    /**
     * 获取列表
     *
     * @param userQueryDTO 查询参数
     * @return R
     */
    @GetMapping
    @ApiOperation(value = "获取用户列表")
    public Result<?> page(UserQueryDTO userQueryDTO) {
        LambdaQueryWrapper<SysUser> ew = Wrappers.lambdaQuery();
        if (!StrUtil.isEmptyOrUndefined(userQueryDTO.getGender())) {
            ew.eq(SysUser::getGender, GenderEnum.convert(userQueryDTO.getGender()));
        }
//        ew.eq(SysUser::getAvatar, "q");
//        ew.orderByDesc(SysUser::getRegisterTime);

        Page<SysUser> page = new Page<>(userQueryDTO.getCurrent(), userQueryDTO.getSize());
        page.setSearchCount(true);
        page.addOrder(OrderItem.asc("register_time"));
        page = sysUserService.page(page, ew);
        return Result.success(ConvertUtil.copyToPage(page, UserVO.class));
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return R
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户")
    public Result<?> remove(@PathVariable("id") String id) {
        sysUserService.removeById(id);
        return Result.success();
    }

    /**
     * 批量删除
     *
     * @param idList 主键集合
     * @return R
     */
    @PostMapping("remove")
    @ApiOperation(value = "批量删除用户")
    public Result<?> BatchRemove(@RequestParam Long[] idList) {
        sysUserService.removeByIds(Arrays.asList(idList));
        return Result.success();
    }

}
