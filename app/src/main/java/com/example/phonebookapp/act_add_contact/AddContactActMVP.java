package com.example.phonebookapp.act_add_contact;

import com.example.phonebookapp.common.BaseActMVP;

public interface AddContactActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {

    }

    interface Presenter
    {
        void onButtonAddClicked();
    }
}
