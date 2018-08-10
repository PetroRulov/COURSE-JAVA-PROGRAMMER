package binarytrees;

public class Data {

    private int id;
    private String data;

    public Data(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data1 = (Data) o;

        if (getId() != data1.getId()) return false;
        return getData().equals(data1.getData());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getData().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Data{ id= " + id + ", data='" + data+ "}";
    }
}
