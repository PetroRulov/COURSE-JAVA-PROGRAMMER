package lesson7.generics.containers.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 05.06.2016.
 */
public class ServiceRepository<T extends Service> {

    private List<T> serviceData;

    public ServiceRepository(){

        serviceData = new ArrayList<>();
    }

    public List<T> getServiceData() {

        return new ArrayList<>(serviceData);
    }

    public void setServiceData(List<T> serviceData) {

        this.serviceData = serviceData;
    }
}
