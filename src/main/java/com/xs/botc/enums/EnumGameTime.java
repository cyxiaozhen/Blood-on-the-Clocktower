package com.xs.botc.enums;

import lombok.Getter;

/**
 * 游戏时间
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/17 周三
 */
@Getter
public enum EnumGameTime {

    白天("day"),
    黄昏("dusk"),
    黑夜("night"),
    ;

    String gameTime;

    EnumGameTime(String gameTime) {
        this.gameTime = gameTime;
    }
}
