package lesson6.adapters;

public class AdapterByObject implements Target {

    private Adaptee adaptee;

    public AdapterByObject() {
        adaptee = new Adaptee();
    }

    @Override
    public String newRequst() {
        return adaptee.oldRequest();
    }
}
