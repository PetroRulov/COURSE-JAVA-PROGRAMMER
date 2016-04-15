
public class Menu {

    Bar bar;

    public Menu(){
        this.bar = new Bar();
    }

    public Bar getBar() {
        return bar;
    }

    public void runBar(){

        // adding new Product
//        System.out.println("At all " + bar.getProdsTitle() + " items in the List of products."); // 24([23])
//        System.out.print("The last product is:");
//        bar.getProducts()[bar.getProdsTitle()-1].productInfoShow();
//        System.out.println();
//        bar.addNewIngredient();
//    	System.out.println();
//    	bar.addNewIngredient();
//    	System.out.println();
//    	bar.addNewProduct();
        // two just added ingredients should already be in new product;
//        bar.barMenuShow();

        bar.printIngrs();
        bar.changeIngredientPrice();
        bar.changIgredientName();
        bar.printIngrs();

    }
}


