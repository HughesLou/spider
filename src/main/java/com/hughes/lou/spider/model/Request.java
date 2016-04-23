/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hughes on 2016/1/2.
 */
public class Request implements Serializable {
    public static final String STATUS_CODE = "statusCode";

    private String url;
    private String method;

    /**
     * Store the additional information
     */
    private Map<String, Object> info;

    /**
     * The priority of request
     * The request with high priority will be processed earlier.
     */
    private long priority;

    public Request() {}

    public Request(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public long getPriority() {
        return priority;
    }

    public Request setPriority(long priority) {
        this.priority = priority;
        return this;
    }

    public Object getInfo(String key) {
        if (null == info) {return null;}
        return info.get(key);
    }

    public Request putInfo(String key, Object value) {
        if (null == info) {
            info = new HashMap<>();
        }
        info.put(key, value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (priority != request.priority) return false;
        if (url != null ? !url.equals(request.url) : request.url != null) return false;
        if (method != null ? !method.equals(request.method) : request.method != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (int) (priority ^ (priority >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", info=" + info +
                ", priority=" + priority +
                '}';
    }
}
