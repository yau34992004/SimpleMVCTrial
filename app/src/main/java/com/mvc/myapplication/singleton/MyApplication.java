package com.mvc.myapplication.singleton;

import android.app.Application;

import com.mvc.myapplication.dagger.components.DaggerMyApplicationComponent;
import com.mvc.myapplication.dagger.components.MyApplicationComponent;
import com.mvc.myapplication.dagger.modules.MyApplicationModule;
import com.mvc.myapplication.dagger.modules.ThreadModule;

/**
 * Created by rex.yau on 4/15/2015.
 */
public class MyApplication extends Application {

    private MyApplicationComponent mMyApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApplicationComponent = DaggerMyApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .threadModule(new ThreadModule())
                .build();
        mMyApplicationComponent.inject(this);
    }

    public MyApplicationComponent getComponent() {
        return mMyApplicationComponent;
    }
}
