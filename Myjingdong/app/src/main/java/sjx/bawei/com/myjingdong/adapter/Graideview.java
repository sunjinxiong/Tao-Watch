package sjx.bawei.com.myjingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.Fenlei2;

/**
 * dell 孙劲雄
 * 2017/10/18
 * 9:15
 */

public class Graideview extends BaseAdapter {

    private List<Fenlei2.DataBean.ListBean> fenlei2;
    private Context context;

    public Graideview(List<Fenlei2.DataBean.ListBean> fenlei2, Context context) {
        this.fenlei2 = fenlei2;
        this.context = context;
    }

    @Override
    public int getCount() {

        return fenlei2.size();
    }

    @Override
    public Object getItem(int position) {

        return fenlei2.get(position);
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

            convertView=View.inflate(context, R.layout.grideview,null);

            viewholder.textView= (TextView) convertView.findViewById(R.id.grideview);


            convertView.setTag(viewholder);

        }else {

            viewholder= (Viewholde) convertView.getTag();

        }

        viewholder.textView.setText(fenlei2.get(position).getName());

        return convertView;
    }
    class Viewholde{

        TextView textView;

    }
}
