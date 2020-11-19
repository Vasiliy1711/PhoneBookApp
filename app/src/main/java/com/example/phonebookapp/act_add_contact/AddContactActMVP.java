package com.example.phonebookapp.act_add_contact;

import com.example.phonebookapp.common.BaseActMVP;
import com.example.phonebookapp.data.Contact;

public interface AddContactActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {
        Contact getContact();
    }

    interface Presenter
    {
        void onButtonAddClicked();
    }
}
