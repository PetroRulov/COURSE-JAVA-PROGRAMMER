package domain;

/**
 * Created by prulov on 22.03.2016.
 */
public class Client {

    private int id_client;
    private String surName;
    private String name;
    private String dateOfBirth;
    private String sex;
    private String eMail;

    public Client(){}

    public Client(int id_client, String surName, String name, String dateOfBirth, String sex, String eMail){

        this.id_client = id_client;
        this.surName = surName;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.eMail = eMail;
    }

    public int getId_client() {
        return id_client;
    }

    public String geteMail() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getSurName() {
        return surName;
    }

    public void clientInfoShow(){

        System.out.printf("%-10s%-15s%-12s%-15s%-10s%-10s%n", "|   "+getId_client(), "|"+getSurName(), "|"+getName(), "|"+getDateOfBirth(), "|"+getSex(), "|"+geteMail());
    }

    @Override
    public String toString(){

        return getId_client() + " " + getSurName() + " " + getName();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Client){
            Client guest = (Client) obj;
            return (surName != null && surName.equals(guest.getSurName()) && name.equals(guest.getName()) &&
                    dateOfBirth.equals(guest.getDateOfBirth()) && sex.equals(guest.getSex()) && eMail.equals(guest.geteMail()));
        }
        return false;
    }

}


