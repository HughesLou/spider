/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.model;

import com.hughes.lou.spider.extract.Extractable;
import com.hughes.lou.spider.utils.UrlUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.hughes.lou.spider.constant.Constant.JAVASCRIPT;
import static com.hughes.lou.spider.constant.Constant.POUND;

/**
 * Created by Hughes on 2016/1/2.
 */
public class Page {

    private Request request;
    private Result result;
    private String text;
    private Extractable url;
    private int statusCode;

    private List<Request> requests = new ArrayList<>();

    public Page() {}

    public void addRequest(Request request) {
        synchronized (requests) {
            requests.add(request);
        }
    }

    public void addRequest(String requestString) {
        addRequest(requestString, 0);
    }

    public void addRequest(String requestString, long priority) {
        if (StringUtils.isNotBlank(requestString) && !requestString.equals(POUND)
                && !requestString.startsWith(JAVASCRIPT)) {
            synchronized (requests) {
                Request request = new Request(UrlUtils.canonicalizeUrl(requestString, url.toString()));
                if (priority > 0) {
                    request.setPriority(priority);
                }
                requests.add(request);
            }
        }
    }

    public void addRequests(List<String> requests) {
        addRequests(requests, 0);
    }

    public void addRequests(List<String> requests, long priority) {
        for (String request : requests) {
            addRequest(request, priority);
        }
    }

    public void putField(String key, String field) {
        result.putField(key, field);
    }

    public Page setSkip(boolean skip) {
        result.setSkip(skip);
        return this;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Extractable getUrl() {
        return url;
    }

    public void setUrl(Extractable url) {
        this.url = url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Page{" +
                "request=" + request +
                ", result=" + result +
                ", text='" + text + '\'' +
                ", url=" + url +
                ", statusCode=" + statusCode +
                ", requests=" + requests +
                '}';
    }
}
