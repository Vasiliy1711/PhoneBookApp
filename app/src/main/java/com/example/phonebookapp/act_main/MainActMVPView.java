package com.example.phonebookapp.act_main;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebookapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActMVPView implements MainActMVP.MVPView
{
    private View rootView;
    private MainActMVP.Presenter presenter;
    private LayoutInflater inflater;
    private RecyclerView recyclerViewContacts;
    private FloatingActionButton floatingActionButtonAddContact;

    public MainActMVPView(LayoutInflater inflater)
    {
        this.inflater = inflater;
        rootView = inflater.inflate(R.layout.activity_main, null, false);
        recyclerViewContacts = rootView.findViewById(R.id.recyclerViewContacts);
        floatingActionButtonAddContact = rootView.findViewById(R.id.floatingActionButtonAddContact);
        floatingActionButtonAddContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onButtonAddContactClicked();
            }
        });
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(MainActMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }

}
