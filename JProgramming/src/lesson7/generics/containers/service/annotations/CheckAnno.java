package lesson7.generics.containers.service.annotations;

/**
 * Created by prulov on 26.06.2016.
 */
public class CheckAnno {

    public static void main(String[] args) {

        inspectService(ServiceAnn.class);

    }

    public static void inspectService(Class<?> service){

        System.out.println(service.isAnnotation()); // is this class annotation-class or not
        System.out.println(service.getDeclaredAnnotations());

        if(service.isAnnotationPresent(ServiceAnn.class)){

            ServiceAnn ann = service.getAnnotation(ServiceAnn.class);
        }

    }
}
