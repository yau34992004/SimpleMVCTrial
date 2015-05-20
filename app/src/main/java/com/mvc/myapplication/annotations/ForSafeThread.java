package com.mvc.myapplication.annotations;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by rex.yau on 4/16/2015.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForSafeThread {
}
