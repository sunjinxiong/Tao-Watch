package sjx.bawei.com.myjingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sjx.bawei.com.myjingdong.R;
import sjx.bawei.com.myjingdong.bean.De;
import sjx.bawei.com.myjingdong.bean.Fenlei;
import sjx.bawei.com.myjingdong.bean.Fenlei2;
import sjx.bawei.com.myjingdong.bean.Shop;
import sjx.bawei.com.myjingdong.bean.Zhu;
import sjx.bawei.com.myjingdong.presentes.Presentes;
import sjx.bawei.com.myjingdong.presentes.PresentesImp;

public class DeluActivity extends AppCompatActivity implements View.OnClickListener,sjx.bawei.com.myjingdong.view.View {

    private android.widget.Button delu;

    private android.widget.Button zhuce;

    private android.widget.EditText phone;

    private android.widget.EditText pwd;
    private Presentes p;
    private SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_delu);

        this.pwd = (EditText) findViewById(R.id.pwd);

        this.phone = (EditText) findViewById(R.id.phone);

        this.zhuce = (Button) findViewById(R.id.zhuce);

        this.delu = (Button) findViewById(R.id.delu);

        zhuce.setOnClickListener(this);
        delu.setOnClickListener(this);

        p = new PresentesImp(this,null);

        user = getSharedPreferences("user", MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

         case R.id.delu:

             boolean mobile = isMobile(phone.getText().toString().trim());

             if(mobile){
                 if (pwd.getText().toString().length()>=6){

                     p.Delu(phone.getText().toString().trim(),pwd.getText().toString().trim());

                 }else {

                     Toast.makeText(DeluActivity.this,"密码不能小于6位",Toast.LENGTH_SHORT).show();

                 }

             }else {

                 Toast.makeText(DeluActivity.this,"手机格式不正确",Toast.LENGTH_SHORT).show();
             }


             break;

         case R.id.zhuce:

             Intent intent=new Intent(DeluActivity.this,ZhuceActivity.class);

             startActivity(intent);

             break;
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
    public void Cg(Zhu zhu) {

    }

    @Override
    public void Sb(De de) {

        if (de.getCode().equals("0")){

            Toast.makeText(DeluActivity.this,de.getMsg(),Toast.LENGTH_SHORT).show();


            Intent intent=new Intent(DeluActivity.this,Main2Activity.class);

            SharedPreferences.Editor edit = user.edit();

            edit.putBoolean("name",true);

            edit.putString("username",de.getData().getUsername());

            edit.putInt("uid",de.getData().getUid());

            edit.commit();

            startActivity(intent);

            finish();

        }else {

            Toast.makeText(DeluActivity.this,de.getMsg(),Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void Shopdata(Shop shop) {

    }
}
