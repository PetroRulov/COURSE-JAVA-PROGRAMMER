package lesson7.generics.containers.service.stubmock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by prulov on 29.06.2016.
 */
@RunWith(JUnit4.class)
public class ServiceClassTest {

    private ServiceClass serviceClass;
    private StorageServiceMock storageService;

    @Before
    public void init(){

        //storageService = new StorageServiceStub(); // if we don't need to test real methods
        storageService = new StorageServiceMock();

        serviceClass = new ServiceClass();
        serviceClass.setStorageService(storageService);
    }

    @Test
    public void testStoreUserdata(){

        serviceClass.storeUserData(new HashMap<String, Object>());
        assertTrue(storageService.getStoreCounter() == 1);
    }

    @Test
    public void anotherTestStoreUserdata(){

        serviceClass.storeUserData(new HashMap<String, Object>());
        assertTrue(storageService.getStoreCounter() != 2);
    }
}
