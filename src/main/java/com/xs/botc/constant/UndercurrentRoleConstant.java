package com.xs.botc.constant;

import java.util.*;

/**
 * 角色常量
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class UndercurrentRoleConstant implements RoleConstantFactory{
    public static final Map<String, Integer> UNDERCURRENT_VILLAGERS;

    public static final Map<String, Integer> UNDERCURRENT_OUTSIDER;

    public static final Map<String, Integer> UNDERCURRENT_TRAVELER;

    public static final Map<String, Integer> UNDERCURRENT_MINIONS;

    public static final Map<String, Integer> UNDERCURRENT_DEVIL;

    static {
        UNDERCURRENT_VILLAGERS = new HashMap<String, Integer>(13) {
            {
                //洗衣妇,图书管理员,调查员,厨师,共情者,占卜师,送葬者,僧侣,守鸦人,贞洁者,猎手,士兵,镇长
//                add("Washerwoman");
//                add("Librarian");
//                add("Investigator");
//                add("Cook");
//                add("Empath");
//                add("Diviner");
//                add("Undertaker");
//                add("Monk");
//                add("Ravenwatcher");
//                add("Chastity");
//                add("Hunter");
//                add("Soldier");
//                add("Mayor");
                put("洗衣妇", 0);
                put("图书管理员", 1);
                put("调查员", 2);
                put("厨师", 3);
                put("共情者", 4);
                put("占卜师", 5);
                put("送葬者", 6);
                put("僧侣", 7);
                put("守鸦人", 8);
                put("贞洁者", 9);
                put("猎手", 10);
                put("士兵", 11);
                put("镇长", 12);
            }
        };
    }

    static {
        UNDERCURRENT_OUTSIDER = new HashMap<String, Integer>(4) {
            {
                //管家,酒鬼,陌客,圣徒
//                add("Butler");
//                add("Drunk");
//                add("Stranger");
//                add("Saint");
                put("管家", 13);
                put("酒鬼", 14);
                put("陌客", 15);
                put("圣徒", 16);
            }
        };
    }

    static {
        UNDERCURRENT_TRAVELER = new HashMap<String, Integer>(5) {
            {
                //官员,乞丐,枪手,窃贼,替罪羊
//                add("Officer");
//                add("Beggar");
//                add("Gunman");
//                add("Thief");
//                add("Scapegoat");
                put("官员", 17);
                put("乞丐", 18);
                put("枪手", 19);
                put("窃贼", 20);
                put("替罪羊", 21);
            }
        };
    }

    static {
        UNDERCURRENT_MINIONS = new HashMap<String, Integer>(4) {
            {
                //投毒者,间谍,红唇女郎,男爵
//                add("Poisoner");
//                add("Spy");
//                add("Slut");
//                add("Baron");
                put("投毒者", 22);
                put("间谍", 23);
                put("红唇女郎", 24);
                put("男爵", 25);
            }
        };
    }

    static {
        UNDERCURRENT_DEVIL = new HashMap<String, Integer>(1) {
            {
                //小恶魔
//            add("Devil");
                put("小恶魔", 26);
            }
        };
    }
}
