package com.example.tempcw.jackierxjavaretrofitdemo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by TempCw on 2016/12/21.
 */

public interface DateInfoService {
    @GET("http://app.cyga.gov.cn/econsole/api/query/police-catalogs/")
    Observable<DateInfo> getMessage();

}
