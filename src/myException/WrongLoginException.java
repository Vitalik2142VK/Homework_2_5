package myException;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException(String message) {
        super(message);
    }
}
