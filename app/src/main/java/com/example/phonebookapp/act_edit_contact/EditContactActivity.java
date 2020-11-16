package com.example.phonebookapp.act_edit_contact;

import android.os.Bundle;

import com.example.phonebookapp.R;
import com.example.phonebookapp.common.BaseActivity;
import com.example.phonebookapp.data.ContactsDatabase;

public class EditContactActivity extends BaseActivity implements EditContactActMVP.Presenter
{

    private EditContactActMVP.MVPView mvpView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
    }
}