package com.mvc.myapplication.views;

import com.mvc.myapplication.R;

/**
 * Created by rex.yau on 4/15/2015.
 */
public class HomeMenuView {
    public int getMenuId(){
        return R.menu.menu_main;
    }
    public boolean isHandleEvent(int id){
        if(id == R.id.action_settings){

            return true;
        }
        return false;
    }
}
