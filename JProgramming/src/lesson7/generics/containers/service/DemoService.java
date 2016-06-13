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
        ServDepo sDE = new ServDepo();

        for(int i = 0; i < sd.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  sd.getServObjFromServiceList(i).toString());
        }

        sd.addServObj(serviz);

        System.out.println();

        for(int i = 0; i < sd.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  sd.getServObjFromServiceList(i).toString());
        }

        sd.removeServObj(service);
        sd.sorterZA(servoData);
        System.out.println();
        System.out.println("COMPARISON BY NAME Z-A:");

        for(int i = 0; i < sd.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  sd.getServObjFromServiceList(i).toString());
        }

        sDE.addServObj(serv);
        sDE.addServObj(service);
        sDE.addServObj(serviz);
        sDE.addServObj(servak);

        List<IServicable> dataServ = sDE.getServiceData();

        sDE.sorterAZ(dataServ);
        System.out.println();
        System.out.println("EMPTY CONSTRUCTOR FOR SERVDEPO (compared by name A-Z):");

        for(int i = 0; i < sDE.getServiceData().size(); i++){

            System.out.println("ServObject " + (i + 1) + " = " +  dataServ.get(i).toString());
        }
    }
}
