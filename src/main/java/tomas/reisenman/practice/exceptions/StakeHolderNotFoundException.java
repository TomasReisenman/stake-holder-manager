package tomas.reisenman.practice.exceptions;

public class StakeHolderNotFoundException extends RuntimeException {
    public StakeHolderNotFoundException(String message) {
        super(message);
    }
}
