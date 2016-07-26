package com.alcoshop.database.mysqldatabase;

/**
 * Created by prulov on 23.07.2016.
 */
public class MySQL_Clients {

    private long id_client;
    private String surName;
    private String name;
    private String dateOfBirth;
    private String sex;
    private String eMail;

    public MySQL_Clients(){}

    public MySQL_Clients(int id_client, String surName, String name, String dateOfBirth, String sex, String eMail){
        this.id_client = id_client;
        this.surName = surName;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.eMail = eMail;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
