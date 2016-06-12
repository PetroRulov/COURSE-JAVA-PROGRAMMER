package lesson7.generics.containers.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 05.06.2016.
 */
public class ServDepo<IServicable> implements java.io.Serializable {

    private List<IServicable> serviceData;

    public ServDepo(){

        // do nothing
    }

    public ServDepo(List<IServicable> serviceData){

        this.serviceData = serviceData;
    }

    public List<IServicable> getServiceData() {

        return new ArrayList<>(serviceData);
    }

    public void setServiceData(List<IServicable> serviceData) {

        this.serviceData = serviceData;
    }

    public void addWater(IServicable servObj){

        serviceData.add(servObj);
    }

    public IServicable getServObjFromServiceList(int x){

        return (IServicable) getServiceData().get(x);
    }
}
