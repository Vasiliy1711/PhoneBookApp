package com.example.phonebookapp.act_edit_contact;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phonebookapp.R;
import com.example.phonebookapp.common.BaseActMVPView;
import com.example.phonebookapp.data.Contact;

public class EditContactActMVPView extends BaseActMVPView implements EditContactActMVP.MVPView
{
    private View rootView;
    private LayoutInflater inflater;
    private EditContactActMVP.Presenter presenter;
    private EditText editTextEditSurname;
    private EditText editTextEditName;
    private EditText editTextEditPhoneNumber;
    private Button buttonSaveContact;
    private Button buttonDeleteContact;

    public EditContactActMVPView(LayoutInflater inflater)
    {
        this.inflater = inflater;
        rootView = inflater.inflate(R.layout.activity_edit_contact, null, false);
        editTextEditSurname = rootView.findViewById(R.id.editTextEditSurname);
        editTextEditName = rootView.findViewById(R.id.editTextEditName);
        editTextEditPhoneNumber = rootView.findViewById(R.id.editTextEditPhoneNumber);
        buttonSaveContact = rootView.findViewById(R.id.buttonSaveContact);
        buttonSaveContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String surname = editTextEditSurname.getText().toString().trim();
                String name = editTextEditName.getText().toString().trim();
                String phoneNumber = editTextEditPhoneNumber.getText().toString().trim();
                Contact updatedContact = new Contact(contact.getId(), surname, name, phoneNumber);
                presenter.editContact(updatedContact);
            }
        });
        buttonDeleteContact = rootView.findViewById(R.id.buttonDeleteContact);
        buttonDeleteContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                presenter.deleteContact(contact);
            }
        });
    }

    @Override
    public void setContact(Contact contact)
    {
        this.contact = contact;
        editTextEditSurname.setText(contact.getSurname());
        editTextEditName.setText(contact.getName());
        editTextEditPhoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(EditContactActMVP.Presenter presenter)
    {
        this.presenter = presenter;
    }
}
