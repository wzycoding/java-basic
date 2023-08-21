package com.wzy.clone;

import java.io.Serializable;

public class Goods implements Serializable {
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商户信息
     */
    private MerchantInfo merchantInfo;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    @Override
    public Goods clone() throws CloneNotSupportedException {
        Goods cloneObj = (Goods) super.clone();
        return cloneObj;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", merchantInfo=" + merchantInfo +
                '}';
    }
}
