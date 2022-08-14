package hac;

import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Abstract class for basic decorator implementation. Using the design pattern Decorator.
 */
public abstract class Decorator implements Scraper {

    /** The basic scraper that collects html data */
    protected Scraper scraper;

    /** The html document that will be scraped */
    Document doc;
    /**
     * Constructor that receives the basic scraper and the document.
     * @param scraper Basic scraper that collects html data
     * @param doc The document which holds the html data
     */
    public Decorator(Scraper scraper, Document doc) {
        this.scraper = scraper;
        this.doc = doc;
    }

    /**
     * The method which the decorator writes the scraper collected data to an output file.
     * @param fileWriter The output file writing into
     * @throws IOException When occurs error with the output file
     */
    @Override
    public void write(FileWriter fileWriter) throws IOException {
        this.scraper.write(fileWriter);
    }
}
