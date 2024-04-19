package com.xiaopeng.libconfig.ipc.event;
/* loaded from: classes.dex */
public class NavigationEvent {
    private int index;
    private boolean state;

    public int getIndex() {
        return this.index;
    }

    public boolean getState() {
        return this.state;
    }

    public NavigationEvent setIndex(int i) {
        this.index = i;
        return this;
    }

    public NavigationEvent setState(boolean z) {
        this.state = z;
        return this;
    }

    public String toString() {
        return "{\"state\":" + this.state + ",\"index\":" + this.index + "}";
    }
}
