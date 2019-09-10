package com.xy.t_fragment.basic_use;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xy.t_fragment.R;
import com.xy.t_fragment.basic_use.ArticleReaderFragment;

/**
 * https://developer.android.google.cn/guide/components/fragments.html
 */
public class BasicUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_use);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ArticleReaderFragment articleReaderFragment = new ArticleReaderFragment();
        fragmentTransaction.add(R.id.ll_main,articleReaderFragment);
        fragmentTransaction.commit();
    }
}
