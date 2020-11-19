package com.example.phonebookapp.act_add_contact;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phonebookapp.R;
import com.example.phonebookapp.common.BaseActMVPView;
import com.example.phonebookapp.data.Contact;

public class AddContactActMVPView extends BaseActMVPView implements AddContactActMVP.MVPView
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
        editTextAddSurname = rootView.findViewById(R.id.editTextEditSurname);
        editTextAddName = rootView.findViewById(R.id.editTextEditName);
        editTextAddPhoneNumber = rootView.findViewById(R.id.editTextEditPhoneNumber);
        buttonAddContact = rootView.findViewById(R.id.buttonSaveContact);
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

    public String getSurname()
    {
            String surname = editTextAddSurname.getText().toString().trim();
            return surname;
    }

    public String getName()
    {
            String name = editTextAddName.getText().toString().trim();
            return name;
    }

    public String getPhoneNumber()
    {
        String phoneNumber = editTextAddPhoneNumber.getText().toString().trim();
        return phoneNumber;
    }

    @Override
    public Contact getContact()
    {
        String surname = getSurname();
        String name = getName();
        String phoneNumber = getPhoneNumber();
        Log.e("AddContactActMVPView", "" + surname + name + phoneNumber);
        if (!surname.isEmpty() && !name.isEmpty() && !phoneNumber.isEmpty())
        {
            Contact contact = new Contact(surname, name, phoneNumber);
            return contact;
        } else
        {
            Toast.makeText(rootView.getContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
