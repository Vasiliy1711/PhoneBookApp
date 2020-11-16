package com.example.phonebookapp.act_main;

import com.example.phonebookapp.common.BaseActMVP;
import com.example.phonebookapp.data.Contact;

import java.util.List;

public interface MainActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {
        void showContacts(List<Contact> contacts);
    }

    interface Presenter
    {
        void onButtonAddContactClicked();

        void onContactItemClicked(Contact contact);
    }
}
