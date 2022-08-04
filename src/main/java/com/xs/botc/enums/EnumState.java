package com.xs.botc.enums;

import com.xs.botc.constant.RoleConstantFactory;
import lombok.Getter;

/**
 * 角色状态
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Getter
public enum EnumState {

    免疫("immunity"),
    醉酒("drunk"),
    中毒("poisoning"),
    疯狂("crazy"),
    邪恶("evil"),
    死亡("death"),
    ;

    String state;

    EnumState(String state) {
        this.state = state;
    }
}
