package com.wzy.clone;

import java.io.Serializable;

public class MerchantInfo implements Serializable {

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        return "MerchantInfo{" +
                "merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }
}
