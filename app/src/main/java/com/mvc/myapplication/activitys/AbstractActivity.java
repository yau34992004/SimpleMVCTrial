package com.mvc.myapplication.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.mvc.myapplication.dagger.components.ActivityComponent;
import com.mvc.myapplication.dagger.components.DaggerActivityComponent;
import com.mvc.myapplication.dagger.modules.ActivityModule;
import com.mvc.myapplication.singleton.MyApplication;

import java.lang.ref.WeakReference;

/**
 * Created by rex.yau on 4/16/2015.
 */
public abstract class AbstractActivity extends ActionBarActivity {

    protected ActivityComponent mActivityComponent;
    protected WeakReference<AbstractActivity> mSelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSelf = new WeakReference<>(this);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
