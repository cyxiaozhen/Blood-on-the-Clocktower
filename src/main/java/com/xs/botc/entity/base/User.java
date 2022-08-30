package com.xs.botc.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 游戏用户
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/3 周三
 */
@Data
@TableName("user_")
public class User implements Serializable {

    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    String id;

    @ApiModelProperty("用户名称")
    @TableField(value = "name_")
    String name;

    @ApiModelProperty("登录账号")
    @TableField(value = "account_")
    String account;

    @ApiModelProperty("用户密码")
    @TableField(value = "password_")
    String password;

    @ApiModelProperty("用户积分")
    @TableField(value = "integral_")
    String integral;

    @ApiModelProperty("用户性别 0:男, 1:女")
    @TableField(value = "gender_")
    Integer gender;

    @ApiModelProperty("用户邮箱")
    @TableField(value = "email_")
    String email;

    @ApiModelProperty("用户微信")
    @TableField(value = "wechat_")
    String wechat;

    @ApiModelProperty("最后登录时间")
    @TableField(value = "last_login_time_", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String lastLoginTime;

    @ApiModelProperty("常用IP")
    @TableField(value = "ip_")
    String ip;

    @ApiModelProperty("在线状态")
    @TableField(value = "online_")
    Boolean online;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    String updateTime;

    @ApiModelProperty("用户签名")
    @TableField(value = "remark_", select = false)
    String remark;

    @ApiModelProperty("是否游客")
    @TableField(exist = false)
    Boolean tourists;
}
