package com.lin.modules.wechat.applet.web;

import com.lin.common.util.IdGen;
import com.lin.common.util.Render;
import com.lin.modules.wechat.applet.dto.RechargeDto;
import com.lin.modules.wechat.applet.service.PayService;
import com.lin.modules.wechat.applet.util.AppletPayUtil;
import com.lin.modules.wechat.base.BjddController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m/recharge")
public class RechargeAPI extends BjddController {

    @Autowired
    private PayService payService;

    @ApiOperation(value = "创建充值订单", notes = "创建充值订单")
    @PostMapping
    public Object order(@RequestBody RechargeDto rechargeDto) throws Exception {
        /**
         微信小程序支付
         */
        //获取code
        String code = rechargeDto.getCode();
        //调用接口获取openId
        String openId = AppletPayUtil.getOpenIdByCode(code);
        /*
            生成订单....，这里只创建了订单号
         */
        //订单号  uuid
        String outTradeNo= IdGen.uuid();

        return Render.ok(payService.unifiedOrder(outTradeNo,rechargeDto.getRechargeMoney(),openId));
    }
}

