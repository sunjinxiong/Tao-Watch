package sjx.bawei.com.myjingdong.presentes;

import sjx.bawei.com.myjingdong.bean.Cart;
import sjx.bawei.com.myjingdong.bean.Cart2;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Shopxq;
import sjx.bawei.com.myjingdong.bean.Zhu;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:48
 */

public interface Presentes {


    void getdata();

    void Data(Fenlei fenlei);

    void GetdataFenlei2(int cid);

    void Data2(Fenlei2 fenlei2);

    void Zhucezi(Zhu zhu);

    void Dezhi(De de);

    void Delu(String name,String pwd);

    void Zhuce(String name,String pwd);

    void Shop(String name,int page);

    void Shopdata(Shop shop);

    void Shopxq(int pid);

    void Shopxqdata(Shopxq shopxq);

    void add(int pid, int uid, int sellerid);

    void adddata(Cart cart);

    void Csrt(int uid);

    void Cartdata(Cart2 cart2);



}
