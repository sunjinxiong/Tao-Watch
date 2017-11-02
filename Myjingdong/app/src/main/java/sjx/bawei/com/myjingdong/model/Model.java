package sjx.bawei.com.myjingdong.model;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:48
 */

public interface Model {

    void getdatafenlei();

    void Getdatafenlei2(int cid);

    void Delu(String name,String pwd);

    void Zhuce(String name,String pwd);

    void Shop(String name,int page);

    void Shopxp(int pid);

    void add(int pid,int uid,int sellerid);

    void Chacart(int uid);



}
