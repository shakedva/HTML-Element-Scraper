package hac;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * The main class of the program
 */
public class Main {
    /**
     * Main function of the program. Receives data through the command line and parse the requested options from the url
     * received.
     * @param args Command line arguments. Needs to be in the order -'options' 'url' 'output file name'
     * options can contain the following characters: 'a' - print the list of links, attribute href, 'i' - print the list of
     * images, attribute src, 'h' - print the list of h1 headers
     */
    public static void main(String[] args) {
        try {
            new ArgumentsValidator(args); // validate all the command line arguments
            Parser htmlParser = new HTMLParser(
                    args[ArgumentsValidator.URL_ARG],
                    args[ArgumentsValidator.OPTIONS_ARG],
                    args[ArgumentsValidator.OUTPUT_FILE_ARG]);
            // parse the html sent
            htmlParser.parse();
        }
        catch (MalformedURLException malformedURLException) // syntax error in the url
        {
            System.err.println("bad url");
        }
        catch (InvalidCommandException e) // command line arguments are invalid
        {
            System.err.println(e.getMessage());
        }
        catch (IOException e) // input/output exception
        {
            System.err.println("error");
        }
    }
}
