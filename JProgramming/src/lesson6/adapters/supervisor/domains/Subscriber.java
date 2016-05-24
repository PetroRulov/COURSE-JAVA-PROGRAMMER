package lesson6.adapters.supervisor.domains;

import java.util.Observable;

/**
 * Created by prulov on 23.05.2016.
 */
public class Subscriber {

    private String ssName;
    private String eMail;

    public Subscriber(String ssName, String eMail){

        this.ssName = ssName;
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSsName() {
        return ssName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }

}
