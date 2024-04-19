package com.xiaopeng.device.communication.messagecenter;

import android.support.annotation.Keep;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class MessageCenterResponse {
    private int code;
    private MessageResponseData data;

    @Keep
    /* loaded from: classes.dex */
    public class MessageResponseData {
        private List<MessageCenterBean> list;

        public MessageResponseData() {
        }

        public List<MessageCenterBean> getList() {
            return this.list;
        }

        public void setList(List<MessageCenterBean> list) {
            this.list = list;
        }

        public String toString() {
            return "MessageResponseData{list=" + this.list + '}';
        }
    }

    public int getCode() {
        return this.code;
    }

    public MessageResponseData getData() {
        return this.data;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(MessageResponseData messageResponseData) {
        this.data = messageResponseData;
    }

    public String toString() {
        return "MessageCenterResponse{data=" + this.data + '}';
    }
}
