package com.coral.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CCC on 2015/10/8.
 */
@Controller
public class WechatController {

    public WechatController() {
        System.out.println("Init WechatController");
    }

    @RequestMapping(value = "/")
    public String portal() {
        System.out.println("run in portal.");
        return "/index.html";
    }

    @RequestMapping(value = "/image")
    public String image() {
        System.out.println("run in image.");
        return "/index.html";
    }
}
