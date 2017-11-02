package sjx.bawei.com.myjingdong.fragmrnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.activity.SousuoActivity;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:16
 */

public class FragmnetA extends Fragment implements View.OnClickListener {

        private ImageView dianji;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.fragmenta,null);

        dianji= (ImageView) view.findViewById(R.id.dianji);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        dianji.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.dianji:

                Intent intent=new Intent(getActivity(),SousuoActivity.class);

                startActivity(intent);

                break;


        }

    }
}
