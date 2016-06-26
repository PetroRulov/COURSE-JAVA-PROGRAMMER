package lesson7.generics.containers.service;

/**
 * Created by prulov on 26.06.2016.
 */
public class CheckAnno {

    public static void main(String[] args) {

        inspectService(Service.class);



    }

    public static void inspectService(Class<?> service){

        System.out.println(service.isAnnotation()); // is this class annotation-class or not
        System.out.println(service.getDeclaredAnnotations());

    }
}
