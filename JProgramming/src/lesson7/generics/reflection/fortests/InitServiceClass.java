package lesson7.generics.reflection.fortests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public class InitServiceClass implements InitServiceClassInterface {

    public <E> void initObject(Class <E> eT, Map<String, Object> map ) {

        try {
            E md = eT.newInstance();
            Class cl = md.getClass();
            Field mdFields[] = eT.getDeclaredFields();
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

    public <E> Class initClass(Class <E> eT, List<Object> list) {

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
            return cl;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <E> void setPrivates(Object obj, Map<String, Object> map) {

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

        // METHOD'S BODY
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
