package com.example.phonebookapp.common;

import android.view.View;

public interface BaseActMVP<PresenterType>
{
    View getRootView();
    void registerPresenter(PresenterType presenter);
}
