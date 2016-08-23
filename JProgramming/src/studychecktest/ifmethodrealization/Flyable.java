package studychecktest.ifmethodrealization;

/**
 * Created by prulov on 21.08.2016.
 */
public interface Flyable {

    // method may have body only with keyword "default"
    default void methodWithRealization(){
        System.out.println("DEFAULT REALIZATION!");
    }

    default Dicker transformation(InterfaceInheritor ii){
        return new Dicker(ii.getName(), ii.getColor());
    }

    static void civilizate(){
        System.out.println("Civilizated!!!");
    };

    void pushCommits();

    Object getReturn();
}
