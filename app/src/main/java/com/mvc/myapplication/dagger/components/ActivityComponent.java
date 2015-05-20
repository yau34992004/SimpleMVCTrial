package com.mvc.myapplication.dagger.components;

import android.app.Activity;

import com.mvc.myapplication.activitys.AbstractActivity;
import com.mvc.myapplication.activitys.HomeActivity;
import com.mvc.myapplication.activitys.SplashScreenActivity;
import com.mvc.myapplication.dagger.modules.ActivityModule;
import com.mvc.myapplication.dagger.scopes.ActivityScope;
import com.mvc.myapplication.views.SplashScreenView;

import dagger.Component;

/**
 * Created by rex.yau on 4/15/2015.
 */
@ActivityScope
@Component(dependencies = MyApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent extends MyApplicationComponent {

    void injectActivity(SplashScreenActivity activity);
}
