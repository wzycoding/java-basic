package com.wzy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user_login_record")
public class UserLoginRecord {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Integer loginType;

    private Date loginTime;
}
