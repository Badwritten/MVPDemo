package com.example.administrator.mvpdemo.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alexander on 2018/5/16.
 */

public abstract class BaseFragment extends Fragment implements BaseView {
    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

//    @Override
//    public void showLoading() {
//        checkActivityAttached();
//        ((BaseFragment)mContext).showLoading();
//    }
//
//    @Override
//    public void hideLoading() {
//        checkActivityAttached();
//        hideLoading();
//    }
//
//    @Override
//    public void showToast(String msg) {
//        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showToast(msg);
//    }
//
//    @Override
//    public void showErr() {
//        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showErr();
//    }
//
//    protected boolean isAttachedContext() {
//        return getActivity() != null;
//    }
//
//    /**
//     * 检查activity连接情况
//     */
//    public void checkActivityAttached() {
//        if (getActivity() == null) {
//            throw new ActivityNotAttachedException();
//        }
//    }
//
//    public static class ActivityNotAttachedException extends RuntimeException {
//        public ActivityNotAttachedException() {
//            super("Fragment has disconnected from Activity ! - -.");
//        }
//    }

}
