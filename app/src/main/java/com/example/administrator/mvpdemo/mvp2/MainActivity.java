package com.example.administrator.mvpdemo.mvp2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements MvpView {

    TextView text;
    MvpPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        //初始化Presenter
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开View引用
        presenter.detachView();
    }


    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void showData(String data) {

    }

    // button 点击事件调用方法
    public void getData(View view) {
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.getData("error");
    }
}
