package com.xs.botc.entity;

import com.xs.botc.entity.base.User;
import lombok.Data;

import java.util.List;

/**
 * 游戏房间
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/3 周三
 */
@Data
public class Room {

    /**
     * 房间ID
     */
    String id;

    /**
     * 房间名称
     */
    String name;

    /**
     * 游戏模式
     */
    String mode;

    /**
     * 游戏配置
     */
    String configure;

    /**
     * 房间人数
     */
    String number;

    /**
     * 游戏天数
     */
    Integer days;

    /**
     * 游玩人员
     */
    List<User> users;

    /**
     * 邪恶人员
     */
    List<Role> badGuys;

    /**
     * 善良人员
     */
    List<Role> niceGuys;
}
