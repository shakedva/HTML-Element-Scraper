package hac;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * This class validates the command line arguments received from the user.
 * It throws a relevant exception if the arguments are not valid.
 */
public class ArgumentsValidator {

    /**
     * Argument index of the options
     */
    static final int OPTIONS_ARG = 0;
    /**
     * Argument index of the url
     */
    static final int URL_ARG = 1;
    /**
     * Argument index of the output file  name
     */
    static final int OUTPUT_FILE_ARG = 2;
    /**
     * Number of arguments
     */
    static final int ARGS_NUM = 3;
    /**
     * All possible options
     */
    private final String POSSIBLE_OPTIONS = "aih";

    /**
     * Only html pages allowed
     */
    private final String POSSIBLE_PAGE_TYPE = "html";

    /**
     * Constructor for the class ArgumentsValidator.
     * It receives the command line arguments and throws an exception whether there was a problem with them
     *
     * @param args - the command line arguments
     * @throws InvalidCommandException - if not received the correct amount of arguments or if the options received are
     *                                 incorrect, it throws this exception
     * @throws MalformedURLException   - if the syntax of the url received is not right the exception will be thrown
     */
    public ArgumentsValidator(String[] args) throws InvalidCommandException, IOException {
        if (args.length != ARGS_NUM) // too much or not enough arguments
            throw new InvalidCommandException();

        validateOptions(args[OPTIONS_ARG]);
        URL url = new URL(args[URL_ARG]); // validates url syntax
        // check if the url holds html data
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if(!connection.getContentType().contains(POSSIBLE_PAGE_TYPE))
            throw new MalformedURLException();
    }

    /**
     * Validated the options received.
     * @param options - a string that contains the requested options from the user
     * @throws InvalidCommandException - thrown if the options requested are invalid
     */
    private void validateOptions(String options) throws InvalidCommandException {
        if (options.charAt((0)) != '-')
            throw new InvalidCommandException();
        for (int i = 1; i < options.length(); i++) {
            // check if every char in the options requested are in the possible options
            if (!POSSIBLE_OPTIONS.contains(Character.toString(options.charAt(i))))
                throw new InvalidCommandException();
        }
    }

}
