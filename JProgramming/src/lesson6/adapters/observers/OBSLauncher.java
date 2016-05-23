package lesson6.adapters.observers;

/**
 * Created by prulov on 23.05.2016.
 */
public class OBSLauncher {

    public static void main(String[] args){

        SSDept ssd = new SSDept();
        new ObsGUI(ssd);
    }
}
