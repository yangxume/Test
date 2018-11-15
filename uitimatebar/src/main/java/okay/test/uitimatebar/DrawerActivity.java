package okay.test.uitimatebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import org.zackratos.ultimatebar.UltimateBar;

/**
 * Created by Administrator on 2017/6/25.
 */

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setColorBarForDrawer(ContextCompat.getColor(this, R.color.DeepSkyBlue));

//        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.DeepSkyBlue));
//        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

    }
}
