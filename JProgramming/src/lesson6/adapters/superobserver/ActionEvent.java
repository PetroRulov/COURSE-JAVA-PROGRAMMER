package lesson6.adapters.superobserver;

/**
 * Created by prulov on 24.05.2016.
 */
public class ActionEvent {

    private String name;

    public ActionEvent(String name){

        if(name == null){
            name = this.toString();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
