package sjx.bawei.com.myjingdong.fragmrnt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import sjx.bawei.com.myjingdong.CustomExpandableListView;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.activity.PayDemoActivity;
import sjx.bawei.com.myjingdong.bean.Cart;
import sjx.bawei.com.myjingdong.bean.Cart2;
import sjx.bawei.com.myjingdong.bean.Shopxq;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;
import sjx.bawei.com.myjingdong.view.View2;

import static android.R.attr.pointerIcon;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:17
 */

public class FragmnetD extends Fragment implements View2, View.OnClickListener {

    private SharedPreferences sp;
    private Presentes p;
    private CustomExpandableListView celv;
    private CheckBox checkBox;
    private TextView tv_num;
    private float jia;
    private TextView tv_price;
    private Cart2 cart2;
    private int ha;
    private  PhoneAdapter adapter=new PhoneAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.fragmenntd,null);

        celv = (CustomExpandableListView) view.findViewById(R.id.celv);
        checkBox = (CheckBox)view.findViewById(R.id.checkbox2);
        tv_num = (TextView)view. findViewById(R.id.tv_num);
        tv_price = (TextView) view.findViewById(R.id.tv_price);


        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


         sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);


         p= new PresentesImp(null,this);


        celv.setGroupIndicator(null);



        p.Csrt(sp.getInt("uid",0));



    }


    @Override
    public void Shopxq(Shopxq shopxq) {

    }

    @Override
    public void adddata(Cart cart) {

    }

    @Override
    public void Cartdata(Cart2 cart) {

        cart2 = cart;

          notifyCheckAdapter();


        checkBox.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (((CheckBox) v).isChecked()) {
            List<Cart2.DataBean> cart_list = cart2.getData();
            for (int i = 0; i < cart_list.size(); i++) {

                Cart2.DataBean dataBean = cart_list.get(i);

                dataBean.setIsc(true);

                List<Cart2.DataBean.ListBean> list = dataBean.getList();

                for (int j = 0; j < list.size(); j++) {

                    List<Cart2.DataBean.ListBean> list1 = cart_list.get(i).getList();

                    for(Cart2.DataBean.ListBean good:list1){

                       good.setIsv2(true);
                    }
                }
            }
            //刷新界面
            notifyCheckAdapter();
        } else {
            List<Cart2.DataBean> cart_list = cart2.getData();
            for (int i = 0; i < cart_list.size(); i++) {

                Cart2.DataBean dataBean = cart_list.get(i);

                dataBean.setIsc(false);

                List<Cart2.DataBean.ListBean> list = dataBean.getList();

                for (int j = 0; j < list.size(); j++) {

                    List<Cart2.DataBean.ListBean> list1 = cart_list.get(i).getList();

                    for(Cart2.DataBean.ListBean good:list1){

                        good.setIsv2(false);
                    }
                }
            }
            //刷新界面
            notifyCheckAdapter();
        }


    }

    private class PhoneAdapter implements ExpandableListAdapter {

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getGroupCount() {

            return cart2.getData().size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {


            return cart2.getData().get(groupPosition).getList().size();
        }

        @Override
        public Object getGroup(int groupPosition) {


            return cart2.getData().get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {

            return cart2.getData().get(groupPosition).getList().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        //一级
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View view = View.inflate(getActivity(), R.layout.item_parent_market, null);

            CheckBox cb_parent = (CheckBox) view.findViewById(R.id.cb_parent);

            TextView tv_sign=(TextView)view.findViewById(R.id.tv_sign);

            tv_sign.setText(cart2.getData().get(groupPosition).getSellerName());

            TextView tv_number = (TextView) view.findViewById(R.id.tv_number);

//            tv_number.setText(cart.getDatas().getCart_list().get(pointerIcon).getStore_name());

            if (cart2.getData().get(groupPosition).isc()) {

                cb_parent.setChecked(true);

            } else {

                cb_parent.setChecked(false);

            }
            //一级监听
            cb_parent.setOnClickListener(new OnGroupClickListener(groupPosition, cb_parent));

            return view;
        }

        //二级
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = View.inflate(getActivity(), R.layout.item_child_market, null);
            TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
            TextView tv_pri = (TextView) view.findViewById(R.id.tv_pri);
            CheckBox cb_child = (CheckBox) view.findViewById(R.id.cb_child);

            TextView num= (TextView) view.findViewById(R.id.num);

            ImageView cart_ima=(ImageView)view.findViewById(R.id.cart_ima);

            String images = cart2.getData().get(groupPosition).getList().get(childPosition).getImages();

            String[] split = images.split("!");

            Picasso.with(getActivity()).load(split[0]).into(cart_ima);

//            tv_pri.setText((int) cart2.getData().get(groupPosition).getList().get(childPosition).getPrice());

            num.setText("数量："+cart2.getData().get(groupPosition).getList().get(childPosition).getNum());
            tv_content.setText(cart2.getData().get(groupPosition).getList().get(childPosition).getTitle());

            if (cart2.getData().get(groupPosition).getList().get(childPosition).isv2()) {

                cb_child.setChecked(true);

            } else {

                cb_child.setChecked(false);
            }

            cb_child.setOnClickListener(new OnChildCheckListener(groupPosition, childPosition, cb_child));

            return view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }
    }
    private class OnGroupClickListener implements View.OnClickListener {
        int groupPosition;
        CheckBox cb_parent;

        public OnGroupClickListener(int groupPosition, CheckBox cb_parent) {
            this.cb_parent = cb_parent;
            this.groupPosition = groupPosition;
        }

        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
                //一级全选
                setCheck(true);

            } else {
                //取消全选
                setCheck(false);

                checkBox.setChecked(false);
            }
            notifyCheckAdapter();
        }

        public void setCheck(boolean checkFlag) {

            Cart2.DataBean cartListBean = cart2.getData().get(groupPosition);

            List<Cart2.DataBean> cart_list = cart2.getData();
            //一级状态

            cartListBean.setIsc(checkFlag);

            //全选状态判断
            int num = 0;
            for (int i = 0; i < cart_list.size(); i++) {
                boolean allCheck = cart_list.get(i).isc();
                if (!allCheck) {
                    num++;
                }
            }
            if (num == 0) {

                checkBox.setChecked(true);

            } else {

                checkBox.setChecked(false);

            }
            //二级状态
            List<Cart2.DataBean.ListBean> goods = cartListBean.getList();
            for (Cart2.DataBean.ListBean childData : goods) {
                //二级状态
                childData.setIsv2(checkFlag);

            }
        }
    }
    private class OnChildCheckListener implements View.OnClickListener {
        int groupPosition;
        int childPosition;
        CheckBox cb_child;

        public OnChildCheckListener(int groupPosition, int childPosition, CheckBox cb_child) {
            this.cb_child = cb_child;
            this.groupPosition = groupPosition;
            this.childPosition = childPosition;
        }

        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
//                子选中
                cart2.getData().get(groupPosition).getList().get(childPosition).setIsv2(true);



            } else {
                //子未选中
                cart2.getData().get(groupPosition).getList().get(childPosition).setIsv2(false);

            }
            //二级联动一级状态
            setParentCheckFlag();

            //检测状态 二级联动全选
            int num = 0;
            for (int i = 0; i <cart2.getData().size(); i++) {

                boolean allCheck = cart2.getData().get(groupPosition).isc();
                if (!allCheck) {
                    num++;
                }

            }
            if (num == 0) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        }

        //二级联动一级状态
        private void setParentCheckFlag() {

            Cart2.DataBean cartListBean = cart2.getData().get(groupPosition);
            List<Cart2.DataBean.ListBean> goods = cartListBean.getList();
            for (int i = 0; i < goods.size(); i++) {
                if (!goods.get(i).isv2()) {
                    //子未选中 父取消选中
                    cartListBean.setIsc(false);
                    notifyCheckAdapter();

                    return;
                }
                if (i == goods.size() - 1) {
                    //子选中 父选中
                    cartListBean.setIsc(true);

                    notifyCheckAdapter();

                    return;
                }


            }
//            没出现全选或者取消全选的时候执行的
            sum();
        }

    }

    private void sum() {
        int num = 0;
        float price = 0;

        final List<Cart2.DataBean> cart_list = cart2.getData();
        for (Cart2.DataBean list : cart_list) {
            for (Cart2.DataBean.ListBean child : list.getList()) {
                if (child.isv2()) {
                    num++;
                    price +=Float.valueOf((float) child.getPrice())*Float.valueOf(child.getNum());

                }
            }
        }

        tv_num.setText("结算(" + num + ")");
        tv_price.setText("¥" + price);

        ha = num;
        Log.i("ha", ha +"");
        jia = price;

        tv_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PayDemoActivity.class);


                startActivity(intent);
            }
        });

    }



    /*
    public void getha(){

        tv_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Cart.DatasBean.CartListBean.GoodsBean> list=new ArrayList<Cart.DatasBean.CartListBean.GoodsBean>();

                if(ha==0){

                    Toast.makeText(getActivity(),"你不能这么干啊",Toast.LENGTH_SHORT).show();

                }else {

                    for (int i = 0; i < cart2.getDatas().getCart_list().size(); i++) {

                        for (int j = 0; j < cart2.getDatas().getCart_list().get(i).getGoods().size(); j++) {

                            if (cart2.getDatas().getCart_list().get(i).getGoods().get(j).isItemCheck()) {
                                list.add(cart2.getDatas().getCart_list().get(i).getGoods().get(j));
                            } else {


                            }
                        }
                    }

                    Log.i("ha",ha+"");
                    Intent intent = new Intent(getActivity(), DingdanActivity.class);
                    intent.putExtra("cart", (Serializable)list);
                    intent.putExtra("num", jia + "");
                    startActivity(intent);

                }
            }
        });


    };

    */

    private void notifyCheckAdapter() {
        sum();
        celv.setAdapter(adapter);
        int count = celv.getCount();
        for (int i = 0; i < count; i++) {
            celv.expandGroup(i);
        }
    }
/*
    public void getdata(){

        String path="http://169.254.254.142/mobile/index.php?act=member_cart&op=cart_list";
        RequestParams requestParams = new RequestParams(path);
        requestParams.addBodyParameter("key",keym);
        x.http().post(requestParams, new org.xutils.common.Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                Gson gson=new Gson();

                cart2 = gson.fromJson(result, Cart.class);

                notifyCheckAdapter();

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.i("++++", "失败");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    */

    @Override
    public void onPause() {
        super.onPause();


    }

    @Override
    public void onResume() {
        super.onResume();

        p.Csrt(sp.getInt("uid",0));


    }
}
