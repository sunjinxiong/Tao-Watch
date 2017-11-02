package sjx.bawei.com.myjingdong.activity;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.okhttputils.HttpUtils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import sjx.bawei.com.myjingdong.R;

public class XiugaiActivity extends AppCompatActivity {

    private android.widget.EditText xiugainame;
    private android.widget.ImageView imageView3;
    private android.widget.TextView xiugai;
    private int uid;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_xiugai);

        this.xiugai = (TextView) findViewById(R.id.xiugai);

        this.imageView3 = (ImageView) findViewById(R.id.imageView3);

        this.xiugainame = (EditText) findViewById(R.id.xiugai_name);

        username = getIntent().getStringExtra("username");

        uid = getIntent().getIntExtra("uid",0);

        xiugainame.setText(username);


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void getdata(){

        String path="http://120.27.23.105/user/updateNickName";

        Map<String,Object> map=new ArrayMap<>();
        map.put("uid",uid);
        map.put("nickname",username);


    }


}
