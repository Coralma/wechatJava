package com.coral.servlet;

import org.wechat.msg.BaseMsg;
import org.wechat.msg.TextMsg;
import org.wechat.msg.req.TextReqMsg;
import org.wechat.servlet.WeixinServletSupport;

/**
 * Created by CCC on 2015/10/9.
 */
public class EasyWechatServlet extends WeixinServletSupport {

    private static final long serialVersionUID = 1L;

    @Override
    protected String getToken() {
        return "coral";
    }

    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        return new TextMsg("你说了: " + msg.getContent());
    }
}
