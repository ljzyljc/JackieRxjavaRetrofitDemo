package com.example.tempcw.jackierxjavaretrofitdemo.permission;

import java.util.List;

/**
 * Created by TempCw on 2016/12/28.
 */

public interface PermissionListener {
    void onGranted();
    void onDenied(List<String> deniedPermission);

}
