package lesson7.generics.containers.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 12.06.2016.
 */
public class DemoService {


    public static void main(String[] args) {

        Service serv = new Service();
        serv.setName("serv");
        Service service = new Service();
        service.setName("service");
        Service servak = new Service();
        servak.setName("servak");
        Service serviz = new Service();
        serviz.setName("serviz");

        List<IServicable> servoData = new ArrayList<>();

        servoData.add(serv);
        servoData.add(service);
        servoData.add(servak);

        ServDepo sd = new ServDepo(servoData);

        for(int i = 0; i < sd.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  sd.getServObjFromServiceList(i).toString());
        }

        sd.addServObj(serviz);
        sd.removeServObj(service);
        System.out.println();

        for(int i = 0; i < sd.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  sd.getServObjFromServiceList(i).toString());
        }
    }
}
