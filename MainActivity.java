package com.example.yixianglin.testdexclassloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dexLoad();

    }

    private void dexLoad() {
        DexClassManage.Builder builder = new DexClassManage.Builder(this);
        DexClassManage dexManage;
        builder.setDexName("classes2.dex");  // .dex 文件名
        builder.setClassName("com.alipay.security.mobile.module.crypto.SecurityUtils");   // 类名
        builder.setMethod("a", true, String.class,String.class);   //方法名，是否为静态方法，参数类型...
        builder.setArgs("12345678","12345678");    //参数...
        dexManage = builder.create();
        String v0_1 = (String) dexManage.invoke();
        Log.e("biu", "======>> " + v0_1);
    }
}
