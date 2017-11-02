package sjx.bawei.com.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.Shop;
/**
 * dell 孙劲雄
 * 2017/10/14
 * 11:19
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.MyHolder> {

    private List<Shop.DataBean> shops;
    private Context context;
    private MyItemClickListener listener;


    public Myadapter(List<Shop.DataBean> shops, Context context) {
        this.shops = shops;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);


       final MyHolder myHolder=new MyHolder(view);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = myHolder.getAdapterPosition();

                listener.onItemClick(v,position);
            }
        });


        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.textView.setText(shops.get(position).getTitle());


        String images = shops.get(position).getImages();

        String[] split = images.split("!");

        Picasso.with(context).load(split[0]).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return shops.size();

    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
       public MyHolder(View itemView) {
           super(itemView);

           imageView= (ImageView) itemView.findViewById(R.id.ima);

           textView= (TextView) itemView.findViewById(R.id.text);

       }
   }


    public void setListener(MyItemClickListener listener) {

        this.listener = listener;
    }


    public interface MyItemClickListener {

         void onItemClick(View view,int postion);
    }
}
