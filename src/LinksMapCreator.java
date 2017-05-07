import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utils.Y;
import utils.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antoha on 5/7/2017.
 */
public class LinksMapCreator {

    //    private final Document initialDocument;
    private final String address;
    private final Map<String, String> linksMap;
    private final Map<String, String> yearsMap;
    private final DocumentGetter documentGetter;

    public LinksMapCreator(String address) {
        documentGetter = new DocumentGetter();
        this.address = address;
//        initialDocument = documentGetter.getDocument(address);
        linksMap = new HashMap<>();
        yearsMap = new HashMap<>();
    }

    public Map<String, String> createMap() {
        linksMap.put(Z.INITIAL_ADDRESS, address);
        linksMap.put(Z.ARCHIVE_ADDRESS, address + Z.ARCHIVE_POSTFIX);
        populateMapWithYears();
        Y.log(linksMap);
        Y.log(yearsMap);
        return linksMap;
    }

    private void populateMapWithYears() {
        Document archiveDoc = documentGetter.getDocument(linksMap.get(Z.ARCHIVE_ADDRESS));
        if (archiveDoc == null) {
            return;
        }
        for (Element e : archiveDoc.body().children()) {
            String element = e.html();
            if (element.contains(Z.ARCHIVE_DOM)) {
//                Y.log(element);
                extractYearsLinks(element);
                break;
            }
        }
    }

    private void extractYearsLinks(String element) {
        BufferedReader br = new BufferedReader(new StringReader(element));
        String line;
        String searchCriteria = Z.YEARS_LIST_DOM_PREFIX + address;
        boolean isYearsListIteratedNow = false;
        try {
            while ((line = br.readLine()) != null) {
                if (line.contains(searchCriteria)) {
                    isYearsListIteratedNow = true;
                    getYear(line, false);
//                    Y.log(line);
                } else if (line.contains(Z.LAST_OF_LIST)) {
                    getYear(line, true);
//                    Y.log(line);
                } else if (isYearsListIteratedNow && line.contains(Z.END_OF_LIST)) { // If years list is passed and we meet </ul> tag, we can break
                    break;
                }
            }
        } catch (IOException e) {
            Y.log(e.toString());
        }
    }

    private void getYear(String line, boolean isLastYear) {
        String[] tokens = line.split(Z.GREATER_SIGN);
        String year;
        if (!isLastYear) {
            year = tokens[2].split(Z.LESS_SIGN)[0];
        } else {
            year = tokens[1].split(Z.LESS_SIGN)[0];
        }
        yearsMap.put(year, address + year);
//        for (String s : tokens)
//            Y.log(s);
    }

}
