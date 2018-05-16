package com.example.administrator.mvpdemo.mvp2;

import com.example.administrator.mvpdemo.base.BaseView;

/**
 * Created by Alexander on 2018/5/16.
 */

public interface MvpView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     *
     * @param data 数据源
     */
    void showData(String data);
}
