package com.example.administrator.mvpdemo.mvp1;

/**
 * Created by Alexander on 2018/5/16.
 */

public class MVPModel {
    public static void getNetData(final String param, final MVPCallback callback) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param) {
                    case "normal":
                        callback.onSuccess("根据参数" + param + "的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        }, 2000);
    }
}
