package com.padc.yaepyaypar.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mkt on 9/16/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    protected void showProgressDialog(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }

        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if(mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }
}
