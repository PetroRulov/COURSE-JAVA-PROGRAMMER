package lesson7.generics.containers.service;

import java.util.ArrayList;
import java.util.Comparator;
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

        if(!serviceData.isEmpty()){
            this.serviceData = serviceData;
        }else{
            this.serviceData = new ArrayList<>();
        }
    }

    public List<IServicable> getServiceData() {

        return new ArrayList<>(serviceData);
    }

    public void setServiceData(List<IServicable> serviceData) {

        this.serviceData = serviceData;
    }

    public void addServObj(IServicable servObj){

        if(serviceData!=null){
            serviceData.add(servObj);
        }else{
            serviceData = new ArrayList<>();
            serviceData.add(servObj);
        }
    }

    public void removeServObj(IServicable servObj){

        serviceData.remove(servObj);
    }

    public IServicable getServObjFromServiceList(int x){

        return (IServicable) getServiceData().get(x);
    }

    public <IServicable> void sorterZA(List<Service> servObjList){

        servObjList.sort(new NameZAComparator());
    }

    public <IServicable> void sorterAZ(List<Service> servObjList){

        servObjList.sort(new NameAZComparator());
    }

    class NameZAComparator implements Comparator<Service> {

        @Override
        public int compare(Service o1, Service o2) {
            String d1 = o1.getName();
            String d2 = o2.getName();
            int result = d1.compareToIgnoreCase(d2);
            if (result < 0) {
                return 1;
            } else if (result > 0) {
                return -1;
            }
            return 0;
        }
    }

    class NameAZComparator implements Comparator<Service> {

        @Override
        public int compare(Service o1, Service o2) {
            String d1 = o1.getName();
            String d2 = o2.getName();
            int result = d1.compareToIgnoreCase(d2);
            if (result < 0) {
                return -1;
            } else if (result > 0) {
                return 1;
            }
            return 0;
        }
    }
}
