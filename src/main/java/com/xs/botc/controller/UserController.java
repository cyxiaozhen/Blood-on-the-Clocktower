package com.xs.botc.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.xs.botc.entity.base.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/30 周二
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R login(User user){
        return R.ok(user);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public R register(User user){
        return R.ok(user);
    }

    @ApiOperation("修改密码")
    @PostMapping("/changePassword")
    public R changePassword(User user){
        return R.ok(user);
    }
}
