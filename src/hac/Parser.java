package hac;

import java.io.IOException;

/**
 * Interface for parsing a document
 */
public interface Parser {
     /**
      * Abstract method of parsing a document
      * @throws IOException when an error with the output file occurs.
      */
     void parse() throws IOException;
}
