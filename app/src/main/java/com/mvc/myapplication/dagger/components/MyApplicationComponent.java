package com.mvc.myapplication.dagger.components;

import android.content.Context;
import android.os.Handler;

import com.mvc.myapplication.annotations.ForApplication;
import com.mvc.myapplication.annotations.ForSafeThread;
import com.mvc.myapplication.dagger.modules.ModelModule;
import com.mvc.myapplication.dagger.modules.MyApplicationModule;
import com.mvc.myapplication.dagger.modules.ThreadModule;
import com.mvc.myapplication.dagger.scopes.ApplicationScope;
import com.mvc.myapplication.models.SplashScreenModel;
import com.mvc.myapplication.singleton.MyApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rex.yau on 4/15/2015.
 */
@Singleton
@Component(
        modules = {MyApplicationModule.class, ThreadModule.class, ModelModule.class})
public interface MyApplicationComponent {

    void inject(MyApplication application);

    @ForApplication
    Context appContext();
//
//    @ForSafeThread
//    Handler handler();
//
//    SplashScreenModel splashScreenModel();
}
