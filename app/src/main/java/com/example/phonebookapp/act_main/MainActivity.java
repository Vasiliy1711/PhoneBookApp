package com.example.phonebookapp.act_main;

import android.content.Intent;
import android.os.Bundle;
import com.example.phonebookapp.act_add_contact.AddContactActivity;
import com.example.phonebookapp.act_edit_contact.EditContactActivity;
import com.example.phonebookapp.common.BaseActivity;
import com.example.phonebookapp.data.Contact;
import com.example.phonebookapp.data.ContactsDatabase;

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
        contactsDatabase = ContactsDatabase.getInstance(this.getApplicationContext());
        contacts = contactsDatabase.contactsDao().getAllContacts();
        mvpView.showContacts(contacts);
    }

    @Override
    public void onButtonAddContactClicked()
    {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    @Override
    public void onContactItemClicked(Contact contact)
    {
        Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }

}