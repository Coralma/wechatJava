package com.coral.servlet.model;

/**
 * Created by CCC on 2015/10/8.
 */
public class WechatFromMessageVO {

    public static String TO_USER_NAME = "ToUserName";
    private String toUserName;
    public static String FROM_USER_NAME = "FromUserName";
    private String fromUserName;
    public static String CREATE_TIME = "CreateTime";
    private String createTime;
    public static String MSG_TYPE = "MsgType";
    private String msgType;
    public static String CONTENT = "Content";
    private String content;
    public static String MSG_ID = "MsgId";
    private String msgId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
