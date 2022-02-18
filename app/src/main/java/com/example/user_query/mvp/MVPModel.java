package com.example.user_query.mvp;

import com.example.user_query.bean.Account;
import com.example.user_query.callBack.MCallBack;

import java.util.Random;

public class MVPModel {
    public void getAccountData(String accountName, MCallBack callBack){
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
