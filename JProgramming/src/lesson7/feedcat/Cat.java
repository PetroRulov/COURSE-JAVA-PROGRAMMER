package lesson7.feedcat;

public class Cat {

    private String name;
    private double weight;
    private boolean isHungry = true;

    public Cat(){}

    public boolean isHungry() {
        return isHungry;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
