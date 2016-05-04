package lesson4.theme3;

/**
 * Created by prulov on 06.04.2016.
 */
public class Demo {

    public static void main(String[] args){

        Person pFir = new Person();
        Person pSec = new Person();
        Person pThr = new Person();
        Person pFour = new Person();

        pFir.setName("Ivanov Aleksey");
        pFir.setAge(28);
        pFir.setSalary(6500);
        pFir.setAddress(new Address(87534L, "Mariupol", "Stroiteley", 160, 28));

        pSec.setName("Ivanov Aleksey");
        pSec.setAge(28);
        pSec.setSalary(5400);
        pSec.setAddress(new Address(87534L, "Mariupol", "Stroiteley", 181, 28));

        pThr.setName("Ivanov Aleksey");
        pThr.setAge(28);
        pThr.setSalary(6500);
        pThr.setAddress(new Address(87534L, "Mariupol", "Stroiteley", 160, 28));

        pFour.setName("Alekseev Ivan");
        pFour.setAge(31);
        pFour.setSalary(7200);
        pFour.setAddress(new Address(87528L, "Mariupol", "Nahimova", 166, 4));

        System.out.println(pFir.hashCode());
        System.out.println(pSec.hashCode());
        System.out.println(pThr.hashCode());
        System.out.println(pFour.hashCode());
        System.out.println();

        System.out.println(pFir.equals(pSec));
        System.out.println(pSec.equals(pThr));
        System.out.println(pThr.equals(pFour));
        System.out.println(pFir.equals(pThr));

    }
}
