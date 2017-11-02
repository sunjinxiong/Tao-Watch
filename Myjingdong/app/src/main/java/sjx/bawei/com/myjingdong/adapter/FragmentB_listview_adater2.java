package sjx.bawei.com.myjingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.Fenlei2;

/**
 * dell 孙劲雄
 * 2017/10/18
 * 8:59
 */

public class FragmentB_listview_adater2 extends BaseAdapter {

    private Context context;
    private Fenlei2 fenlei2;

    public FragmentB_listview_adater2(Context context, Fenlei2 fenlei2) {
        this.context = context;
        this.fenlei2 = fenlei2;
    }

    @Override
    public int getCount() {

        return fenlei2.getData().size();
    }

    @Override
    public Object getItem(int position) {

        return fenlei2.getData().get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholde viewholder;
        if(convertView==null){

            viewholder=new Viewholde();

            convertView=View.inflate(context,R.layout.fragmnet_listview_item2,null);

            viewholder.textView= (TextView) convertView.findViewById(R.id.item2);

            viewholder.gridview= (GridView) convertView.findViewById(R.id.gridview);

            convertView.setTag(viewholder);

        }else {

            viewholder= (Viewholde) convertView.getTag();

        }

        List<Fenlei2.DataBean.ListBean> data = fenlei2.getData().get(position).getList();

        viewholder.textView.setText(fenlei2.getData().get(position).getName());

        Graideview adapter=new Graideview(data,context);

        viewholder.gridview.setAdapter(adapter);

        return convertView;
    }

    class Viewholde{

        TextView textView;

        GridView gridview;

    }

}
