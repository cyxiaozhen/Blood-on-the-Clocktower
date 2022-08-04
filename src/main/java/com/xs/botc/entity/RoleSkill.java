package com.xs.botc.entity;

/**
 * 角色技能
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/3 周三
 */
public interface RoleSkill {

    /**
     * 角色技能
     * @param roles 选定对象
     * @param room 房间信息
     * @return
     */
     void skill(Role[] roles, Room room);

    /**
     * 角色死亡
     * @param roles 选定对象
     * @param room 房间信息
     * @return
     */
     void death(Role[] roles, Room room);

    /**
     * 被提名
     * @param roles 提名对象
     * @param room 房间信息
     * @return
     */
    void nominated(Role[] roles, Room room);
}
