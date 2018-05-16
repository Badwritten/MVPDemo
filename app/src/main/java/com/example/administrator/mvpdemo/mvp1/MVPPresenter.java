package com.example.administrator.mvpdemo.mvp1;

/**
 * Created by Alexander on 2018/5/16.
 */

public class MVPPresenter {

    //View接口
    private MVPView mView;

    public MVPPresenter() {
        //构造方法中不再需要View参数
    }

    /**
     * 绑定View,一般在初始化中调用该方法
     */
    public void attachView(MVPView mvpView) {
        this.mView = mvpView;
    }

    /**
     * 断开View,一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        //显示正在加载进度条
        mView.showLoading();
        // 调用Model请求数据
        MVPModel.getNetData(params, new MVPCallback() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if (isViewAttached()) {
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if (isViewAttached()) {
                    mView.showFailureMessage(msg);
                }

            }

            @Override
            public void onError() {
                //调用view接口提示请求异常
                if (isViewAttached()) {
                    mView.showErrorMessage();
                }

            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if (isViewAttached()) {
                    mView.hideLoading();
                }
            }
        });
    }
}
