/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Hughes on 2016/1/2.
 */
public class Result {
    private Map<String, Object> fields = new LinkedHashMap<>();

    private boolean skip;

    public Map<String, Object> getFields() {
        return fields;
    }

    public Result setFields(Map<String, Object> fields) {
        this.fields = fields;
        return this;
    }

    public boolean isSkip() {
        return skip;
    }

    public Result setSkip(boolean skip) {
        this.skip = skip;
        return this;
    }

    public <T> T getField(String key) {
        Object object = fields.get(key);
        if (null == object) { return null;}
        return (T) object;
    }

    public <T> Result putField(String key, T value) {
        fields.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "fields=" + fields +
                ", skip=" + skip +
                '}';
    }
}
