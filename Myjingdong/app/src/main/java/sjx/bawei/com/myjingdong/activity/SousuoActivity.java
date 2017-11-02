package sjx.bawei.com.myjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.adapter.Myadapter;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;

public class SousuoActivity extends AppCompatActivity implements View.OnClickListener, sjx.bawei.com.myjingdong.view.View{

    private android.widget.ImageView imageView2;
    private Myadapter myadapter;
    private android.widget.EditText editText;
    private android.widget.TextView textView;
    private List<Shop.DataBean> list=new ArrayList<>();;
    private int page;
    private com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView shoprecyclyview;
    private Presentes p;

    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);



        this.shoprecyclyview = (PullLoadMoreRecyclerView) findViewById(R.id.shop_recyclyview);

        this.textView = (TextView) findViewById(R.id.textView);

        this.editText = (EditText) findViewById(R.id.editText);

        this.imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView2.setOnClickListener(this);


        textView.setOnClickListener(this);

        p = new PresentesImp(this,null);

        shoprecyclyview.setLinearLayout();


        shoprecyclyview.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shoprecyclyview.setPullLoadMoreCompleted();
                    }
                },2000);


            }
            @Override
            public void onLoadMore() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        Log.i("XXX",page+"");
                        p.Shop(editText.getText().toString().trim(),page);
                        shoprecyclyview.setPullLoadMoreCompleted();
                    }
                },2000);
            }
        });

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.textView:

                page=1;

                list.clear();

                p.Shop(editText.getText().toString().trim(),page);

                break;
            case R.id.imageView2:

                finish();
                break;
        }

    }

    @Override
    public void Data(Fenlei fenlei) {

    }

    @Override
    public void Data2(Fenlei2 fenlei2) {

    }

    @Override
    public void Cg(Zhu zhu) {

    }

    @Override
    public void Sb(De de) {

    }

    @Override
    public void Shopdata(final Shop shop) {


        for(int i=0;i<shop.getData().size();i++){

            list.add(shop.getData().get(i));
        }


        if(myadapter==null){

            myadapter=new Myadapter(list,SousuoActivity.this);

            shoprecyclyview.setAdapter(myadapter);


        }else {

            myadapter.notifyDataSetChanged();
        }



        myadapter.setListener(new Myadapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {


                int pid = shop.getData().get(postion).getPid();

                Intent intent=new Intent(SousuoActivity.this,ShopActivity.class);

                intent.putExtra("pid",pid);

                startActivity(intent);

            }
        });




    }
}
