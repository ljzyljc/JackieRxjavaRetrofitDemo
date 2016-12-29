package com.example.tempcw.jackierxjavaretrofitdemo;

import java.util.List;

/**
 * Created by TempCw on 2016/10/26.
 */

public class DateInfo {


    /**
     * succ : true
     * statusCode : 200
     * msg : null
     * data : [{"name":"户政","orderIndex":"10","iD":"8"},{"name":"出入境","orderIndex":"11","iD":"1"},{"name":"交警","orderIndex":"12","iD":"2"},{"name":"治安","orderIndex":"13","iD":"5"},{"name":"监管","orderIndex":"2","iD":"9"},{"name":"网安","orderIndex":"5","iD":"3"},{"name":"禁毒","orderIndex":"6","iD":"14"},{"name":"法制","orderIndex":"64","iD":"64"},{"name":"保安","orderIndex":"7","iD":"17"},{"name":"内保","orderIndex":"7","iD":"10"},{"name":"消防","orderIndex":"8","iD":"4"}]
     * time : 1482216149521
     * desc : null
     * hasNext : false
     * navTabId : null
     * rel : null
     * callbackType : null
     * forwardUrl : null
     * message : null
     */

    private boolean succ;
    private int statusCode;
    private Object msg;
    private long time;
    private Object desc;
    private boolean hasNext;
    private Object navTabId;
    private Object rel;
    private Object callbackType;
    private Object forwardUrl;
    private Object message;
    /**
     * name : 户政
     * orderIndex : 10
     * iD : 8
     */

    private List<DataBean> data;

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Object getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(Object navTabId) {
        this.navTabId = navTabId;
    }

    public Object getRel() {
        return rel;
    }

    public void setRel(Object rel) {
        this.rel = rel;
    }

    public Object getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(Object callbackType) {
        this.callbackType = callbackType;
    }

    public Object getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(Object forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String orderIndex;
        private String iD;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(String orderIndex) {
            this.orderIndex = orderIndex;
        }

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }
    }
}
