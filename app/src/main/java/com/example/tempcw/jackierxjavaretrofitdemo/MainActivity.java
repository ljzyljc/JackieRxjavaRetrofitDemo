package com.example.tempcw.jackierxjavaretrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        Log.i("jc","jck");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://app.cyga.gov.cn/econsole/api/query/police-catalogs/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DateInfoService dateInfoService=retrofit.create(DateInfoService.class);
//        dateInfoService.getMessage().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<DateInfo>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(DateInfo dateInfo) {
//                        Log.i("jc",dateInfo.getData().get(0).getName()+"==========");
//                    }
//                });
        dateInfoService.getMessage()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //第一步：显示dialog
                        progressBar.setVisibility(View.VISIBLE);
                        Log.i("jc","显示dialog");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Observer<DateInfo>() {
            @Override
            public void onCompleted() {
                Log.i("jc","onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DateInfo dateInfo) {

                Log.i("jc","=dialog消失="+dateInfo.getData().get(3).getName());
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


    }
}
