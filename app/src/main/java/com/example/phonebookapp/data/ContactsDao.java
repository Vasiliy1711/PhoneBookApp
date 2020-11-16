package com.example.phonebookapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao
{
    @Query("SELECT * FROM contacts")
    List<Contact> getAllContacts();

    @Insert
    void insertContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("DELETE FROM contacts")
    void deleteAllContacts();
}
