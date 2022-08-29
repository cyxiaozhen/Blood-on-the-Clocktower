package com.xs.botc.enums;

import com.xs.botc.constant.RoleConstantFactory;
import com.xs.botc.entity.Role;
import com.xs.botc.entity.undercurrent.demon.Devil;
import com.xs.botc.entity.undercurrent.minions.Slut;
import lombok.Getter;

/**
 * 角色状态
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Getter
public enum UndercurrentRole implements RoleConstantFactory {
    洗衣妇(null),图书管理员(null),调查员(null),厨师(null),共情者(null),占卜师(null),送葬者(null),僧侣(null),守鸦人(null),贞洁者(null),猎手(null),士兵(null),镇长(null),
    管家(null),酒鬼(null),陌客(null),圣徒(null),
    投毒者(null),间谍(null),红唇女郎(new Slut()),男爵(null),
    小恶魔(new Devil()),
    官员(null),乞丐(null),枪手(null),窃贼(null),替罪羊(null),
    ;

    Role role;

    UndercurrentRole(Role role) {
        this.role = role;
    }
}
