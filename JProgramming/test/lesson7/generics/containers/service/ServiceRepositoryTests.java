package lesson7.generics.containers.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by prulov on 14.06.2016.
 */
@RunWith(JUnit4.class)
public class ServiceRepositoryTests {

    private ServiceRepository sR;


    @Before
    public void init(){

        sR = new ServiceRepository();
    }

    @Test
    public void checkSRHasEmptyList(){

        assertTrue("Default List should be empty.", sR.getServiceData().isEmpty());
    }

    @Test
    public void checkSRSetNewList(){

        List<? extends Service> serviceData = new ArrayList<>();
        sR.setServiceData(serviceData);
        assertEquals(serviceData, sR.getServiceData());
    }
}
