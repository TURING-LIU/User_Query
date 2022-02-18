package com.example.user_query.callBack;

import com.example.user_query.bean.Account;

public interface MCallBack {
    void onSuccess(Account account);

    void onFailed();
}

