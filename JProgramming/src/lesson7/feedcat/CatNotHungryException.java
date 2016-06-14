package lesson7.feedcat;

public class CatNotHungryException extends RuntimeException {

    public CatNotHungryException(String message) {
        super(message);
    }
}
