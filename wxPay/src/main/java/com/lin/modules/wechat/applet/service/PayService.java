package com.lin.modules.wechat.applet.service;

import com.lin.common.config.WxProgramPayConfig;
import com.lin.common.sdk.PaymentApi;
import com.lin.common.sdk.PaymentKit;
import com.lin.common.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/****************************************************
 *
 *
 *
 * @author lin
 * @date 2019-03-07 17:23
 * @version 1.0
 **************************************************/
@Slf4j
@Service
public class PayService {


    @Value("${com.lin.project.name}")
    public static String projectName;


    public void setProjectName(String projectName) {
        projectName = projectName;
    }

    /**
     * 功能描述: <调用统一下单的接口>
     * @return:
     * @auther: lin
     * @date: 2019/3/7
     **/
    public Object unifiedOrder(String outTradeNo, BigDecimal money, String openid) throws Exception {
        Map<String, String> reqParams = new HashMap<>();
        //微信分配的小程序ID
        reqParams.put("appid", WxProgramPayConfig.APPID);
        //微信支付分配的商户号
        reqParams.put("mch_id", WxProgramPayConfig.MCH_ID);
        //随机字符串
        reqParams.put("nonce_str", System.currentTimeMillis() / 1000 + "");
        //签名类型
        reqParams.put("sign_type", "MD5");
        //充值订单 商品描述
        reqParams.put("body", projectName + "-充值订单-微信小程序");

        //商户订单号
        reqParams.put("out_trade_no", outTradeNo);
        //订单总金额，单位为分
        reqParams.put("total_fee", money.multiply(BigDecimal.valueOf(100)).intValue() + "");
        //终端IP
        reqParams.put("spbill_create_ip", "127.0.0.1");
        //通知地址
        reqParams.put("notify_url", WxProgramPayConfig.NOTIFY_URL);
        //交易类型
        reqParams.put("trade_type", "JSAPI");
        //用户标识
        reqParams.put("openid", openid);
        //签名
        String sign = WXPayUtil.generateSignature(reqParams, WxProgramPayConfig.KEY);
        reqParams.put("sign", sign);
        /*
            调用支付定义下单API,返回预付单信息 prepay_id
         */
        String xmlResult = PaymentApi.pushOrder(reqParams);
        log.info(xmlResult);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
        //预付单信息
        String prepay_id = result.get("prepay_id");

        /*
            小程序调起支付数据签名
         */
        Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("appId", WxProgramPayConfig.APPID);
        packageParams.put("timeStamp", System.currentTimeMillis() / 1000 + "");
        packageParams.put("nonceStr", System.currentTimeMillis() + "");
        packageParams.put("package", "prepay_id=" + prepay_id);
        packageParams.put("signType", "MD5");
        String packageSign = WXPayUtil.generateSignature(packageParams, WxProgramPayConfig.KEY);
        packageParams.put("paySign", packageSign);
        return packageParams;

    }


}
