public class Ingredient {

    private String name;
    private float price;

    public Ingredient(){}

    public Ingredient(String name, float price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void ingridientInfoShow(){

        System.out.printf("%-1s%-20s%-35s%n", " ", "| "+getName(), "| EUR "+getPrice() + " |");
    }

    public String ingridientShow(){

        return getName();
    }
}


