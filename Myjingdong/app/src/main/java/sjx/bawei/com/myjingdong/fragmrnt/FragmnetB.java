package sjx.bawei.com.myjingdong.fragmrnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import sjx.bawei.com.myjingdong.adapter.FragmentB_listview_Adapter;
import sjx.bawei.com.myjingdong.adapter.FragmentB_listview_adater2;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;
import sjx.bawei.com.myjingdong.view.View;
import sjx.bawei.com.myjingdong.R;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:17
 */

public class FragmnetB extends Fragment implements View {

    private ListView listView;
    private TextView textView;
    private ListView listView2;
    private Presentes presentes;
    FragmentB_listview_adater2 adater2;


    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        android.view.View view= android.view.View.inflate(getActivity(), R.layout.fragmentb,null);

        listView= (ListView) view.findViewById(R.id.fragmentb_listview);



        listView2= (ListView) view.findViewById(R.id.fragmentb_listview2);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        presentes = new PresentesImp(this,null);

        presentes.getdata();


    }
    @Override
    public void Data(final Fenlei fenlei) {

        FragmentB_listview_Adapter adapter=new FragmentB_listview_Adapter(getActivity(),fenlei);

        listView.setAdapter(adapter);

        presentes.GetdataFenlei2(1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {

                presentes.GetdataFenlei2(fenlei.getData().get(position).getCid());

            }
        });

    }

    @Override
    public void Data2(Fenlei2 fenlei2) {

            adater2 = new FragmentB_listview_adater2(getActivity(), fenlei2);
            listView2.setAdapter(adater2);

        }

    @Override
    public void Cg(Zhu zhu) {

    }

    @Override
    public void Sb(De de) {

    }

    @Override
    public void Shopdata(Shop shop) {

    }
}
