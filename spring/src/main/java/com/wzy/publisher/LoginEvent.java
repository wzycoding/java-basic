package com.wzy.publisher;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginEvent {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
