package okay.test.uitimatebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.zackratos.ultimatebar.UltimateBar;

public class HintBarActivity1 extends AppCompatActivity {

//    private View toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

//        toolbar = findViewById(R.id.include_toolbar);
//        toolbar.setVisibility(View.GONE);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            UltimateBar ultimateBar = new UltimateBar(this);
            ultimateBar.setHintBar();
        }
    }

/*    @Override
    protected void initBar() {
        setHintBar();
    }*/
}
