package com.yyovo.adam.admin.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yyovo.adam.admin.system.model.pojo.SysUser;
import com.yyovo.adam.admin.system.service.ISysUserService;
import com.yyovo.adam.common.base.controller.BaseController;
import com.yyovo.adam.common.base.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/sys-user")
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
    private Result<?> add(@RequestBody SysUser user) {
//        SysUser user = new SysUser();
//        user.setNickname("admin");
//        user.setUserAccount("admin");
//        user.setDeptId(0L);
//        user.setUserType("0");
//        user.setPhone("138000000000");
//        user.setEmail("123");
//        sysUserService.save(user);
        return Result.success(user);
    }

    /**
     * 修改
     *
     * @param id
     * @param user
     * @return
     */
    @PatchMapping
    private Result<?> update(@PathVariable("id") String id, @RequestBody SysUser user) {
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
     * @param user
     * @return
     */
    @GetMapping
    private Result<?> fetch(@RequestBody SysUser user) {
        LambdaQueryWrapper<SysUser> a= Wrappers.lambdaQuery();
        a.eq(SysUser::getAvatar, "q");
        a.orderByDesc(SysUser::getId);

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.select("age, count(age) as count")
                .groupBy("age");

        List<SysUser> userList = sysUserService.list(a);
        return Result.success(userList);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("remove")
    private Result<?> removeBatch(@RequestParam String idList) {
        return Result.success();
    }

}
