package lesson7.generics.containers.service.stubmock;

import java.util.List;

/**
 * Created by prulov on 29.06.2016.
 */
public interface StorageService {

    public <T> T stored(T object);

    public <T> T getById(Long id);

    public <T> List<T> getAll(Class clazz);
}
