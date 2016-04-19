package lesson4theme1auditorium;

import java.util.*;

/**
 * Created by prulov on 02.04.2016.
 */
public class Auditorium{

    List<Student> sts;

    public Auditorium() {

        this.sts = new ArrayList<>();
        initSts();
    }

    public void initSts(){

        sts.add(new Student("Aushev", "Oleksandr"));
        sts.add(new Student("Barsukova", "Iruna"));
        sts.add(new Student("Burov", "Mykola"));
        sts.add(new Student("Dyatlova", "Olena"));
        sts.add(new Student("Esipov", "Dmitriy"));
        sts.add(new Student("Fedko", "Ruslana"));
        sts.add(new Student("Fursov", "Oleksiy"));
        sts.add(new Student("Gavrilova", "Natalya"));
        sts.add(new Student("Gunko", "Leonid"));
        sts.add(new Student("Hryukin", "Pavlo"));
        sts.add(new Student("Hlopov", "Sergiy"));
        sts.add(new Student("Klykov", "Valentin"));
        sts.add(new Student("Karpenko", "Marina"));
        sts.add(new Student("Lyubko", "Vladislava"));
        sts.add(new Student("Manko", "Evgeniya"));
        sts.add(new Student("Nesterenko", "Alla"));
        sts.add(new Student("Petrenko", "Tatyana"));
        sts.add(new Student("Sulin", "Mykhaylo"));

    }


    public List<Student> getSts() {
        return new ArrayList<>(sts); // shellow-copy
    }

    public void enter(Student a1){

        sts.add(a1);
    }

    public void leave(int index, Student b2){

        sts.remove(index);
        sts.remove(b2);
    }

    public int getStudentsCount(){

        int a  = sts.size();
        return a;
    }

    public boolean isPresent(String str){

        for(Student smbdy : sts){
            if (smbdy.getSurName().equals(str)){
                return true;
            }
        }
        return false;
    }

    public boolean isStudentPresent(Student student){

        return sts.contains(student);
    }

    public void printStudentsInfo(){

        Student[] students = new Student[sts.size()];
        sts.toArray(students);
        int j = 0;
        for(Student smbdy : students){
            j++;
            System.out.print(j + ". ");
            smbdy.displayStudent();
        }
    }

    public void printSTSObjects(){

        Iterator iStud = sts.iterator();
        int i = 0;
        while(iStud.hasNext()){
            i++;
            System.out.println(i + "." + iStud.next().toString());
        }
    }

}