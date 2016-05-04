package domain;

/**
 * Created by prulov on 25.04.2016.
 */
public class Data {

    private String data;

    public Data() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString(){

        return getData();
    }
}
