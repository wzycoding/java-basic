package com.wzy.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategoryVO {

    private Long goodsId;

    private String spuName;

    private Long categoryId;

    private String categoryName;

    private Integer price;

    private Date createTime;

    private Date updateTime;
}
