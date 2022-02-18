package com.example.user_query.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user_query.R;
import com.example.user_query.bean.Account;
import com.example.user_query.callBack.MCallBack;
import com.example.user_query.normal.MVCModel;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvResult;
    private EditText mEtAccount;
    private MVCModel mMvcModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mMvcModel = new MVCModel();
    }

    private void initView(){
        mTvResult = findViewById(R.id.tv_result);
        mEtAccount = findViewById(R.id.et_userName);
        findViewById(R.id.bt_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mMvcModel.getAccountData(getUserInput(), new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                showFailedPage();
            }
        });
    }


    private String getUserInput(){
        return mEtAccount.getText().toString();
    }


    private void showSuccessPage (Account account){
        mTvResult.setText("User Name: " + account.getName() + " | " + "Level: "
                + account.getLevel() );
    }


    private void showFailedPage (){
        mTvResult.setText("Failed");
    }
}