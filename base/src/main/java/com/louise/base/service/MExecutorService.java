package com.louise.base.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MExecutorService {
    public static ExecutorService mExecutor;

    public static ExecutorService newThreadPool() {

        if (mExecutor == null) {
            mExecutor = Executors.newScheduledThreadPool(5);
        }
        return mExecutor;
    }
}
