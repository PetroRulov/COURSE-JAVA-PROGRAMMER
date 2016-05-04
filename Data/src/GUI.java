import domain.Data;
import interfaces.BLI;

/**
 * Created by prulov on 25.04.2016.
 */
public class GUI {

    private BLI dProvider;

    public void buttonClick(){

        for(Data i : dProvider.getData()){
            System.err.println(i.toString());
        }
    }

    public void setBL(BLI dProvider){

        this.dProvider = dProvider;
    }
}
