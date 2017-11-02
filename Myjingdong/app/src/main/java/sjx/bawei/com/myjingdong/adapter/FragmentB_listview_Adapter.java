package sjx.bawei.com.myjingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.Fenlei;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 20:09
 */

public class FragmentB_listview_Adapter extends BaseAdapter {

    private Context context;
    private Fenlei fenlei;

    public FragmentB_listview_Adapter(Context context, Fenlei fenlei) {
        this.context = context;
        this.fenlei = fenlei;
    }

    @Override
    public int getCount() {
        return fenlei.getData().size();
    }

    @Override
    public Object getItem(int position) {

        return fenlei.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder viewholder;
        if(convertView==null){

            viewholder=new Viewholder();

            convertView=View.inflate(context, R.layout.fragmentb_listview_view,null);


            viewholder.textView= (TextView) convertView.findViewById(R.id.fragmentb_listview_text);

            convertView.setTag(viewholder);

        }else {

            viewholder= (Viewholder) convertView.getTag();

        }

        viewholder.textView.setText(fenlei.getData().get(position).getName());

        return convertView;
    }

    class Viewholder{

        TextView textView;


    }
}
