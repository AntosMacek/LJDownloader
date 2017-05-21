package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.Y;

import java.io.IOException;

/**
 * Created by Antoha on 5/7/2017.
 */
public class DocumentGetter {

    public Document getDocument(String address) {
        Document doc = null;
        try {
            doc = Jsoup.connect(address).get();
//            Y.debug("The title is " + doc.title());
        } catch (IOException e) {
            Y.debug(e);
        }
        return doc;
    }

}
