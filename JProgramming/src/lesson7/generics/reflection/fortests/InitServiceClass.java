package lesson7.generics.reflection.fortests;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public class InitServiceClass implements InitServiceClassInterface {

    public <T> void initObject(Class <T> t, Map<String, Object> map ) {

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

    public <E> void initClass(Class <E> eT, List<Object> list) {

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
}
