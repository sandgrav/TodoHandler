package se.verran;

public class MemoryFullException extends RuntimeException {
    public MemoryFullException(String message) {
        super(message);
    }
}
