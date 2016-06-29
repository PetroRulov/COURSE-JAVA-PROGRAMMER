package lesson7.generics.containers.service.stubmock;

import java.util.List;

/**
 * Created by prulov on 29.06.2016.
 */
public class DBStorageService implements StorageService {

    @Override
    public <T> T stored(T object) {
        return null;
    }

    @Override
    public <T> T getById(Long id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class clazz) {
        return null;
    }
}
