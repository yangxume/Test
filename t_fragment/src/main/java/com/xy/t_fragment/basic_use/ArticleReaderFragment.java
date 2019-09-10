package com.xy.t_fragment.basic_use;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xy.t_fragment.R;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-10 15:56
 * @Desc:
 */
public class ArticleReaderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_articlereader,container,false);

    }
}
