package com.mvc.myapplication.dagger.modules;

import android.content.Context;

import com.mvc.myapplication.annotations.ForApplication;
import com.mvc.myapplication.singleton.MyApplication;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by rex.yau on 4/15/2015.
 */
@dagger.Module
public class MyApplicationModule {

    private final MyApplication application;


    public MyApplicationModule(MyApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }


}
