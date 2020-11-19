package com.example.phonebookapp.act_edit_contact;

import com.example.phonebookapp.common.BaseActMVP;
import com.example.phonebookapp.data.Contact;

public interface EditContactActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {
        void setContact(Contact contact);
    }

    interface Presenter
    {
        void editContact(Contact contact);

        void deleteContact(Contact contact);
    }
}
