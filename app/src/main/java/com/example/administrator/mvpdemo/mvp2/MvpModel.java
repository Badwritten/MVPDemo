package com.example.administrator.mvpdemo.mvp2;

import com.example.administrator.mvpdemo.base.Callback;

import java.util.logging.Handler;

/**
 * Created by Alexander on 2018/5/16.
 */

public class MvpModel {
    /**
     * 获取网络接口数据
     *
     * @param param    请求参数
     * @param callback 数据回调接口
     */
    public static void getNetData(final String param, final Callback<String> callback) {
        //利用postDelayed方法模拟网络请求数据的耗时操作
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
