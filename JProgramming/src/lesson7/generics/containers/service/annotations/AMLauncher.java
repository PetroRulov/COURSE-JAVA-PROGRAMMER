package lesson7.generics.containers.service.annotations;

import lesson7.generics.containers.service.ApplicationManager;
import lesson7.generics.containers.service.Service;

/**
 * Created by prulov on 26.06.2016.
 */
public class AMLauncher {

    public static void main(String[] args) {


        ApplicationManager ap = new ApplicationManager();
        ap.startClassMarkedByAnno(Service.class);
    }
}
