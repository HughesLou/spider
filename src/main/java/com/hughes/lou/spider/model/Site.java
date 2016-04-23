/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.model;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.apache.http.HttpHost;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Hughes on 2016/1/2.
 */
public class Site {

    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<>();

    private String domain;
    private String agent;
    private Charset charset;
    private Map<String, String> defaultCookies = new LinkedHashMap<>();
    private Table<String, String, String> cookies = HashBasedTable.create();

    private List<Request> requests = new ArrayList<>();
    private int sleepTime = 5000;
    private int retryTimes = 0;
    private int retrySleepTime = 1000;
    private int timeOut = 5000;
    private Set<Integer> acceptStatusCode = DEFAULT_STATUS_CODE_SET;
    private Map<String, String> headers = new HashMap<>();
    private HttpHost httpHost;

    static {
        DEFAULT_STATUS_CODE_SET.add(200);
    }

    public static Site getInstance() {
        return new Site();
    }

    public Site addCookie(String name, String value) {
        defaultCookies.put(name, value);
        return this;
    }

    public Site addCookie(String domain, String name, String value) {
        cookies.put(domain, name, value);
        return this;
    }

    public Site addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public Map<String, Map<String, String>> getAllCookies() {
        return cookies.rowMap();
    }

    public Task toTask() {
        return new Task() {
            @Override
            public String getId() {
                return Site.this.getDomain();
            }

            @Override
            public Site getSite() {
                return Site.this;
            }
        };
    }

    public String getDomain() {
        return domain;
    }

    public Site setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getAgent() {
        return agent;
    }

    public Site setAgent(String agent) {
        this.agent = agent;
        return this;
    }

    public Charset getCharset() {
        return charset;
    }

    public Site setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public Map<String, String> getDefaultCookies() {
        return defaultCookies;
    }

    public Site setDefaultCookies(Map<String, String> defaultCookies) {
        this.defaultCookies = defaultCookies;
        return this;
    }

    public Table<String, String, String> getCookies() {
        return cookies;
    }

    public Site setCookies(Table<String, String, String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public Site setRequests(List<Request> requests) {
        this.requests = requests;
        return this;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public Site setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public Site setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
        return this;
    }

    public int getRetrySleepTime() {
        return retrySleepTime;
    }

    public Site setRetrySleepTime(int retrySleepTime) {
        this.retrySleepTime = retrySleepTime;
        return this;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public Site setTimeOut(int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public Set<Integer> getAcceptStatusCode() {
        return acceptStatusCode;
    }

    public Site setAcceptStatusCode(Set<Integer> acceptStatusCode) {
        this.acceptStatusCode = acceptStatusCode;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Site setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public HttpHost getHttpHost() {
        return httpHost;
    }

    public Site setHttpHost(HttpHost httpHost) {
        this.httpHost = httpHost;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (sleepTime != site.sleepTime) return false;
        if (retryTimes != site.retryTimes) return false;
        if (retrySleepTime != site.retrySleepTime) return false;
        if (timeOut != site.timeOut) return false;
        if (domain != null ? !domain.equals(site.domain) : site.domain != null) return false;
        if (agent != null ? !agent.equals(site.agent) : site.agent != null) return false;
        if (charset != null ? !charset.equals(site.charset) : site.charset != null) return false;
        if (defaultCookies != null ? !defaultCookies.equals(site.defaultCookies) : site.defaultCookies != null)
            return false;
        if (cookies != null ? !cookies.equals(site.cookies) : site.cookies != null) return false;
        if (requests != null ? !requests.equals(site.requests) : site.requests != null) return false;
        if (acceptStatusCode != null ? !acceptStatusCode.equals(site.acceptStatusCode) : site.acceptStatusCode != null)
            return false;
        if (headers != null ? !headers.equals(site.headers) : site.headers != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (agent != null ? agent.hashCode() : 0);
        result = 31 * result + (charset != null ? charset.hashCode() : 0);
        result = 31 * result + (defaultCookies != null ? defaultCookies.hashCode() : 0);
        result = 31 * result + (cookies != null ? cookies.hashCode() : 0);
        result = 31 * result + (requests != null ? requests.hashCode() : 0);
        result = 31 * result + sleepTime;
        result = 31 * result + retryTimes;
        result = 31 * result + retrySleepTime;
        result = 31 * result + timeOut;
        result = 31 * result + (acceptStatusCode != null ? acceptStatusCode.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Site{" +
                "domain='" + domain + '\'' +
                ", agent='" + agent + '\'' +
                ", charset=" + charset +
                ", defaultCookies=" + defaultCookies +
                ", cookies=" + cookies +
                ", requests=" + requests +
                ", sleepTime=" + sleepTime +
                ", retryTimes=" + retryTimes +
                ", retrySleepTime=" + retrySleepTime +
                ", timeOut=" + timeOut +
                ", acceptStatusCode=" + acceptStatusCode +
                ", headers=" + headers +
                ", httpHost=" + httpHost +
                '}';
    }
}
