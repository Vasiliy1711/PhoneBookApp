package com.example.phonebookapp.act_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.phonebookapp.R;
import com.example.phonebookapp.act_add_contact.AddContactActivity;
import com.example.phonebookapp.common.BaseActivity;

public class MainActivity extends BaseActivity implements MainActMVP.Presenter
{
    private MainActMVP.MVPView mvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new MainActMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
    }

    @Override
    public void onButtonAddContactClicked()
    {
        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
        startActivity(intent);
    }
}