package lesson7.feedcat;

public class HouseWife {

    private String name;
    private int age;

    public HouseWife() {
    }

    public void feed(Cat[] cats){

        for(Cat c : cats){

            if(c.isHungry()){
                c.setHungry(Boolean.FALSE);
            }else{
                throw new CatNotHungryException(c.getName() + " is not hungry!");
            }
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
