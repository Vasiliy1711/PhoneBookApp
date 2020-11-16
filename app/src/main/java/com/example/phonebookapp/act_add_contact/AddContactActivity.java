package com.example.phonebookapp.act_add_contact;

import android.content.Intent;
import android.os.Bundle;

import com.example.phonebookapp.act_main.MainActivity;
import com.example.phonebookapp.common.BaseActivity;
import com.example.phonebookapp.data.Contact;


public class AddContactActivity extends BaseActivity implements AddContactActMVP.Presenter
{
    private AddContactActMVP.MVPView mvpView;
    private Contact contact;

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
        contact = new Contact(mvpView.getSurname(), mvpView.getName(), mvpView.getPhoneNumber());
        contactsDatabase.contactsDao().insertContact(contact);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}