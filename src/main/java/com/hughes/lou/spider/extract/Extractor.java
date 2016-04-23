/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.extract;

import java.util.List;

/**
 * Created by Hughes on 2016/1/3.
 */
public interface Extractor {
    String select(String text);

    List<String> selectList(String text);
}
