package lesson7.generics.containers.service;

//import lesson7.generics.containers.service.annotations.Service;

/**
 * Created by prulov on 07.06.2016.
 */
//@Service()
public class Service implements IServicable {

    private String name;

    public Service(){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){

        return getName();
    }
}
