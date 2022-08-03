package com.xs.botc.entity.base;

import lombok.Data;

/**
 * 游戏用户
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/3 周三
 */
@Data
public class User {

    /**
     * 用户id
     */
    String id;

    /**
     * 用户名称
     */
    String name;

    /**
     * 用户账号
     */
    String account;

    /**
     * 用户密码
     */
    String password;

    /**
     * 用户积分
     */
    String integral;

    /**
     * 游客
     */
    Boolean tourists;
}
