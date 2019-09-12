package com.xy.t_fragment.vp_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-10 15:32
 * @Desc:
 *
 * https://blog.csdn.net/qq_27870227/article/details/97031308
 *
 */
public abstract class BaseFragment extends Fragment {

    protected  final String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(getLayoutId(), null);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();


}
