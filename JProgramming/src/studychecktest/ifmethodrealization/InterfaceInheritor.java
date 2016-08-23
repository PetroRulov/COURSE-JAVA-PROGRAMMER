package studychecktest.ifmethodrealization;

/**
 * Created by prulov on 21.08.2016.
 */

public class InterfaceInheritor /*extends Flyable*/ implements Flyable {

    private String name;
    private String color;
    private int quantity;

    public InterfaceInheritor(String name, String color, int quantity) {
        this.name = name;
        this.color = color;
        this.quantity = quantity;
    }

    @Override
    public void pushCommits() {

    }

    @Override
    public Object getReturn() {
        return null;
    }

    public Dicker autoTransormattion(){
        return new Dicker(this.getName(), this.getColor());
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
