package lesson4theme3;

public class Person {

    private String name;
    private int age;
    private long salary;
    private Address address;

    public Person(){}

    public Person(String name, int age, long salary, Address address){

        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode(){

        Person person = new Person();
        int result = 2;
        result *= 37 + name.hashCode();
        result *= 37 + ((Integer) age).hashCode();
        result *= 37 + ((Long) salary).hashCode();
        if(address != null){result *= 37 + address.hashCode();}

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person p = (Person) obj;
            return (name != null && name.equals(p.getName()) && age == (p.getAge()) &&
                    salary == (p.getSalary()) && address.equals(p.getAddress()));
        }
        return false;
    }
}
