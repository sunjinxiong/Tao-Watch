package sjx.bawei.com.myjingdong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener, sjx.bawei.com.myjingdong.view.View {

    private EditText zhuceeditname;
    private EditText zhuceeditpwd;
    private Button zhuce;
    private Presentes p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zhuce);

        this.zhuce = (Button) findViewById(R.id.zhuce_);

        this.zhuceeditpwd = (EditText) findViewById(R.id.zhuce_edit_pwd);

        this.zhuceeditname = (EditText) findViewById(R.id.zhuce_edit_name);

        zhuce.setOnClickListener(this);

         p= new PresentesImp(this,null);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.zhuce_:
                boolean mobile = isMobile(zhuceeditname.getText().toString().trim());

                if(mobile){
                    if (zhuceeditpwd.getText().toString().length()>=6){

                        p.Zhuce(zhuceeditname.getText().toString().trim(),zhuceeditpwd.getText().toString().trim());
                    }else {

                        Toast.makeText(ZhuceActivity.this,"密码不能小于6位",Toast.LENGTH_SHORT).show();

                    }

                }else {

                    Toast.makeText(ZhuceActivity.this,"手机格式不正确",Toast.LENGTH_SHORT).show();
                }


                break;
        }

    }


    @Override
    public void Cg(Zhu zhu) {

        if (zhu.getCode().equals("0")){

            Toast.makeText(ZhuceActivity.this,zhu.getMsg(),Toast.LENGTH_SHORT).show();

            finish();

        }else {

            Toast.makeText(ZhuceActivity.this,zhu.getMsg(),Toast.LENGTH_SHORT).show();

        }


    }

    public static boolean isMobile(String number) {

        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {

            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }

    @Override
    public void Data(Fenlei fenlei) {

    }

    @Override
    public void Data2(Fenlei2 fenlei2) {

    }


    @Override
    public void Sb(De de) {

    }

    @Override
    public void Shopdata(Shop shop) {

    }

}
