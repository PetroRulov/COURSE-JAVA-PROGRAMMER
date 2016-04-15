public class Book {

    private Genre genre;
    private String auth;
    private String name;
    private double lindx;

    public Book(){}

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLIndx() {
        return lindx;
    }

    public void setLIndx(double lindx) {
        this.lindx = lindx;
    }

    public void bookInfoShow() {

        System.out.println("Genre: " + getGenre() + "; Author: " + getAuth() + "; Book name: " + "\"" + getName() +
                "\"; Catalogue # " + getLIndx() + ".");
    }

}
