package util;

import bl.Shop;
import domain.waters.Product;

import java.util.ArrayList;
import java.util.List;

public class Service  {

    private Shop shop;
    private List<Product> orderItems;


    public Service(Shop shop){

        this.shop = shop;
        orderItems = new ArrayList<>();
    }

    public void printWaters() {

        System.out.println();
        System.out.println("-----------------------------" + "\"COCK TAIL\" WAREHOUSE" + "------------------------------|");
        System.out.println("------------------------------------------------------------------------------|");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%n", "|#", "| Type", "| Name", "| Tare", "| Volume", "| Price", "| Quantity |");
        System.out.println("------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < shop.getIdbI().getWaters().size(); i++) {
            if (shop.getIdbI().getWaters().get(i) != null) {
                j++;
                System.out.print(j);
                shop.getIdbI().getWaters().get(i).waterInfoShow();
            }
        }
        System.out.println("------------------------------------------------------------------------------|");
        System.out.println("--------------------------------------------------------- AT ALL: " + quantCounterList() + " items -|");
        System.out.println("------------------------------------------------------------------------------|");

    }

    private int quantCounterList(){

        int x = 0;
        for (int i = 0; i < shop.getIdbI().getWaters().size(); i++) {
            if (shop.getIdbI().getWaters().get(i) != null) {
                x += shop.getIdbI().getWaters().get(i).getQuant();
            }
        }
        return x;
    }

    public void addOrderItems(Product product){
        orderItems.add(product);
    }

    public void removeLastItem(){
        if(orderItems.size()>=2){
            orderItems.remove(orderItems.size() - 1);
        }else{
            orderItems.clear();
        }
    }

    public List<Product> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    public void clearOrderItems() {
        orderItems.clear();
    }

}
