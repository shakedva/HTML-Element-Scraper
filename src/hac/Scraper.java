package hac;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Interface of a scrapper
 */
public interface Scraper {
    /**
     * Abstract method of a scrapper writing to a file.
     * @param fileWriter The output file writing into
     * @throws IOException when an error with the output file occurs.
     */
    void write(FileWriter fileWriter) throws IOException;
}
