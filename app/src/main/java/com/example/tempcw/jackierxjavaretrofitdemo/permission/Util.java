package com.example.tempcw.jackierxjavaretrofitdemo.permission;

import android.Manifest;

import java.util.List;

/**
 * Created by TempCw on 2016/12/28.
 */

public class Util {

    //如果在没有Activity的界面如何执行
    public void test(){
        BaseActivity.requeseRunTimePermission(new String[]{Manifest.permission.CALL_PHONE},
                new PermissionListener() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {

                    }
                });

    }
}
