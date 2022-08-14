package hac;

/**
 * Class that inherits from the class Exception.
 * Used in case of invalid command arguments.
 */
public class InvalidCommandException extends Exception {
    /**
     * Constructor that receives a message and throws it.
     * @param message represent the specific exception thrown
     */
    public InvalidCommandException(String message) {
        super(message);
    }

    /**
     * Default constructor. If string has not been passed, it will throw "invalid command".
     */
    public InvalidCommandException() {
        super("invalid command");
    }
}
