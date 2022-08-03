package com.xs.botc.entity.undercurrent.minions;

import com.xs.botc.entity.BadGuy;
import com.xs.botc.entity.Role;
import com.xs.botc.entity.RoleSkill;
import com.xs.botc.entity.undercurrent.demon.Devil;
import com.xs.botc.enums.State;
import lombok.Data;

/**
 * 红唇女郎荡妇
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Data
public class Slut extends BadGuy implements RoleSkill {

    @Override
    public Boolean skill(Role[] roles){
        if (!(getState().contains(State.中毒)) || getState().contains(State.醉酒)){
            Devil devil = new Devil();
            devil.setNo(getNo());
            devil.setState(getState());
            return true;
        }
        //todo 几率
        return null;
    }
}
