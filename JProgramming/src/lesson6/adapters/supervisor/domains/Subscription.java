package lesson6.adapters.supervisor.domains;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 23.05.2016.
 */
public class Subscription {

    private Subscriber sbs;
    private Media m;

    public Subscription(){}

    public Subscription(Subscriber sbs, Media m){

        this.sbs = sbs;
        this.m = m;
    }

    public Media getM() {return m;}

    public Subscriber getSbs() {
        return sbs;
    }

    public void subScriptionInfoShow() {

        System.out.printf("%-26s%-35s%-10s%n", "| "+getSbs().getSsName(),
                "| "+getM().getPmType()+ " " + getM().getPmName(), "| "+getM().getValue(), "|");

    }

    public String subScriptInfo() {

        return getSbs().getSsName() + "| "+getM().getPmType()+ " " + getM().getPmName() + "| "+getM().getValue() + "|";

    }

}
