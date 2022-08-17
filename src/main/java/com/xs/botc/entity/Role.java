package com.xs.botc.entity;

import com.xs.botc.constant.RoleConstantFactory;
import com.xs.botc.enums.EnumState;
import io.netty.channel.ChannelHandlerContext;
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
    RoleConstantFactory oldName;

    /**
     * 展示身份
     */
    RoleConstantFactory name;

    /**
     * 角色编号
     */
    Integer no;

    /**
     * 角色状态
     */
    List<EnumState> state;

    /**
     * 是否死亡提名
     */
    boolean isDie;

    /** 技能优先级
     */
    Integer order = 0;

    /**
     * 消息通道处理
     */
    ChannelHandlerContext ctx;

    @Override
    public abstract void skill(Role[] roles, Room room);

    @Override
    public void death(Role[] roles, Room room){
        System.out.println(name + "死亡");
    }

    @Override
    public void nominated(Role[] roles, Room room){
        System.out.println(name + "提名");
    }

}
