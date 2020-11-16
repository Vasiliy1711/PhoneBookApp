package com.example.phonebookapp.act_add_contact;

import com.example.phonebookapp.common.BaseActMVP;
import com.example.phonebookapp.data.Contact;

public interface AddContactActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {
        String getSurname();
        String getName();
        String getPhoneNumber();
    }

    interface Presenter
    {
        void onButtonAddClicked();
    }
}
