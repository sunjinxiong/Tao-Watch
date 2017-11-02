package sjx.bawei.com.myjingdong.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sjx.bawei.com.myjingdong.R;

public class ChaxunActivity extends AppCompatActivity {

    private String shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);


         shop = getIntent().getStringExtra("shop");



    }






}
