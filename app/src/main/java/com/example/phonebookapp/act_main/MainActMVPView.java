package com.example.phonebookapp.act_main;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebookapp.R;
import com.example.phonebookapp.adapters.ContactsAdapter;
import com.example.phonebookapp.common.BaseActMVPView;
import com.example.phonebookapp.data.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActMVPView extends BaseActMVPView implements MainActMVP.MVPView
{
    private View rootView;
    private MainActMVP.Presenter presenter;
    private LayoutInflater inflater;
    private RecyclerView recyclerViewContacts;
    private ContactsAdapter adapter;
    private FloatingActionButton floatingActionButtonAddContact;

    public MainActMVPView(LayoutInflater inflater)
    {
        this.inflater = inflater;
        rootView = inflater.inflate(R.layout.activity_main, null, false);
        recyclerViewContacts = rootView.findViewById(R.id.recyclerViewContacts);
        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new ContactsAdapter();
        recyclerViewContacts.setAdapter(adapter);
        adapter.setOnContactClickListener(new ContactsAdapter.OnContactClickListener()
        {
            @Override
            public void onContactClicked(int position)
            {
                contacts = adapter.getContacts();
                contact = contacts.get(position);
                presenter.onContactItemClicked(contact);
            }
        });
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

    @Override
    public void showContacts(List<Contact> contacts)
    {
        adapter.setContacts(contacts);
    }
}
