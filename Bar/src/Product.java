import java.util.Arrays;

public class Product {

    private String name;
    private Ingredient[] ingrid;
    private float income;

    public Product(String name, Ingredient...ingrid){
        this.name = name;
        this.ingrid = ingrid;
        this.income = setIncome();
    }

    private float setIncome() {

        float income = 0.0f;
        for (Ingredient s : ingrid){
            income += s.getPrice();
        }
        return income;
    }

    public float getIncome() {
        return income;
    }

    public Ingredient[] getIngrid() {
        return ingrid;
    }

    public String getName() {
        return name;
    }

    public void productInfoShow(){

        System.out.printf("%-1s%-45s%-65s%-10s%-15s%n", " ", "|"+getName(), "|" + prodIngrsShow(), "| EUR " + getIncome(), " |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    public String prodIngrsShow(){

        String result = "";
        for (Ingredient s : ingrid){
            result += s.ingridientShow() + ", ";
        }
        return result;


    }
}

