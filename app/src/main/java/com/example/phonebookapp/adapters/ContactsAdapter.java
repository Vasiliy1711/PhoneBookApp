package com.example.phonebookapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebookapp.R;
import com.example.phonebookapp.data.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>
{
     public interface OnContactClickListener
    {
        void onContactClicked(int position);
    }

    private OnContactClickListener onContactClickListener;

    public void setOnContactClickListener(OnContactClickListener onContactClickListener)
    {
        this.onContactClickListener = onContactClickListener;
    }

    private List<Contact> contacts;
    private Contact contact;
    public ContactsViewHolder holder;
    private View view;


    public ContactsAdapter()
    {
        contacts = new ArrayList<>();
    }

    public void setContacts(List<Contact> contacts)
    {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public List<Contact> getContacts()
    {
        return contacts;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int position)
    {
        contact = contacts.get(position);
        contactsViewHolder.txtSurname.setText(contact.getSurname());
        contactsViewHolder.txtName.setText(contact.getName());
        contactsViewHolder.txtPhoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount()
    {
        if (contacts == null)
        {
            return 0;
        }
        return contacts.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtSurname;
        private TextView txtName;
        private TextView txtPhoneNumber;

        public ContactsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtSurname = itemView.findViewById(R.id.txtSurname);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhoneNumber = itemView.findViewById(R.id.txtPhoneNumber);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (onContactClickListener != null)
                    {
                        onContactClickListener.onContactClicked(getAdapterPosition());
                    }
                }
            });
        }
    }
}
