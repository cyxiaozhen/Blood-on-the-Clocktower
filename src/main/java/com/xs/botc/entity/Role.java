package com.xs.botc.entity;

import com.xs.botc.enums.State;
import lombok.Data;

import java.util.List;

/**
 * 人物角色顶级父类
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Data
public abstract class Role implements RoleSkill{

    /**
     * 真实身份
     */
    String oldName;

    /**
     * 展示身份
     */
    String name;

    /**
     * 角色编号
     */
    Integer no;

    /**
     * 角色状态
     */
    List<State> state;

    /**
     * 是否死亡
     */
    boolean isDie;

    @Override
    public abstract Boolean skill(Role[] roles, Room room);
}
