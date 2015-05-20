package com.mvc.myapplication.dagger.modules;

import android.app.AlarmManager;
import android.content.Context;

import com.mvc.myapplication.singleton.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rex.yau on 4/15/2015.
 */
@Module
public class SystemServiceModule {

    public SystemServiceModule() {
    }

    @Provides
    @Singleton
    AlarmManager provideActivity(MyApplication application) {
        return (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
    }



}
