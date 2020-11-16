package com.example.phonebookapp.data;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "contacts")
public class Contact implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String surname;
    private String name;
    private String phoneNumber;


    public Contact(int id, String surname, String name, String phoneNumber)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Ignore
    public Contact(String surname, String name, String phoneNumber)
    {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
