package com.example.phonebookapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactsDatabase extends RoomDatabase
{
    private static ContactsDatabase contactsDatabase;
    private static final String DB_NAME = "phone_book_app.db";
    public static final Object LOCK = new Object();

    public static ContactsDatabase getInstance(Context context)
    {
        synchronized (LOCK)
        {
            if (contactsDatabase == null)
            {
                contactsDatabase = Room.databaseBuilder(context, ContactsDatabase.class, DB_NAME)
                        .allowMainThreadQueries()
                        .build();

            }
        }
        return contactsDatabase;
    }

    public abstract ContactsDao contactsDao();
}
