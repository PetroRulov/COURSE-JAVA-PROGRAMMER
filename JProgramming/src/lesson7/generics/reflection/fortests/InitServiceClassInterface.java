package lesson7.generics.reflection.fortests;

import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public interface InitServiceClassInterface {

    public <T> void initObject(Class <T> t, Map<String, Object> map );

    public <E> void initClass(Class <E> eT, List<Object> list);
}


