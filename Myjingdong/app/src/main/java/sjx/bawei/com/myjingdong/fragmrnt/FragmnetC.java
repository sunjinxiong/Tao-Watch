package sjx.bawei.com.myjingdong.fragmrnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sjx.bawei.com.myjingdong.R;

/**
 * dell 孙劲雄
 * 2017/10/17
 * 19:17
 */

public class FragmnetC extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState) {

        View view=View.inflate(getActivity(),R.layout.fragmentc,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
