package com.cafe.killer.cafe_mall.dto;

/**
 * 生成订单时传入的参数
 * @author Coffee_Killer
 * */
public class OrderParam {

    /* 收货地址id */
    private Long memberReceiveAddressId;

    /* 优惠券id */
    private Long couponId;

    /* 使用的积分数 */
    private Integer useIntegration;

    /* 支付方式 */
    private Integer payType;

    public Long getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
