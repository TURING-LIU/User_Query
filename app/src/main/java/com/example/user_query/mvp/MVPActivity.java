package com.example.user_query.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user_query.R;
import com.example.user_query.bean.Account;
import com.example.user_query.mvc.MVCModel;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener, IMVPView {

    private TextView mTvResult;
    private EditText mEtAccount;
    private MVCModel mMvcModel;
    private MVPPresenter mMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mMvcModel = new MVCModel();
        mMvpPresenter = new MVPPresenter(this);
    }

    private void initView(){
        mTvResult = findViewById(R.id.tv_result);
        mEtAccount = findViewById(R.id.et_userName);
        findViewById(R.id.bt_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mMvpPresenter.getData(getUserInput());

    }

    @Override
    public String getUserInput() {
        return mEtAccount.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        mTvResult.setText("User Name: " + account.getName() + " | " + "Level: "
                + account.getLevel() );
    }

    @Override
    public void showFailedPage() {
        mTvResult.setText("Failed");
    }
}