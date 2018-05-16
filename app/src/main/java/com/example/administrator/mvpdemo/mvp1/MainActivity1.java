package com.example.administrator.mvpdemo.mvp1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;

public class MainActivity1 extends AppCompatActivity implements MVPView {
    //进度条
    ProgressDialog progressDialog;
    TextView text;
    MVPPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MVPPresenter();

        //绑定View引用
        presenter.attachView(this);


    }

    /**
     * 三个点击事件
     *
     * @param view
     */
    public void getData(View view) {
        presenter.getData("normal");
    }

    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    public void getDataForError(View view) {
        presenter.getData("error");
    }

    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开View引用
        presenter.detachView();
    }
}
