package lesson7.generics.reflection.fortests;

import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public interface InitServiceClassInterface {

    public <E> void initObject(Class <E> eT, Map<String, Object> map );

    public <E> Class initClass(Class <E> eT, List<Object> list);

    public <E> void setPrivates(Object obj, Map<String, Object> map);
}


