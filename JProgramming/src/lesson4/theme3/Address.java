package lesson4.theme3;

/**
 * Created by prulov on 06.04.2016.
 */
public class Address {

    private long postCode;
    private String city;
    private String street;
    private int house;
    private int flat;

    public Address(){}

    public Address(long postCode, String city, String street, int house, int flat){

        if(postCode <= 0 || house <= 0 || flat <= 0 || city == null || street == null){
            throw new IllegalStateException("Parameters shouldn't contain values of null or 0 (or less than 0)");
        }

        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public long getPostCode() {
        return postCode;
    }

    public void setPostCode(long postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public int hashCode(){

        Address adr = new Address();
        int result = 3;
        result *= 37 + (int)(postCode ^ (postCode >>> 32));
        result *= 37 + city.hashCode();
        result *= 37 + street.hashCode();
        result *= 37 + ((Integer) house).hashCode();
        result *= 37 + ((Integer) flat).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Address){
            Address adr = (Address) obj;
            return (city != null && city.equals(adr.getCity()) && street.equals(adr.getStreet()) &&
                    postCode == adr.getPostCode() && house == adr.getHouse() && flat == adr.getFlat());
        }
        return false;
    }
}

