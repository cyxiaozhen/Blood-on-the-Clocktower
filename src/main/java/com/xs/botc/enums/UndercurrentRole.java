package com.xs.botc.enums;

import com.xs.botc.constant.RoleConstantFactory;
import com.xs.botc.entity.undercurrent.minions.*;
import com.xs.botc.entity.undercurrent.demon.Devil;
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
    洗衣妇,图书管理员,调查员,厨师,共情者,占卜师,送葬者,僧侣,守鸦人,贞洁者,猎手,士兵,镇长,
    管家,酒鬼,陌客,圣徒,
    投毒者,间谍,红唇女郎,男爵,
    小恶魔,
    官员,乞丐,枪手,窃贼,替罪羊,
    ;


    UndercurrentRole() {
    }
}
