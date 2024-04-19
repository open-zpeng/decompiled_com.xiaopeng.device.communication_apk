package com.xiaopeng.libconfig.ipc.bean;

import com.xiaopeng.lib.framework.carcontrollermodule.R;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public class MessageCenterBean {
    public static final int CONTENT_POSITION_NOTIFY = 2;
    public static final int CONTENT_POSITION_NOTIFY_BOX = 1;
    public static final int OPPORTUNITY_GETOFF_SCENE = 4;
    public static final int OPPORTUNITY_GETON_MOMENT = 3;
    public static final int OPPORTUNITY_GETON_SCENE = 1;
    public static final int OPPORTUNITY_OTHER = 0;
    public static final int OPPORTUNITY_RUNNING_SCENE = 2;
    public static final int OPSITION_ACCOUNT = 9;
    public static final int OPSITION_AI = 1;
    public static final int OPSITION_AIOT_SERVICE = 54;
    public static final int OPSITION_APPSTORE = 49;
    public static final int OPSITION_CAR_CONTROL = 18;
    public static final int OPSITION_CHARGE = 5;
    public static final int OPSITION_CONFIGURE = 12;
    public static final int OPSITION_DC = 14;
    public static final int OPSITION_DIAGNOSTIC = 20;
    public static final int OPSITION_MUSIC = 16;
    public static final int OPSITION_NAV = 2;
    public static final int OPSITION_OTA = 11;
    public static final int OPSITION_PRIVACY_SERVICE = 17;
    public static final int OPSITION_RESOURCE_CENTER = 15;
    public static final int OPSITION_SETTINGS = 51;
    public static final int OPSITION_SR_HDPKMAP = 19;
    public static final int OPSITION_WASH = 3;
    public static final int OPSITION_XUI_SERVICE = 56;
    public static final int TYPE_ACC = 12;
    public static final int TYPE_AUDIOBOOKS = 3;
    public static final int TYPE_BIRTHDAY = 11;
    public static final int TYPE_EASTER_EGG = 100;
    public static final int TYPE_HAZE = 20;
    public static final int TYPE_HEAVY_FOG = 19;
    public static final int TYPE_HEAVY_RAINS = 18;
    public static final int TYPE_HEAVY_SNOWFALL = 17;
    public static final int TYPE_MAP = 10;
    public static final int TYPE_MAP_PARK = 14;
    public static final int TYPE_MAP_PATH = 13;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_MUSIC_VIP = 22;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_OTA_FAILED = 7;
    public static final int TYPE_OVERTIME = 15;
    public static final int TYPE_PATH_SELECT = 16;
    public static final int TYPE_PM_25 = 9;
    public static final int TYPE_RAINS = 21;
    public static final int TYPE_RECHARGE = 4;
    public static final int TYPE_RECHARGE_FULL = 8;
    public static final int TYPE_SUCCESS = 6;
    public static final int TYPE_WELCOME = 5;
    private int bizType;
    private int carState;
    private String content;
    private Content contentObject;
    private String messageId;
    private int messageType;
    private String packName;
    private int priority;
    private int read_state;
    private int scene;
    private long ts;
    private int type;
    private int uid;
    private long validEndTs;
    private long validStartTs;

    /* loaded from: classes.dex */
    public static class Content {
        MessageContentBean content;
        String contentStr;
        int opportunity;
        int position;
        int type;

        public MessageContentBean getContent() {
            return this.content;
        }

        public String getContentStr() {
            return this.contentStr;
        }

        public int getOpportunity() {
            return this.opportunity;
        }

        public int getPosition() {
            return this.position;
        }

        public int getType() {
            return this.type;
        }

        public void setContent(MessageContentBean messageContentBean) {
            this.content = messageContentBean;
        }

        public void setContentStr(String str) {
            this.contentStr = str;
        }

        public void setOpportunity(int i) {
            this.opportunity = i;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public static MessageCenterBean create(int i, MessageContentBean messageContentBean) {
        MessageCenterBean messageCenterBean = new MessageCenterBean();
        messageCenterBean.setMessageId(UUID.randomUUID().toString());
        long currentTimeMillis = System.currentTimeMillis();
        messageCenterBean.setValidStartTs(currentTimeMillis);
        messageCenterBean.setValidEndTs(3600000 + currentTimeMillis);
        messageCenterBean.setMessageType(R.styleable.AppCompatTheme_toolbarStyle);
        messageCenterBean.setType(1);
        messageCenterBean.setTs(currentTimeMillis);
        messageCenterBean.setBizType(i);
        messageCenterBean.setPriority(1);
        Content content = new Content();
        content.setType(1);
        content.setOpportunity(0);
        content.setPosition(1);
        content.setContent(messageContentBean);
        messageCenterBean.setContentObject(content);
        return messageCenterBean;
    }

    public int getBizType() {
        return this.bizType;
    }

    public MessageContentBean.MsgButton getButton(int i) {
        if (getContentBean() != null) {
            return getContentBean().getButton(i);
        }
        return null;
    }

    public List<MessageContentBean.MsgButton> getButtonList() {
        if (getContentBean() != null) {
            return getContentBean().getButtons();
        }
        return null;
    }

    public int getCarState() {
        return this.carState;
    }

    public String getContent() {
        return this.content;
    }

    public MessageContentBean getContentBean() {
        Content content = this.contentObject;
        if (content == null) {
            return null;
        }
        return content.getContent();
    }

    public Content getContentObject() {
        return this.contentObject;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getPackName() {
        return this.packName;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRead_state() {
        return this.read_state;
    }

    public int getScene() {
        return this.scene;
    }

    public long getTs() {
        return this.ts;
    }

    public int getType() {
        return this.type;
    }

    public int getUid() {
        return this.uid;
    }

    public long getValidEndTs() {
        return this.validEndTs;
    }

    public long getValidStartTs() {
        return this.validStartTs;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }

    public void setCarState(int i) {
        this.carState = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentObject(Content content) {
        this.contentObject = content;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setPackName(String str) {
        this.packName = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setRead_state(int i) {
        this.read_state = i;
    }

    public void setScene(int i) {
        this.scene = i;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setValidEndTs(long j) {
        this.validEndTs = j;
    }

    public void setValidStartTs(long j) {
        this.validStartTs = j;
    }

    public String toString() {
        return "MessageCenterBean{messageId='" + this.messageId + "'}";
    }
}
