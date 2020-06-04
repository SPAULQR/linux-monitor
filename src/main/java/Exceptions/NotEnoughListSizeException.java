package Exceptions;

public class NotEnoughListSizeException extends Exception {
    public NotEnoughListSizeException(int requiredSize) {
        System.err.printf("Required list size must be at least %d\n", requiredSize);
    }
}
