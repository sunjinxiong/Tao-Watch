package sjx.bawei.com.myjingdong.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.Cart;
import sjx.bawei.com.myjingdong.bean.Cart2;
import sjx.bawei.com.myjingdong.bean.Shopxq;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;
import sjx.bawei.com.myjingdong.view.View2;

public class ShopActivity extends AppCompatActivity implements View2, View.OnClickListener {


    private WebView webview;
    private android.widget.Button xqadd;
    private android.widget.Button xqmai;
    private Presentes p;
    private SharedPreferences sp;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shop);

        this.xqmai = (Button) findViewById(R.id.xq_mai);

        this.xqadd = (Button) findViewById(R.id.xq_add);

        this.webview = (WebView) findViewById(R.id.webview);

        pid = getIntent().getIntExtra("pid", 0);


        p = new PresentesImp(null,this);

           p.Shopxq(pid);

         sp = getSharedPreferences("user", MODE_PRIVATE);

    }

    @Override
    public void Shopxq(final Shopxq shopxq) {


        webview.setWebViewClient(new WebViewClient());

        webview.setWebChromeClient(new WebChromeClient());

        webview.getSettings().setJavaScriptEnabled(true); // 支持js

        //获取webView设置的对象
        WebSettings settings = webview.getSettings();

        webview.loadUrl(shopxq.getData().getDetailUrl());

        xqadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             p.add(pid,sp.getInt("uid",0),shopxq.getData().getSellerid());



            }
        });

    }

    @Override
    public void adddata(Cart cart) {

        Toast.makeText(ShopActivity.this,cart.getMsg(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void Cartdata(Cart2 cart2) {

    }


    @Override
    public void onClick(View v) {

    }
}
