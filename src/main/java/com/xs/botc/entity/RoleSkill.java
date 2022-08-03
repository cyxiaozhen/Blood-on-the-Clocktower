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
     * @param roles
     * @return
     */
     Boolean skill(Role[] roles, Room room);

    /**
     * 角色死亡
     * @param roles
     * @return
     */
     Boolean Death(Role[] roles, Room room);
}
