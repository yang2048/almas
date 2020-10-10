package com.yyovo.almas.admin.system.controller;

import com.yyovo.almas.admin.system.model.pojo.SysUser;
import com.yyovo.almas.admin.system.service.ISysUserService;
import com.yyovo.almas.common.base.controller.BaseController;
import com.yyovo.almas.common.base.model.Result;
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
        List<SysUser> userList = sysUserService.list();
        return Result.success(userList);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("remove")
    private Result<?> batch(@RequestParam String ids) {
        return Result.success();
    }

}
