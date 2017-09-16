package com.idogs.rxbusdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.idogs.rxbusdemo.rxbus.RxBus;
import com.idogs.rxbusdemo.rxbus.TestEvent;

/**
 * Created by idogs on 2017/9/16 0016.
 */

public class NextActivity extends Activity {
    EditText mEtNext;
    Button mBtnReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mEtNext=findViewById(R.id.et_next);
        mBtnReturn=findViewById(R.id.btn_return);
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxBus.getInstance().send(new TestEvent(mEtNext.getText().toString()));
                finish();
            }
        });
    }




    public static void newInstance(Context context){
        context.startActivity(new Intent(context,NextActivity.class));
    }
}
