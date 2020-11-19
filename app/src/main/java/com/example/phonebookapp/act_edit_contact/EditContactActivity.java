package com.example.phonebookapp.act_edit_contact;

import android.content.Intent;
import android.os.Bundle;

import com.example.phonebookapp.R;
import com.example.phonebookapp.act_main.MainActivity;
import com.example.phonebookapp.common.BaseActivity;
import com.example.phonebookapp.data.Contact;
import com.example.phonebookapp.data.ContactsDatabase;

public class EditContactActivity extends BaseActivity implements EditContactActMVP.Presenter
{

    private EditContactActMVP.MVPView mvpView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new EditContactActMVPView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        Intent intent = getIntent();
        if (intent != null)
        {
            Contact contact = (Contact) intent.getSerializableExtra("contact");
            mvpView.setContact(contact);
        }
    }

    @Override
    public void editContact(Contact contact)
    {
        contactsDatabase.contactsDao().updateContact(contact);
        Intent intent = new Intent(EditContactActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void deleteContact(Contact contact)
    {
        contactsDatabase.contactsDao().deleteContact(contact);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}