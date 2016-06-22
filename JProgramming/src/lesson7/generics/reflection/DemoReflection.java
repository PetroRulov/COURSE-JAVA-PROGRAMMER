package lesson7.generics.reflection;

import lesson7.generics.domains.Beer;
import lesson7.generics.enums.Drink;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by prulov on 22.06.2016.
 */
public class DemoReflection {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        Beer beer = new Beer(Drink.BEER, "Petrovskoye", 0.66, 100, 9.80, 17.90);

        System.out.println(printClassInfo(beer) + "\n");
        System.out.println(Arrays.toString(printClassConstructors(beer))+ "\n");
        System.out.println(Arrays.toString(printClassAnnotations(beer)) + "\n");
        System.out.println(Arrays.toString(printClassMethods(beer)) + "\n");
        System.out.println(Arrays.toString(printClassFields(beer)));

    }

    public static String printClassInfo(Beer beer){

        return beer.getClass().getName();
    }

    public static Constructor<?>[] printClassConstructors(Beer beer) throws NoSuchMethodException {

        return beer.getClass().getConstructors();
    }

    public static Annotation[] printClassAnnotations(Beer beer) {

        return beer.getClass().getAnnotations();
    }

    public static Method[] printClassMethods(Beer beer) {

        return beer.getClass().getMethods();
    }

    public static Field[] printClassFields(Beer beer) {

        return beer.getClass().getFields();
    }
}
