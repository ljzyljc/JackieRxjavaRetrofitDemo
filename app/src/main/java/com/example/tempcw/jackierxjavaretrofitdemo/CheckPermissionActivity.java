package com.example.tempcw.jackierxjavaretrofitdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Created by TempCw on 2016/12/28.
 */

public class CheckPermissionActivity extends Activity{
    private RxPermissions rxPermissions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rxPermissions=new RxPermissions(this);
//        rxPermissions.request(Manifest.permission.CALL_PHONE).compose()
//
//        RxView.clicks(findViewById(R.id.btn))
//                .compose(rxPermissions.ensure(Manifest.permission.CALL_PHONE))
//                .subscribe();

    }
    public void call(View view) {
        if (ContextCompat.checkSelfPermission(CheckPermissionActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CheckPermissionActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {

            callPhone();
        }
    }
    public void callPhone() {
        try {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch (SecurityException e){       //必须捕捉此异常，否则就会报错
            e.printStackTrace();
    }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    callPhone();
                }else{
                    Toast.makeText(this,"拒绝了此权限",Toast.LENGTH_SHORT).show();
                }
            break;
            default:
                break;
        }



    }
}
