package lesson6.adapters;

public class AdapterPatternDemo {

    public static void main(String[] args){

        // Var 1 adaptation through inclusion (through Object)
        Target target1 = new AdapterByObject();
        System.out.println(target1.newRequst());

        // Var 2: adaptation through inheritance (through Class)
        Target target2 = new AdapterByClass();
        System.out.println(target2.newRequst());


    }


}
