package hac;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  Class that inherit from the Decorator class, decorator for the image elements.
 */
public class ImageDecorator extends Decorator{
    /**
     * Constructor for the image elements decorator.
     * @param scraper the wrapped scraper used by the Decorator design pattern to chain method calls.
     * @param doc the html document that will be scraped.
     */
    public ImageDecorator(Scraper scraper, Document doc)
    {
        super(scraper,doc);
    }

    /**
     * Implementation of the method which the decorator writes the scraper collected data to an output file.
     * @param fileWriter The output file writing into
     * @throws IOException When occurs error with the output file
     */
    @Override
    public void write(FileWriter fileWriter) throws IOException {
        super.write(fileWriter);
        // get all the elements for <img> tag and iterate through them and write the data to an output file.
        Elements elements = this.doc.getElementsByTag("img");
        for (Element element : elements)
        {
            fileWriter.write(element.attr("abs:src"));
            fileWriter.write(System.getProperty( "line.separator"));
        }
        fileWriter.write(System.getProperty( "line.separator"));
    }
}