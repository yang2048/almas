package com.yyovo.adam.admin.system.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyovo.adam.admin.system.model.dto.UserEditDTO;
import com.yyovo.adam.admin.system.model.dto.UserQueryDTO;
import com.yyovo.adam.admin.system.model.pojo.SysUser;
import com.yyovo.adam.admin.system.service.ISysUserService;
import com.yyovo.adam.common.base.controller.BaseController;
import com.yyovo.adam.common.base.model.Result;
import com.yyovo.adam.common.handler.ApiRuntimeException;
import com.yyovo.adam.common.handler.SystemError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author Yang.Yong
 * @since 2020-10-09
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @PostMapping
    private Result<?> add(@RequestBody @Valid UserEditDTO user) {
//        SysUser user = new SysUser();
//        user.setNickname("admin");
//        user.setUserAccount("admin");
//        user.setDeptId(0L);
//        user.setUserType("0");
//        user.setPhone("138000000000");
//        user.setEmail("123");
//        sysUserService.save(user);
        if (StrUtil.isBlank(user.getRemark())) {
            throw new ApiRuntimeException(SystemError.ARG_ERROR);
        }
        return Result.success();
    }

    /**
     * 修改
     *
     * @param id
     * @param user
     * @return
     */
    @PatchMapping
    private Result<?> update(@PathVariable("id") String id, @RequestBody UserEditDTO user) {
        return Result.success();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping
    private Result<?> remove(@PathVariable("id") String id) {
        return Result.success();
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    private Result<?> get(@PathVariable("id") String id) {
        return Result.success();
    }

    /**
     * 获取列表
     *
     * @param user 用户
     * @return
     */
    @GetMapping
    private Result<?> fetch(UserQueryDTO user) {
        LambdaQueryWrapper<SysUser> a= Wrappers.lambdaQuery();
        a.eq(SysUser::getAvatar, "q");
        a.orderByDesc(SysUser::getId);

        QueryWrapper<SysUser> wrapper = Wrappers.query();
        wrapper.select("age, count(age) as count")
               .groupBy("age");

        IPage<SysUser> page = new Page<>(1, 5);
        page = sysUserService.page(page, a);

        List<SysUser> userList = page.getRecords();
        return Result.success(page);
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    @PostMapping("remove")
    private Result<?> removeBatch(@RequestParam String idList) {
        return Result.success();
    }

}
