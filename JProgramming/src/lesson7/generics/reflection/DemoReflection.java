package lesson7.generics.reflection;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;
import lesson7.generics.enums.Drink;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by prulov on 22.06.2016.
 */
public class DemoReflection {

    public static void main(String[] args) {

        Beer beer = new Beer(Drink.BEER, "Petrovskoye", 0.66, 100, 9.80, 17.90);
        Juice juice = new Juice(Drink.JUICE, "Nice Peaches", 1.0, 50, 12.4, 25.60);
        Vodka vodka = new Vodka(Drink.VODKA, "Utro Dobrym ne byvaet", 0.5, 25, 40.5, 90.40);
        Brendy brendy = new Brendy(Drink.BRENDY, "Slynchev Breg", 0.5, 5, 140.4, 290.00);

        Beer beerN = new Beer(Drink.BEER, "Rulovskoye", 0.66, 100, 9.80, 17.90);
        Juice juiceN = new Juice(Drink.JUICE, "Pamela", 1.0, 50, 12.4, 25.60);
        Vodka vodkaN = new Vodka(Drink.VODKA, "Dobroye Utro, Strana!", 0.5, 25, 40.5, 90.40);
        Brendy brendyN = new Brendy(Drink.BRENDY, "METAXA*****", 0.5, 5, 140.4, 290.00);

//        printClassInfo(Beer.class);
//        printClassMethods(Beer.class);
//        printClassFields(Beer.class);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("inTheMorning", juice);
        dataMap.put("forLunch", beer);
        dataMap.put("atFiveOclock", vodka);
        dataMap.put("inTheEvening", brendy);

        Map<String, Object> dataN = new HashMap<>();
        dataN.put("inTheMorning", juiceN);
        dataN.put("forLunch", beerN);
        dataN.put("atFiveOclock", vodkaN);
        dataN.put("inTheEvening", brendyN);

        List<Object> drinks = new ArrayList<>();
        drinks.add(juice);
        drinks.add(beer);
        drinks.add(vodka);
        drinks.add(brendy);

        initObject(MyOldDays.class, dataMap);
        initClass(MyNewDay.class, drinks);

        System.out.println();
        System.out.println(getType(MyNewDay.class));
        System.out.println(getParameters(getParametresAsArr(drinks)));
        // ??? System.out.println(getModifiers(3));

        System.out.println();
        System.out.println("FOR MyOldDays:");
        MyOldDays mod = new MyOldDays(brendy, vodka, beer, juice);
        setPrivates(mod, dataN);

        System.out.println();
        System.out.println("FOR NEVER:");
        Never nN = new Never(brendy, vodka, beer, juice);
        setPrivates(nN, dataN);

        System.out.println();
        System.out.println("FOR MyNewDay:");
        MyNewDay mND = new MyNewDay(juice, beer, vodka, brendy);
        setPrivates(mND, dataN);

    }


    public static void printClassInfo(Class beer){

        System.out.println("Classes info is: " + beer.getSuperclass().getSimpleName() + ", " + beer.getSimpleName());
    }

    public static void printClassMethods(Class beer) {

        System.out.println("Class constructors are: " + Arrays.toString(beer.getConstructors()));
        System.out.println("Class methods are: " + Arrays.toString(beer.getMethods()));
    }

    public static void printClassFields(Class beer) {

        System.out.println("Class fields are: " + Arrays.toString(beer.getClass().getFields()));
    }

    public static <T> void initObject(Class <T> t, Map<String, Object> map ) {

        try {
            T md = t.newInstance();
            Class cl = md.getClass();
            Field mdFields[] = t.getDeclaredFields();
            System.out.println("The characteristic of " + cl.getSimpleName() + ":" );

            for(String str : map.keySet()){
                for(Field field : mdFields){
                    if(str.equals(field.getName())){
                        field.setAccessible(true);
                        field.set(md, map.get(str));
                    }
                }
            }
            System.out.println(md.toString());
            System.out.println("There were cool days!!!");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static <E> void initClass(Class <E> eT, List<Object> list) {

        Class paramTypes[] = new Class[list.size()];
        System.out.println();
        for(int i = 0; i < paramTypes.length; i++) {
            paramTypes[i] = list.get(i).getClass();
        }

        Object paramValues[]  = list.toArray(new Object[list.size()]);

        try {
            E mD = eT.getDeclaredConstructor(paramTypes).newInstance(paramValues);
            Class cl = mD.getClass();
            System.out.println("The characteristic of " + cl.getSimpleName() + ":" );
            System.out.println(mD.toString());
            System.out.println("Cool Day!!!");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static String getModifiers(int m) {

        String modifiers = "";
        if (Modifier.isPublic(m)) modifiers += "public ";
        if (Modifier.isProtected(m)) modifiers += "protected ";
        if (Modifier.isPrivate(m)) modifiers += "private ";
        if (Modifier.isStatic(m)) modifiers += "static ";
        if (Modifier.isAbstract(m)) modifiers += "abstract ";
        return modifiers;
    }

    public static String getParameters(Class params[]) {

        String p = "";
        for (int i = 0, size = params.length; i < size; i++) {
            if (i > 0) p += ", ";
            p += getType(params[i]) + " param" + i;
        }
        return p;
    }

    public static String getType(Class clazz) {

        String type = clazz.isArray()
                ? clazz.getComponentType().getSimpleName()
                : clazz.getSimpleName();
        if (clazz.isArray()) type += "[]";
        return type;
    }

    public static <T> Class<T>[] getParametresAsArr(List<Object> list){

        Class paramTypes[] = new Class[list.size()];
        System.out.println();
        for(int i = 0; i < paramTypes.length; i++) {
            paramTypes[i] = list.get(i).getClass();
        }
        return paramTypes;
    }

    private static<T> void setPrivates(Object obj, Map<String, Object> map) {

        Class cl = obj.getClass();
        Field modFields[] = cl.getDeclaredFields();


        // just to check if method works correct
        System.out.println("OLD fields's values:");
        for(Field field : modFields){
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(obj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //for Class MyOldDays
//        for(Field field : modFields){
//            for(String str : map.keySet()){
//                if(str.equals(field.getName())){
//                    field.setAccessible(true);
//                    try {
//                        field.set(obj, map.get(str));
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

        //for class Never
        for(Field field : modFields){
            for(String str : map.keySet()){
                if(field.getType().equals(map.get(str).getClass())){
                    field.setAccessible(true);
                    try {
                        field.set(obj, map.get(str));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        System.out.println();
        System.out.println("New fields's values:");
        // just to check if method works correct
        for(Field field : modFields){
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(obj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
