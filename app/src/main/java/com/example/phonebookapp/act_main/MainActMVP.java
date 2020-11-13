package com.example.phonebookapp.act_main;

import com.example.phonebookapp.common.BaseActMVP;

public interface MainActMVP
{
    interface MVPView extends BaseActMVP<Presenter>
    {

    }

    interface Presenter
    {
        void onButtonAddContactClicked();
    }
}
