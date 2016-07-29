package lesson8.serialization.objectio;


import java.io.*;
import java.util.List;

public class ObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File dir = new File("D:\\TEST\\ObjectIO");
        dir.mkdir();
        File file = new File(dir.getAbsolutePath() + File.separator  + "outputObject.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToFile(file);
        readFromFile(file);

    }

    private static void readFromFile (File file) throws IOException, ClassNotFoundException {

        try(
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        ){
            Person person = (Person) ois.readObject();
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years");

            person = (Person) ois.readObject();
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years");

            person = (Person) ois.readObject();
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years");
        }
    }

    private static void writeToFile(File file) throws IOException {

        try(
                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        ){
            out.writeObject(new Person("Rulov", "Petro", 38));
            out.writeObject(new Person("Borkeyev", "Sergiy", 39));
            out.writeObject(new Person("Bashkirov", "Vladimir", 38));
        }
    }

    static class Person implements Serializable {

        private static final long serialVersionUID = 0;
        
        private String surName;
        private transient String name;
        private int age;

        private transient List<Integer> integers;

        public Person(){}

        public Person(String surName, String name, int age) {
            this.surName = surName;
            this.name = name;
            this.age = age;
        }
    }
}
