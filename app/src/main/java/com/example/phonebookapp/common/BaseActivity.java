package com.example.phonebookapp.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.phonebookapp.data.Contact;
import com.example.phonebookapp.data.ContactsDatabase;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity
{
    protected ContactsDatabase contactsDatabase;
    protected List<Contact> contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        contactsDatabase = ContactsDatabase.getInstance(this.getApplicationContext());
        contacts = new ArrayList<>();
    }
}
