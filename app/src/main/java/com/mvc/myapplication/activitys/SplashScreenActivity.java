package com.mvc.myapplication.activitys;

import android.os.Bundle;
import android.os.Handler;

import com.mvc.myapplication.annotations.ForSafeThread;
import com.mvc.myapplication.controllers.SplashScreenController;
import com.mvc.myapplication.dagger.components.ActivityComponent;
import com.mvc.myapplication.dagger.components.DaggerActivityComponent;
import com.mvc.myapplication.dagger.modules.ActivityModule;
import com.mvc.myapplication.models.SplashScreenModel;
import com.mvc.myapplication.singleton.MyApplication;
import com.mvc.myapplication.views.SplashScreenView;

import javax.inject.Inject;


public class SplashScreenActivity extends AbstractActivity implements SplashScreenController {

    @Inject
    @ForSafeThread
    Handler mHandler;

    @Inject
    SplashScreenModel mSplashScreenModel;

    @Inject
    SplashScreenView mSplashScreenView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().injectActivity(this);
        if (mSplashScreenModel.isFirstStart()) {
            goToHomePageAfterLogoDisplay();
        } else {
            goToHomePage();
        }
    }

    protected ActivityComponent getComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .myApplicationComponent(((MyApplication) getApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    public void goToHomePage() {
        HomeActivity.start(mSelf.get());
    }

    @Override
    public void goToHomePageAfterLogoDisplay() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeActivity.start(mSelf.get());
            }
        }, 3000);
    }
}
