package hac;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for parsing html documents.
 */
public class HTMLParser implements Parser {
    /**
     * Holds the html document.
     */
    private Document doc;
    /**
     * A string of options representing html tags to parse.
     */
    private String options;
    /**
     * File name to write the output to.
     */
    private String fileName;

    /**
     * Constructor receives the url, the html tag elements and the output file name.
     * @param url Url of the html page to parse.
     * @param options Html tag elements to parse.
     * @param fileName writing the output to.
     * @throws IOException when connecting to the url isn't successful.
     */
    public HTMLParser(String url, String options, String fileName) throws IOException {
        this.options = options;
        this.fileName = fileName;
        this.doc = Jsoup.connect(url).get();
    }
    /**
     * Parsing according to html document and html tags received in the constructor.
     * Writing the parsed result to an output file.
     * @throws IOException when an error with the output file occurs.
     */
    @Override
    public void parse() throws IOException {
        FileWriter fileWriter = new FileWriter(this.fileName);
        Scraper decorator = new ConcreteScraper();
        // iterate through the options requested and chain the decorators one on top of each other
        for(int i=1; i< options.length(); i++)
        {
            switch (options.charAt(i)) {
                case 'a' -> decorator = new LinkDecorator(decorator, this.doc);
                case 'h' -> decorator = new HeaderDecorator(decorator, this.doc);
                case 'i' -> decorator = new ImageDecorator(decorator, this.doc);
            }
        }
        // sequentially call all the `write` functions of the chained decorators, and close the file when finished.
        try {
            decorator.write(fileWriter);
        }
        catch(IOException e)
        {
            throw e;
        }
        finally {
            fileWriter.close();
        }
    }
}