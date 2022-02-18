package com.example.user_query.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user_query.R;
import com.example.user_query.bean.Account;
import com.example.user_query.callBack.MCallBack;

import java.util.Random;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvResult;
    private EditText mEtAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView(){
        mTvResult = findViewById(R.id.tv_result);
        mEtAccount = findViewById(R.id.et_userName);
        findViewById(R.id.bt_getAccount).setOnClickListener(this);
    }

    public void onClick(View v){
        String userInput= getUserInput();
        getAccountData(userInput, new MCallBack() {
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

    private void getAccountData(String accountName, MCallBack callBack){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess){
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callBack.onSuccess(account);
        }else{
            callBack.onFailed();
        }
    }

}