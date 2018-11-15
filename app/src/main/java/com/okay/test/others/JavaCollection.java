package com.okay.test.others;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/16 11:01
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class JavaCollection extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testHashMap();


    }

    private void testHashMap() {

        Hashtable<Integer, String> integerStringHashtable = new Hashtable<>();

        HashMap<Integer, String> hashMap = new HashMap<>();

        Map<Integer, String> integerStringMap = Collections.synchronizedMap(hashMap);


    }
}
