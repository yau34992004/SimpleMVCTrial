package com.mvc.myapplication.dagger.modules;

import android.os.Handler;

import com.mvc.myapplication.activitys.AbstractActivity;
import com.mvc.myapplication.activitys.SplashScreenActivity;
import com.mvc.myapplication.annotations.ForSafeThread;
import com.mvc.myapplication.dagger.scopes.ActivityScope;
import com.mvc.myapplication.views.SplashScreenView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rex.yau on 4/15/2015.
 */
@Module
public class ActivityModule {
    private SplashScreenActivity mActivity;

    public ActivityModule(SplashScreenActivity activity) {
        mActivity = activity;
    }


    @Provides
    @ActivityScope
    SplashScreenActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    SplashScreenView provideSplashScreenView(SplashScreenActivity activity) {
        SplashScreenView splashScreenView = new SplashScreenView();
        activity.setContentView(splashScreenView.getContentViewResId());
        return splashScreenView;
    }

}
