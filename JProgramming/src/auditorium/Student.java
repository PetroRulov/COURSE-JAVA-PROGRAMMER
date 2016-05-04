package auditorium;

/**
 * Created by prulov on 02.04.2016.
 */
public class Student {

    private String surName;
    private String name;

    public Student(){}

    public Student(String surName, String name){

        this.surName = surName;
        this.name = name;

    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void displayStudent(){

        System.out.println(getSurName() + " " + getName());
    }

    @Override
    public String toString(){

        return getSurName() + " " + getName();
    }

    @Override
    public boolean equals(Object obj){

        if (obj instanceof Student){
            Student student = (Student) obj;
            if (this.name != null && this.surName != null &&
                    this.getSurName().equals(((Student) obj).getSurName()) && this.getName().equals(((Student) obj).getName())){
                return true;
            }
        }
        return false;
    }

}