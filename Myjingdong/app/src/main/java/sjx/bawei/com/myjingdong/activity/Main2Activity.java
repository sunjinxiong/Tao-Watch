package sjx.bawei.com.myjingdong.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.fragmrnt.FragmnetA;
import sjx.bawei.com.myjingdong.fragmrnt.FragmnetB;
import sjx.bawei.com.myjingdong.fragmrnt.FragmnetC;
import sjx.bawei.com.myjingdong.fragmrnt.FragmnetD;
import sjx.bawei.com.myjingdong.fragmrnt.FragmnetE;

import com.hjm.bottomtabbar.BottomTabBar;

public class Main2Activity extends AppCompatActivity {

    private com.hjm.bottomtabbar.BottomTabBar bottomtabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.bottomtabar = (BottomTabBar) findViewById(R.id.bottomtabar);


        bottomtabar.init(getSupportFragmentManager())
                .setImgSize(100, 70) .setFontSize(1)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.GREEN, Color.RED)
                .addTabItem(" ", R.mipmap.acg, R.mipmap.acf, FragmnetA.class)
                .addTabItem("  ", R.mipmap.acc, R.mipmap.acb, FragmnetB.class)
                .addTabItem("   ", R.mipmap.ace,R.mipmap.acd, FragmnetC.class)
                .addTabItem("    ", R.mipmap.aca,R.mipmap.ac_, FragmnetD.class)
                .addTabItem("     ", R.mipmap.aci,R.mipmap.ach, FragmnetE.class)
                .setChangeColor(Color.WHITE,Color.WHITE).setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {

            }
        });



    }
}
