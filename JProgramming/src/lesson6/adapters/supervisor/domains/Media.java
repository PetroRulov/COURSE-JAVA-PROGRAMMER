package lesson6.adapters.supervisor.domains;

/**
 * Created by prulov on 24.05.2016.
 */
public class Media {

    private String pmType;
    private String pmName;
    private String quant;
    private double value;
    private String message;

    public Media(String pmType, String pmName, String quant, double value){

        this.pmType = pmType;
        this.pmName = pmName;
        this.quant = quant;
        this.value = value;
        this.message = setMessage();
    }

    public String getPmName() {
        return pmName;
    }

    public String getPmType() {
        return pmType;
    }

    public String getQuant() {
        return quant;
    }

    public double getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String setMessage(){

        return "Your subscription for " + getPmType() + " " + "\"" + getPmName() + "\"" + " has been successfully framed. " +
                "Expect for the latest issue on " + getQuant() + ".";
    }

    @Override
    public String toString(){

        return getPmType() + " \"" + getPmName() + "\", " + "€" + getValue() + " for 12 months";
    }
}

