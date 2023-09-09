package com.wzy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_stock")
public class Stock {
    private Integer id;

    private Integer productId;

    private Integer count;
}
