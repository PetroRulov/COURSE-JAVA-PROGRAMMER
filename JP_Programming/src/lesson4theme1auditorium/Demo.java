package lesson4theme1auditorium;

/**
 * Created by prulov on 02.04.2016.
 */
public class Demo {

    Auditorium a;

    public Demo(){
        this.a = new Auditorium();
    }

    public void startTheDay(){

        System.out.println("There are " + a.getSts().size() + " students in the auditorium now:");
        a.printSTSObjects();
        System.out.println();

        a.printStudentsInfo();
        System.out.println();

        System.out.println("Another one student came in.");
        a.enter(new Student("Ivanchenko", "Stepan"));
        System.out.println();

        a.printStudentsInfo();
        System.out.println();

        System.out.println("But two students came out.");
        a.leave(7, a.getSts().get(10)); // two student at once
        System.out.println();

        a.printSTSObjects();
        System.out.println();

        System.out.println("There are " + a.getStudentsCount() + " students in the auditorium now.");
        System.out.println();

        Student ivanov = new Student();
        ivanov.setSurName("Ivanov");
        ivanov.setName("Yuriy");
        System.out.println("Is student " + ivanov.getSurName() + " " + ivanov.getName() + " present? "
                + a.isStudentPresent(ivanov));
        System.out.println();

        System.out.println(a.getSts().get(1).getSurName() + " is present? " + a.isPresent(a.getSts().get(1).getSurName()));
        System.out.println("Ivanyushenko is present? " + a.isPresent("Ivanyushenko"));

    }
}
