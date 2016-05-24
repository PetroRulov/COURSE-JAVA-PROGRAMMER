package lesson6.adapters.observers.domains;

/**
 * Created by prulov on 23.05.2016.
 */
public class Subscription {

    private Subscriber sbs;
    private PrintMedia pm;

    public Subscription(){}

    public Subscription(Subscriber sbs, PrintMedia pm){

        this.sbs = sbs;
        this.pm = pm;
    }

    public void sendTheMessage(Subscriber sbs, PrintMedia pm ){

        System.out.println("To the e-mail: " + this.sbs.geteMail() + " has been delivered the next message: ");
        System.out.println(this.pm.setMessage());

    }

    public PrintMedia getPm() {
        return pm;
    }

    public Subscriber getSbs() {
        return sbs;
    }

    public void subScriptionInfoShow() {

        System.out.printf("%-26s%-35s%-10s%n", "| "+getSbs().getSsName(),
                "| "+getPm().getPmType()+ " " + getPm().getPmName(), "| "+getPm().getValue(), "|");

    }

}
