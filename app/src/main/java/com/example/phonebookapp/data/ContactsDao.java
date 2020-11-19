package com.example.phonebookapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactsDao
{
    @Query("SELECT * FROM contacts")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contacts WHERE id == :contactId")
    Contact getContactById(int contactId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContact(Contact contact);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("DELETE FROM contacts")
    void deleteAllContacts();
}
