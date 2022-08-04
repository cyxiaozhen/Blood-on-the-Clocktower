package com.xs.botc.entity.undercurrent.minions;

import com.xs.botc.entity.BadGuy;
import com.xs.botc.entity.Role;
import com.xs.botc.entity.RoleSkill;
import com.xs.botc.entity.Room;
import com.xs.botc.entity.undercurrent.demon.Devil;
import com.xs.botc.enums.EnumState;
import com.xs.botc.enums.UndercurrentRole;
import lombok.Data;
import org.springframework.beans.BeanUtils;


/**
 * 红唇女郎(荡妇)
 * 如果大于等于五名玩家存活时（旅行者不计算在内）恶魔死亡，你变成那个恶魔。
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Data
public class Slut extends BadGuy implements RoleSkill {

    public Slut() {
        setName(UndercurrentRole.红唇女郎);
        setOldName(UndercurrentRole.红唇女郎);
    }

    @Override
    public void skill(Role[] roles, Room room){
        for (Role role : room.getBadGuys()) {
            if (UndercurrentRole.小恶魔.equals(role.getName())) {
                if (role.getState().contains(EnumState.死亡)) {
                    if (room.getBadGuys().size() + room.getNiceGuys().size() >= 5) {
                        if (!(getState().contains(EnumState.中毒)) || getState().contains(EnumState.醉酒)) {
                            //替换为小恶魔
                            Devil devil = new Devil();
                            BeanUtils.copyProperties(this, devil);
                            devil.setName(UndercurrentRole.小恶魔);
                            room.getBadGuys().set(room.getBadGuys().indexOf(role), devil);
                        }
                        //todo 几率
                    }
                }
            }
        }
    }
}
