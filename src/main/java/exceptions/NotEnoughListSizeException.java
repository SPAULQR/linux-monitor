package exceptions;

public class NotEnoughListSizeException extends Exception {
    public NotEnoughListSizeException(int requiredSize) {
        super("Required list size must be at least " + requiredSize);
    }
}
