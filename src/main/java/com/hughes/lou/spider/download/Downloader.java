/*
 * Copyright (c) 2016. Hughes. All rights reserved.
 */

package com.hughes.lou.spider.download;

import com.hughes.lou.spider.model.Page;
import com.hughes.lou.spider.model.Request;
import com.hughes.lou.spider.model.Task;

/**
 * Created by Hughes on 2016/1/6.
 */
public interface Downloader {

    Page download(Request request, Task task);

    void setThread(int num);
}

