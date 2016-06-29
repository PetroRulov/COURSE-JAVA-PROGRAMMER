package lesson7.generics.containers.service.stubmock;

import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public class ServiceClass {

    private StorageService storageService;

    public void storeUserData(Map<String, Object> data){

        storageService.stored(new Object());
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
