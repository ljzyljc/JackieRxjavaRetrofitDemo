package com.example.tempcw.jackierxjavaretrofitdemo.permission;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tempcw.jackierxjavaretrofitdemo.R;

import java.util.List;

/**
 * Created by TempCw on 2016/12/28.
 */

public class TestActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

    }

    public void btn(View v){
        Toast.makeText(TestActivity.this,"ceshi",Toast.LENGTH_SHORT).show();
        requeseRunTimePermission(new String[]{Manifest.permission.CALL_PHONE,
                         Manifest.permission.WRITE_EXTERNAL_STORAGE}
                , new PermissionListener() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(TestActivity.this,"所有权限都同意了",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {
                        for (String permission: deniedPermission){
                            Toast.makeText(TestActivity.this, "被拒绝权限："+permission, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
