package okay.test.fitchart;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;

import okay.test.fitchart.doughnut.DoughnutChart;
import okay.test.fitchart.doughnut.DoughnutChartValue;


public class MainActivity extends Activity {

    private DoughnutChart fitChart1,fitChart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fitChart1 = (DoughnutChart)findViewById(R.id.fitChart1);
        fitChart2 = (DoughnutChart)findViewById(R.id.fitChart2);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                Collection<DoughnutChartValue> values1 = new ArrayList<>();
                Collection<DoughnutChartValue> values2 = new ArrayList<>();

//                values.add(new DoughnutChartValue(30f, resources.getColor(R.color.chart_value_1)));
//                values.add(new DoughnutChartValue(20f, resources.getColor(R.color.chart_value_2)));
//                values.add(new DoughnutChartValue(15f, resources.getColor(R.color.chart_value_3)));

                values1.add(new DoughnutChartValue(30f, resources.getColor(R.color.green_start)));
//                values1.add(new DoughnutChartValue(70f, resources.getColor(R.color.green_end)));

                values2.add(new DoughnutChartValue(36f, resources.getColor(R.color.blue_start)));
//                values2.add(new DoughnutChartValue(46f, resources.getColor(R.color.blue_end)));

//                fitChart1.setValues(values1);
//                fitChart2.setValues(values2);
                fitChart1.setValue(78f,
                        resources.getColor(R.color.blue_start),
                        resources.getColor(R.color.blue_end));
                fitChart2.setValue(69f,
                        resources.getColor(R.color.green_start),
                        resources.getColor(R.color.green_end));



            }
        });
    }
}
