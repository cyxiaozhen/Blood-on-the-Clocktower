package com.xs.botc.entity.undercurrent.demon;

import com.xs.botc.entity.BadGuy;
import com.xs.botc.entity.Role;
import com.xs.botc.entity.RoleSkill;
import com.xs.botc.entity.Room;
import com.xs.botc.enums.State;
import com.xs.botc.util.GameUtil;
import lombok.Data;

import java.util.Random;

/**
 * 小恶魔
 * 每个夜晚*，你要选择一名玩家：他死亡。如果你以这种方式自杀，一名爪牙会变成小恶魔。
 * 小恶魔会在夜晚杀戮，且能创造自己的分身……以可怕的代价。
 *
 * 除首个夜晚以外的每个夜晚，小恶魔会选择一名玩家进行杀戮。
 * 因为夜间大多数角色都在恶魔之后行动，被恶魔杀死的玩家可能在当晚无法使用他的能力。
 * 小恶魔作为恶魔，能够得知哪些玩家是他的爪牙，也能得知三个不在场的善良角色，他能较为安全地伪装成这些角色。
 * 如果小恶魔死亡，游戏结束且善良阵营获胜。
 * 然而，如果小恶魔选择在夜晚杀死自己，他会死亡并且会有一名存活的爪牙变成小恶魔。
 * 新的小恶魔在当晚无法进行行动，但现在那名爪牙现在在各种意义上都会成为恶魔——他会在此后的每个夜晚杀戮，且会在死亡时让邪恶阵营落败。
 * 除首个夜晚以外的每个夜晚，唤醒小恶魔。
 * 让小恶魔指向任意一名玩家。让小恶魔重新入睡。
 * 被选择的玩家死亡——在那名玩家的角色标记旁放置小恶魔的“死亡”提示标记并放置帷幕标记。
 *
 * 如果小恶魔选择在夜里自杀，用多出来的小恶魔标记替换一名存活的爪牙玩家的角色标记，
 * 让那名玩家的角色改变为小恶魔。
 * 唤醒新的小恶魔，向他展示“你是”信息标记，然后向他展示小恶魔角色标记。
 * 让新的小恶魔重新入睡。
 * 在黎明时，宣布有哪名玩家在夜晚死去。（不要说明死亡原因。）
 * 如果小恶魔选择在夜晚攻击一名已死亡的玩家，允许他这么做。当一个角色能力描述中提及“选择一名玩家”，意味着任何玩家——无论存活或是死亡——都能被选择。小恶魔可能在计划伪装成士兵，而这种情形下会让他的谎言看起来更加可信。
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Data
public class Devil extends BadGuy implements RoleSkill {

    @Override
    public Boolean skill(Role[] roles, Room room){
        Role role = roles[0];
        //挡刀
        if (!role.getState().contains(State.免疫)) {
            return false;
        }
        //自刀
        else if (getNo().equals(role.getNo())) {
            //获取爪牙列表一人变为恶魔，为空则好人胜利
            setDie(true);
            room.getBadGuys().remove(this);
            if (room.getBadGuys().isEmpty()){
                GameUtil.GameOver(room);
            }
            else{
                int nextInt = new Random().nextInt(room.getBadGuys().size());
                room.getBadGuys().get(nextInt).setName("Devil");
            }
            //getMinions()
            return true;
        }
        //杀人鞭尸
        else {
            role.setDie(true);
            return true;
        }
    }

    @Override
    public Boolean Death(Role[] roles, Room room) {
        return null;
    }
}
