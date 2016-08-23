package studychecktest.ifmethodrealization;

/**
 * Created by prulov on 21.08.2016.
 */
public class Dicker {

    private String name;
    private String color;

    public Dicker(){}

    public Dicker(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dicker{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
