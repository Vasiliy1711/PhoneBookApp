package com.example.phonebookapp.act_add_contact;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phonebookapp.R;

public class AddContactActMVPView implements AddContactActMVP.MVPView
{
    private View rootView;
    private AddContactActMVP.Presenter presenter;
    private LayoutInflater inflater;
    private EditText editTextAddSurname;
    private EditText editTextAddName;
    private EditText editTextAddPhoneNumber;
    private Button buttonAddContact;

    public AddContactActMVPView(LayoutInflater inflater)
    {
        this.inflater = inflater;
        rootView = inflater.inflate(R.layout.activity_add_contact, null, false);
        editTextAddSurname = rootView.findViewById(R.id.editTextAddSurname);
        editTextAddName = rootView.findViewById(R.id.editTextAddName);
        editTextAddPhoneNumber = rootView.findViewById(R.id.editTextAddPhoneNumber);
        buttonAddContact = rootView.findViewById(R.id.buttonAddContact);
        buttonAddContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.onButtonAddClicked();
            }
        });

    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(AddContactActMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }
}
