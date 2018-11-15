package com.okay.test.activity.activity03_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.okay.test.R;
import com.okay.test.view.nice_spinner.ReportSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/4/2 12:19
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity03_02_NiceSpinner extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity03_02_nicespinner);

        ReportSpinner reportSpinner = (ReportSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("按题查看", "按人查看"));
        reportSpinner.setDataSource(dataset);

       reportSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               Log.d("position","position="+position);

           }
       });


        int selectedIndex = reportSpinner.getSelectedIndex();
        Log.d("okay","select="+selectedIndex);
    }
}
