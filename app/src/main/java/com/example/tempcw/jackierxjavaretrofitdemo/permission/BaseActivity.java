package com.example.tempcw.jackierxjavaretrofitdemo.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TempCw on 2016/12/28.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    private static PermissionListener mListener;
    public static void requeseRunTimePermission(String []permissions,PermissionListener listener){
        Activity topActivity=ActivityCollector.getTopActivity();
        if (topActivity==null){
            return;
        }
        mListener=listener;
        List<String> permissionList=new ArrayList<>();
        for (String permission:permissions){
            //如果没有允许该权限，就添加到该List中
            if (ActivityCompat.checkSelfPermission(topActivity,permission)!= PackageManager.PERMISSION_GRANTED){
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(topActivity,permissionList.toArray(new String[permissionList.size()]),1);
        }else{
            mListener.onGranted();
        }

    }
//    grantResults (授权的结果)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length>0){
                    List<String> deniedPermissionList=new ArrayList<>();
                    for (int i=0;i<grantResults.length;i++){
                        int grantResult=grantResults[i];
                        String permission=permissions[i];
                        if (grantResult!=PackageManager.PERMISSION_GRANTED){
                            deniedPermissionList.add(permission);
                        }
                    }
                    if (deniedPermissionList.isEmpty()){
                        mListener.onGranted();
                    }else{
                        mListener.onDenied(deniedPermissionList);
                    }
                }
                break;
            default:
                break;
        }

    }
}
