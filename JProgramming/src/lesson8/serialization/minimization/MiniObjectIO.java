package lesson8.serialization.minimization;

import java.io.*;

public class MiniObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File dir = new File("D:\\TEST\\ObjectMiniData");
        dir.mkdir();
        File file = new File(dir.getAbsolutePath() + File.separator  + "outputObjectMini.dat");
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
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years old");

            person = (Person) ois.readObject();
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years old");

            person = (Person) ois.readObject();
            System.out.println(person.surName + " " + person.name + ", " + person.age + " years old");
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

    static class Person implements Externalizable {

        private String surName;
        private String name;
        private int age;

        public Person(){}

        public Person(String surName, String name, int age) {
            this.surName = surName;
            this.name = name;
            this.age = age;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(age);
            out.writeInt(surName.getBytes().length);
            out.write(surName.getBytes());
//            out.writeInt(name.getBytes().length);
//            out.write(name.getBytes());
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.age = in.readInt();

            int length = in.readInt();
            byte buffer[] = new byte[length];

            in.read(buffer);
            this.surName = new String(buffer);
            //this.name = new String(buffer);

        }
    }
}

