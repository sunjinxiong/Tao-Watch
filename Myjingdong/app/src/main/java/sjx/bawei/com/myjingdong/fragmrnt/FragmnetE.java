package sjx.bawei.com.myjingdong.fragmrnt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.activity.DeluActivity;
import sjx.bawei.com.myjingdong.activity.XiugaiActivity;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:17
 */

public class FragmnetE extends Fragment implements View.OnClickListener {

    private ImageView imageView;
    private TextView delu,tuichu;
    private SharedPreferences sp;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        android.view.View view= android.view.View.inflate(getActivity(), R.layout.fragmente,null);

        imageView= (ImageView) view.findViewById(R.id.imageView);

        tuichu= (TextView) view.findViewById(R.id.tuichu);

        delu= (TextView) view.findViewById(R.id.delu);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


       sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);

        boolean name = sp.getBoolean("name", false);
        final int uid = sp.getInt("uid",0);

        final String username = sp.getString("username", "");

        if (name) {


            imageView.setImageResource(R.drawable.jsbundles_jdreactnewproduct_images_user_header);

            delu.setText(username);

            tuichu.setVisibility(View.VISIBLE);

            tuichu.setOnClickListener(this);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), XiugaiActivity.class);

                    intent.putExtra("name",username);
                    intent.putExtra("uid",uid);

                    startActivity(intent);
                }
            });

        } else {


            tuichu.setVisibility(View.GONE);

            imageView.setOnClickListener(this);

            delu.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tuichu:

                imageView.setImageResource(R.drawable.aa4);

                delu.setText("登录/注册");

                tuichu.setVisibility(View.GONE);

                SharedPreferences.Editor edit = sp.edit();

                edit.putBoolean("name",false);

                edit.commit();

                break;

            case R.id.delu:


                Intent intent=new Intent(getActivity(), DeluActivity.class);

                startActivity(intent);

                break;
                case R.id.imageView:


                    Intent intent2=new Intent(getActivity(), DeluActivity.class);

                    startActivity(intent2);


                    break;
        }


    }
}
