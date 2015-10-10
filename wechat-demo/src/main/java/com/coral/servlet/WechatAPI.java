package com.coral.servlet;

import org.springframework.stereotype.Controller;
import sun.reflect.annotation.ExceptionProxy;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by CCC on 2015/10/9.
 */
@Controller
public class WechatAPI {

    public static void main(String[] args) throws Exception{
        WechatAPI api = new WechatAPI();
        /*String accessToken = api.getAccessToken();
        System.out.println(accessToken);*/
        System.out.println("中文显示");
        /*api.sendMsg();*/
        api.generateRCode();
    }

    public void sendMsg() throws UnsupportedEncodingException {
        String url= "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + getAccessToken();
        String params = "{\"touser\":\"otbIiwiIjjuUUjlXbV4blnCBqtHA\",\"msgtype\":\"text\",\"text\": {\"content\":\"测试自动发送消息功能。\"}}";
        String returnValue = httpPost(url,params);
        System.out.println(returnValue);
    }

    public void generateRCode() {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + getAccessToken();
        String params = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 9123}}}";
        String returnValue = httpPost(url,params);
        System.out.println(returnValue);
    }

    public String getAccessToken() {
        /*return httpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx53c2e563542ab23c&secret=521fb859b8ec224dc9c412f9e6df3b63");*/
        return "VYlRCU0RpsWR8lR4_bF2dYxM-ICOgG6m759SQHsWr5xXnOcqvwsnaEXu20CQcR8Bu0_SGFXcUdAQ4ZVS1DMbbPWoWXdfPUkDIpA3p09nXwo";
    }

    public String httpGet(String url) {
        String result = null;
        URL u = null;
        HttpURLConnection con = null;
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            result = getReturn(con);
            System.out.println(result);
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public String httpPost(String url, String params) {
        URL u = null;
        HttpURLConnection con = null;

        System.out.println("send_url:" + url);
        System.out.println("send_data:" + params.toString());
        // send request to post parameters to specify URL
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(
                    con.getOutputStream(), "UTF-8");
            osw.write(params.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // Read the send back data.
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public String getReturn(HttpURLConnection con) {
        // Read the send back data.
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
