package com.wzy.enums;

/**
 * 订单类型枚举
 *
 * @author wzy
 * @date 2023-08-09 21:07:13
 */
public enum OrderStatusEnum {

    /**
     * 待支付
     */
    WAIT_PAY(0) {
        @Override
        String getTips() {
            return "请您尽快支付哦";
        }
    },
    /**
     * 支付成功
     */
    PAY_SUCCESS(1) {
        @Override
        String getTips() {
            return "您已支付完成等待送货";
        }
    },
    /**
     * 已完成
     */
    COMPLETED(2) {
        @Override
        String getTips() {
            return "订单已完成欢迎您下次光临！";
        }
    },
    /**
     * 已取消
     */
    CANCEL(3) {
        @Override
        String getTips() {
            return "订单已取消";
        }
    };

    /**
     * 订单状态
     */
    private final int status;

    OrderStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    abstract String getTips();
}
