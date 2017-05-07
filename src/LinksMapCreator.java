import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.Y;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antoha on 5/7/2017.
 */
public class LinksMapCreator {

    public Map<PostingDate, LJAddress> createMap(LJAddress address) {
        Map<PostingDate, LJAddress> map = new HashMap<>();
        try {
            Document doc = Jsoup.connect(address.toString()).get();
            String title = doc.title();
            Y.log("The title is " + title);
        } catch (IOException e) {
            Y.log(e.toString());
        }
        return map;
    }

}
