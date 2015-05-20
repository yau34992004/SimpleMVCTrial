package com.mvc.myapplication.dagger.modules;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.mvc.myapplication.annotations.ForMainThread;
import com.mvc.myapplication.annotations.ForSafeThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by rex.yau on 4/16/2015.
 */
@dagger.Module
public class ThreadModule {
    public ThreadModule() {
    }

    @Provides
    @Singleton
    ExecutorService provideExecutorService(ThreadFactory threadFactory) {
        return Executors.newFixedThreadPool(5, threadFactory);
    }

    @Provides
    @Singleton
    ThreadFactory provideThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable) {
                    @Override
                    public void run() {
                        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                        super.run();
                    }
                };
            }
        };
    }

    @Provides
    @Singleton
    @ForMainThread
    Handler provideHandler() {
        return new Handler(Looper.getMainLooper());
    }


    @Provides
    @Singleton
    @ForSafeThread
    Handler provideSafeHandler() {
        HandlerThread handlerThread = new HandlerThread("safeThread");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

}
