package com.xs.botc.util;

import com.xs.botc.entity.Role;
import com.xs.botc.entity.Room;

import java.util.*;

/**
 * 缓存处理
 *
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class GameUtil {

    /**
     * 获取模式角色分配
     * @param room
     * @return
     */
    public static List<Integer> getRolesByModalId(Room room) {
        List<Integer> roles = new ArrayList<>();
        List<Integer> retRoles = new ArrayList<>();


        return retRoles;


    }

    /**
     * 获取角色
     * @param room
     * @param roleCode
     * @return
     */
    public static Role getRole(Room room, int roleCode) {
        //获取模式
        String mode = room.getMode();
        Role role = null;
        return role;

    }


    /**
     * 比较输赢
     *
     * @param room 房间信息
     * @return 0表示游戏未结束；1表示好人获胜；-1表示狼人获胜
     */
    public static int isGameOver(Room room) {

        return 0;
    }

    /**
     * 游戏结束
     * 发送对局记录给当前房间用户
     * 记录对局历史
     *
     * @param room 房间信息
     * @return
     */
    public static void GameOver(Room room) {

        return;
    }

    /**
     * 获取发言顺序列表
     *
     * @param list      未排序列表
     */
    public static void getSpeakList(List<Role> list) {

    }

    /**
     * 调整技能排序
     *
     * @param list      未排序列表
     */
    public static void getSkillList(List<Role> list) {

    }
}
