package com.example.user_query.mvp;

import com.example.user_query.bean.Account;

public interface IMVPView {
    String getUserInput();
    void showSuccessPage(Account account);
    void showFailedPage();

}
