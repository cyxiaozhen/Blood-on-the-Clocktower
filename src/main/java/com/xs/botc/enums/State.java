package com.xs.botc.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 角色状态
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/2 周二
 */
@Getter
public enum State {

    正常("normal"),
    免疫("immunity"),
    醉酒("drunk"),
    中毒("poisoning");


    String state;

    State(String state) {
        this.state = state;
    }
}
