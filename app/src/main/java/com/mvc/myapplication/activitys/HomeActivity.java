package com.mvc.myapplication.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mvc.myapplication.models.MenuItemFactory_Factory;
import com.mvc.myapplication.views.HomeMenuView;

/**
 * Created by rex.yau on 4/15/2015.
 */
public class HomeActivity extends AbstractActivity {

    private HomeMenuView mHomeMenuView;

    public static void start(Activity activity) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHomeMenuView = new HomeMenuView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(mHomeMenuView.getMenuId(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mHomeMenuView.isHandleEvent(id)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
