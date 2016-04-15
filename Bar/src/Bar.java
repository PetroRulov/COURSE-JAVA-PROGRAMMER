
import java.util.Scanner;

public class Bar {

    private Ingredient[] ingrs;
    Product[] prods;

    public Bar() {

        this.ingrs = new Ingredient[50];
        initIngredientsList();
        this.prods = new Product[100];
        initProductsList();
    }

    public Product[] getProducts() {
        return prods;
    }

    public Ingredient[] getIngredients() {
        return ingrs;
    }

    private void initProductsList() {

        prods[0] = new Product("Water cool, 200 ml", ingrs[5], ingrs[5]);
        prods[1] = new Product("Espresso w/o sugar, 100 ml", ingrs[5], ingrs[0]);
        prods[2] = new Product("Espresso with sugar, 100 ml", ingrs[5], ingrs[0], ingrs[2]);
        prods[3] = new Product("Coffee \"Americano\" w/o sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[0],
                ingrs[1], ingrs[1]);
        prods[4] = new Product("Coffee \"Americano\" with sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[0],
                ingrs[1], ingrs[1], ingrs[2], ingrs[2]);
        prods[5] = new Product("Black coffee with milk w/o sugar, 150 ml", ingrs[5], ingrs[0], ingrs[1]);
        prods[6] = new Product("Black coffee with milk & sugar, 150 ml", ingrs[5], ingrs[0], ingrs[1], ingrs[2]);
        prods[7] = new Product("Cappuccino w/o sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[3], ingrs[1]);
        prods[8] = new Product("Cappuccino with sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[3], ingrs[1],
                ingrs[2]);
        prods[9] = new Product("Cappuccino with cinnamon w/o sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[3],
                ingrs[1], ingrs[11]);
        prods[10] = new Product("Cappuccino with cinnamon & sugar, 300 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[3],
                ingrs[1], ingrs[11], ingrs[2]);
        prods[11] = new Product("Mocaccino, 400 ml", ingrs[5], ingrs[5], ingrs[0], ingrs[0], ingrs[3], ingrs[3],
                ingrs[4], ingrs[4]);
        prods[12] = new Product("Black tea w/o sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6]);
        prods[13] = new Product("Black tea with lemon w/o sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6], ingrs[12]);
        prods[14] = new Product("Black tea with sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6], ingrs[2]);
        prods[15] = new Product("Black tea with lemon & sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6], ingrs[12],
                ingrs[2]);
        prods[16] = new Product("Black tea with mint w/o sugar, 200 ml", ingrs[5], ingrs[5], ingrs[10]);
        prods[17] = new Product("Black tea with mint & sugar, 200 ml", ingrs[5], ingrs[5], ingrs[10], ingrs[2]);
        prods[18] = new Product("Black tea with bergamote, 200 ml", ingrs[5], ingrs[5], ingrs[8]);
        prods[19] = new Product("Green tea, 200 ml", ingrs[5], ingrs[5], ingrs[7]);
        prods[20] = new Product("Green tea with lemon, 200 ml", ingrs[5], ingrs[5], ingrs[7], ingrs[12]);
        prods[21] = new Product("Green tea with ginger, 200 ml", ingrs[5], ingrs[5], ingrs[7], ingrs[9]);
        prods[22] = new Product("Gr/tea with lemon & ginger w/o sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6], ingrs[12],
                ingrs[9]);
        prods[23] = new Product("Gr/tea with lemon, ginger & sugar, 200 ml", ingrs[5], ingrs[5], ingrs[6], ingrs[12],
                ingrs[9], ingrs[2]);

    }

    private void initIngredientsList() {

        ingrs[0] = new Ingredient("Coffee", 3.0f);
        ingrs[1] = new Ingredient("Milk", 1.0f);
        ingrs[2] = new Ingredient("Sugar", 0.75f);
        ingrs[3] = new Ingredient("Chokolate", 3.5f);
        ingrs[4] = new Ingredient("Cream", 3.0f);
        ingrs[5] = new Ingredient("Water", 0.5f);
        ingrs[6] = new Ingredient("BlackTea", 1.5f);
        ingrs[7] = new Ingredient("GreenTea", 4.0f);
        ingrs[8] = new Ingredient("BergamoteTea", 3.5f);
        ingrs[9] = new Ingredient("Ginger", 3.5f);
        ingrs[10] = new Ingredient("Mint", 1.5f);
        ingrs[11] = new Ingredient("Cinnamon", 1.75f);
        ingrs[12] = new Ingredient("Lemon", 0.5f);

    }

    public void printIngrs() {

        int j = 0;
        System.out.printf("%-1s%-20s%-35s%n", "#  ", "| Name ", "| Price  " + " |");
        System.out.println("______________________________________");
        for (Ingredient i : ingrs) {
            j++;
            System.out.print(j + ".");
            if (i != null) {
                i.ingridientInfoShow();
            }
            if (j == getIngrsTitle()) {
                break;
            }
        }
        System.out.println("______________________________________");
    }

    private int getIngrsTitle() {
        int indexTitle = 0;
        for (int i = 0; i < ingrs.length; i++) {
            if (ingrs[i] == null) {
                indexTitle = i;
                break;
            }
        }
        return indexTitle;
    }

    public void barMenuShow() {

        System.out.println();
        System.out.println(
                "-----------------------------------------------         CAFE \"CORSAIRE\" MENU               -------------------------------------|");
        System.out.println(
                "__________________________________________________________________________________________________________________________________");
        System.out.printf("%-1s%-45s%-65s%-10s%-15s%n", "# ", "|      Name of product", "|      Ingredients",
                "|  Value ", " |");
        System.out.println(
                "__________________________________________________________________________________________________________________________________");

        int j = 0;
        for (int i = 0; i < prods.length; i++) {
            if (prods[i] != null) {
                j++;
                System.out.print(j);
                prods[i].productInfoShow();
            }
        }
        System.out.println(
                "_________________________________________________________________________________________________________________________________|");
        System.out.println();
    }

    public int getProdsTitle() {
        int indexTitle = 0;
        for (int i = 0; i < prods.length; i++) {
            if (prods[i] == null) {
                indexTitle = i;
                break;
            }
        }
        return indexTitle;
    }

    public void addNewProduct() {

        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input the name of new product:");
        name = scan.nextLine();
        prods[getProdsTitle()] = new Product(name, mixNewProduct());
    }

    private Ingredient[] mixNewProduct() {

        return new Ingredient[] { ingrs[getIngrsTitle() - 1], ingrs[getIngrsTitle() - 2], ingrs[5], ingrs[5], ingrs[0], ingrs[1], ingrs[2] };
    }

    public void addNewIngredient(){

        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input the name of new ingredient:");
        name = scan.nextLine();
        float price = setNewPrice();
        if (price > 0){
            ingrs[getIngrsTitle()] = new Ingredient(name, price);
        }
    }

    //  additional method for method addNewIngredient();
    private float setNewPrice(){

        float price = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, input the price of new ingredient:");
        if (scan.hasNextFloat()) {
            price = scan.nextFloat();
            return Math.abs(price);
        } else
            System.out.println("!!!Invalid request!");
        System.out.println("Please, insert the correct price and try again!");
        return price;

    }

    public void changeIngredientPrice() {/*-(price $0 not applicable)-*/

        float price;
        int title = getIngrsTitle();
        int i = inputIngrName();
        if (i >= title || i < 0) {
            return;
        } else
            price = getNewPrice();
        if (price == -1 || price == 0) {
            System.out.println("!Invalid request!");
            System.out.println("Price cannot be changed, insert the correct data and try again.");
            return;
        } else {
            ingrs[i].setPrice(price);
            System.out.println("Price changed successfully!");
        }
    }

    public void changIgredientName(){

        Scanner scan = new Scanner(System.in);
        String newName = "";
        int title = getIngrsTitle();
        int i = inputIngrName();
        if (i != -1) {
            System.out.println("Please, be very careful (check twice) inserting new name:");
            newName = scan.nextLine();
            ingrs[i].setName(newName);
            System.out.println("Ingredient successfully renamed to " + "\"" + newName + "\".");
        } else {
            System.out.println("Attempt to rename failed, try again, please.");
            return;
        }
    }

    // auxiliary method
    private int inputIngrName(){

        Scanner scan = new Scanner(System.in);
        String ingrName = "";
        System.out.println("Please, insert the name of ingredient:");
        ingrName = scan.nextLine();
        int index = -1;
        int i = 0;
        for (; i < ingrs.length; i++) {
            if (ingrs[i] == null) {
                continue;
            }
            if (ingrs[i].getName().equals(ingrName)) {
                index = i;
                break;
            }
        }
        if (i == ingrs.length) {
            System.out.println("!!!Position is absent. Wrong result!!!");
            System.out.println("Please, insert coorect name and try again.");
        }
        return index;
    }

    // auxiliary method
    public float getNewPrice() {

        float price;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, be very careful (check twice) inserting new price:");
        if (scan.hasNextFloat()) {
            price = scan.nextFloat();
            return Math.abs(price);
        } else {
            return -1;
        }
    }
}

