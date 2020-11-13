package com.example.phonebookapp.act_add_contact;

import android.content.Intent;
import android.os.Bundle;

import com.example.phonebookapp.act_main.MainActivity;
import com.example.phonebookapp.common.BaseActivity;

public class AddContactActivity extends BaseActivity implements AddContactActMVP.Presenter
{
    private AddContactActMVP.MVPView mvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new AddContactActMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
    }


    @Override
    public void onButtonAddClicked()
    {
        Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
        startActivity(intent);
    }
}