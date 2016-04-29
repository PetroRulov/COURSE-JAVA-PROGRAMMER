package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 22.03.2016.
 */
public class Client {

    private String surName;
    private String name;
    private int age;
    private String sex;
    private String eMail;

    public Client(){}

    // for GUI
    public Client(String surName, String name){

        this.surName = surName;
        this.name = name;
    }

    public Client(String surName, String name, int age, String sex, String eMail){

        this.surName = surName;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.eMail = eMail;
    }

    public int getAge() {
        return age;
    }

    public String geteMail() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getSurName() {
        return surName;
    }

    public void clientInfoShow(){

        System.out.printf("%-15s%-12s%-10s%-10s%-10s%n", "|"+getSurName(), "|"+getName(), "|"+getAge() + " years", "|"+getSex(), "|"+geteMail());
    }

    @Override
    public String toString(){

        return getSurName() + " " + getName();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Client){
            Client guest = (Client) obj;
            return (surName != null && surName.equals(guest.getSurName()) && name.equals(guest.getName()));
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}


