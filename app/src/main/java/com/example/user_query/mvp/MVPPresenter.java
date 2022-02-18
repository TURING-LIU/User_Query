package com.example.user_query.mvp;

import com.example.user_query.bean.Account;
import com.example.user_query.callBack.MCallBack;

public class MVPPresenter {
    private IMVPView mView;
    private MVPModel mModel;

    public MVPPresenter(IMVPView mView) {
        this.mView = mView;
        mModel = new MVPModel();
    }

    public void getData(String accountName){
        mModel.getAccountData(accountName, new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                mView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mView.showFailedPage();
            }
        });
    }
}
