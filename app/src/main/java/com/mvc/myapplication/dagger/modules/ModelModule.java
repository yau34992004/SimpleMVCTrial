package com.mvc.myapplication.dagger.modules;

import com.mvc.myapplication.models.SplashScreenModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rex.yau on 4/16/2015.
 */
@Module
public class ModelModule {

    public ModelModule() {
    }

    @Provides
    @Singleton
    SplashScreenModel provideSplashScreenModel() {
        return new SplashScreenModel();
    }
}
