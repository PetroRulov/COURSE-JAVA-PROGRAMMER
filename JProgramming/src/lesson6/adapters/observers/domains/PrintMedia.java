package lesson6.adapters.observers.domains;

/**
 * Created by prulov on 23.05.2016.
 */
public class PrintMedia {

    private String pmType;
    private String pmName;
    private String quant;
    private double value;
    private String message;

    public PrintMedia(){}

    public PrintMedia(String pmType, String pmName, String quant, double value){

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
                "Expect the latets issue on " + getQuant() + ".";
    }

    @Override
    public String toString(){

        return getPmType() + " \"" + getPmName() + "\", " + "€" + getValue() + " for 12 months";
    }
}
