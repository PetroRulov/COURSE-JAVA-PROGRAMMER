package domain;

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
}


