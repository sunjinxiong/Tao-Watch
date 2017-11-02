package sjx.bawei.com.myjingdong.presentes;

import sjx.bawei.com.myjingdong.activity.ShopActivity;
import sjx.bawei.com.myjingdong.bean.Cart;
import sjx.bawei.com.myjingdong.bean.Cart2;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Shopxq;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.model.Model;
import sjx.bawei.com.myjingdong.model.Modelmp;
import sjx.bawei.com.myjingdong.view.View;
import sjx.bawei.com.myjingdong.view.View2;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:48
 */

public class PresentesImp implements Presentes {

    private Model model;
    private View view;
    private View2 view2;

    public PresentesImp(View view, View2 view2) {
        this.view = view;
        this.view2 = view2;
        model=new Modelmp(this);
    }

    @Override
    public void getdata() {

        model.getdatafenlei();

    }

    @Override
    public void Data(Fenlei fenlei) {

        view.Data(fenlei);
    }

    @Override
    public void GetdataFenlei2(int cid) {

        model.Getdatafenlei2(cid);

    }

    @Override
    public void Data2(Fenlei2 fenlei2) {

        view.Data2(fenlei2);

    }

    @Override
    public void Zhucezi(Zhu zhu) {

        view.Cg(zhu);
    }

    @Override
    public void Dezhi(De de) {

        view.Sb(de);

    }

    @Override
    public void Delu(String name, String pwd) {

        model.Delu(name,pwd);

    }

    @Override
    public void Zhuce(String name, String pwd) {

        model.Zhuce(name,pwd);

    }

    @Override
    public void Shop(String name, int page) {

        model.Shop(name,page);
    }

    @Override
    public void Shopdata(Shop shop) {

        view.Shopdata(shop);

    }

    @Override
    public void Shopxq(int pid) {

        model.Shopxp(pid);

    }

    @Override
    public void Shopxqdata(Shopxq shopxq) {

        view2.Shopxq(shopxq);
    }

    @Override
    public void add(int pid, int uid, int sellerid) {

        model.add(pid,uid,sellerid);

    }

    @Override
    public void adddata(Cart cart) {

        view2.adddata(cart);
    }

    @Override
    public void Csrt(int uid) {

        model.Chacart(uid);
    }

    @Override
    public void Cartdata(Cart2 cart2) {

        view2.Cartdata(cart2);

    }


}
