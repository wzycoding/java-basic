package com.wzy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {

    /**
     * 手机号码登录
     */
    PHONE(0),
    /**
     * 微信登录
     */
    WECHAT(1),
    /**
     * 一键登录
     */
    ONE_KEY(2);

    private Integer type;

}
