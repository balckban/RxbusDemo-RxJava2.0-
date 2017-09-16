package com.idogs.rxbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.idogs.rxbusdemo.rxbus.RxBus;
import com.idogs.rxbusdemo.rxbus.TestEvent;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnIntent;
    private TextView mTvReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnIntent.setOnClickListener(this);
        RxBus.getInstance().toFlowable().subscribe(new Consumer<Object>() {

            @Override
            public void accept(Object o) throws Exception {
                Toast.makeText(MainActivity.this, "已收到", Toast.LENGTH_SHORT).show();
                if (((TestEvent) o).getTest() != null) {
                    mTvReceive.setText(((TestEvent) o).getTest());
                }
            }
        });

    }

    /**
     * 初始化
     */
    public void initView(){
        mBtnIntent=findViewById(R.id.btn_intent);
        mTvReceive=findViewById(R.id.tv_receive);
    }

    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.btn_intent:
                  NextActivity.newInstance(this);
                  break;
          }
    }
}
