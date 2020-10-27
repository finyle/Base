package com.lin.modules.wechat.applet.dto;

import lombok.Data;

import java.math.BigDecimal;

/****************************************************
 *
 *  充值实体
 *
 * @author majker
 * @date: 2019/3/10
 * @version 1.0
 **************************************************/
@Data
public class RechargeDto {

    /**
     * 充值 支付类型
     * 0 微信 1 支付宝 2.公众号微信 3.微信小程序
     */
    private int payType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 充值金额
     */
    private BigDecimal rechargeMoney;

    /**
     * 临时凭证code
     * 小程序支付调用wx.login();获取到登录临时凭证code
     */
    private String code;


}
