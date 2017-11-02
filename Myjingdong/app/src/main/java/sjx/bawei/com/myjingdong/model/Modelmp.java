package sjx.bawei.com.myjingdong.model;

import android.util.Log;

import com.bwie.okhttputils.HttpUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import sjx.bawei.com.myjingdong.APi;
import sjx.bawei.com.myjingdong.bean.Cart;
import sjx.bawei.com.myjingdong.bean.Cart2;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Shopxq;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.presentes.Presentes;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:48
 */

public class Modelmp implements Model {

    private Presentes p;

    public Modelmp(Presentes p) {
        this.p = p;
    }
    @Override
    public void getdatafenlei() {

        HttpUtils.doGet(APi.Fenlei, new HttpUtils.GsonObjectCallback<Fenlei>() {
            @Override
            public void onUi(Fenlei fenlei) {

                p.Data(fenlei);
            }
            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }
    @Override
    public void Getdatafenlei2(int cid) {


        Log.i("sjxsjx",APi.Fenlei2 + "?cid="+cid+"");

        HttpUtils.doGet(APi.Fenlei2 + "?cid=" + cid, new HttpUtils.GsonObjectCallback<Fenlei2>() {
            @Override
            public void onUi(Fenlei2 fenlei2) {
                p.Data2(fenlei2);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });



    }
    @Override
    public void Delu(String name, String pwd) {

        String path="http://120.27.23.105/user/login";

        Map<String,String> map=new HashMap<String, String>();

        map.put("mobile",name);
        map.put("password",pwd);

        HttpUtils.doPost(path, map, new HttpUtils.GsonObjectCallback<De>() {
            @Override
            public void onUi(De de) {

                p.Dezhi(de);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }
    @Override
    public void Zhuce(String name, String pwd) {

        String path = "http://120.27.23.105/user/reg";
        Map<String, String> map = new HashMap<String, String>();

        map.put("mobile", name);
        map.put("password", pwd);

        HttpUtils.doPost(path, map, new HttpUtils.GsonObjectCallback<Zhu>() {
            @Override
            public void onUi(Zhu zhu) {

                p.Zhucezi(zhu);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


    }

    @Override
    public void Shop(String name, int page) {

    String path="http://120.27.23.105/product/searchProducts?keywords="+name+"&page="+page+"";

        HttpUtils.doGet(path, new HttpUtils.GsonObjectCallback<Shop>() {
            @Override
            public void onUi(Shop shop) {

                p.Shopdata(shop);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });



    }

    @Override
    public void Shopxp(int pid) {

        String path="http://120.27.23.105/product/getProductDetail?pid="+pid+"";

        HttpUtils.doGet(path, new HttpUtils.GsonObjectCallback<Shopxq>() {
            @Override
            public void onUi(Shopxq shopxq) {

                p.Shopxqdata(shopxq);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }

    @Override
    public void add(int pid, int uid, int sellerid) {

        String path="http://120.27.23.105/product/addCart?pid="+pid+"&uid="+uid+"&sellerid="+sellerid+"";

        Log.i("sjx",path+"");

        HttpUtils.doGet(path, new HttpUtils.GsonObjectCallback<Cart>() {
            @Override
            public void onUi(Cart cart) {

                p.adddata(cart);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });





    }

    @Override
    public void Chacart(int uid) {

        String path="http://120.27.23.105/product/getCarts?uid="+uid+"";

        HttpUtils.doGet(path, new HttpUtils.GsonObjectCallback<Cart2>() {
            @Override
            public void onUi(Cart2 cart2) {

            p.Cartdata(cart2);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


    }
}
