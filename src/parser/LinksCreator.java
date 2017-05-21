package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.GlobalFlags;
import utils.Y;
import utils.Z;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Antoha on 5/7/2017.
 */
public class LinksCreator {

    private enum Months {
        JANUARY("01"), FEBRUARY("02"), MARCH("03"), APRIL("04"), MAY("05"), JUNE("06"), JULY("07"), AUGUST("08"), SEPTEMBER("09"), OCTOBER("10"), NOVEMBER("11"), DECEMBER("12");

        private final String monthNumber;

        Months(String number) {
            monthNumber = number;
        }

    }

    private final String address;
    private final List<String> monthList;
    private final List<String> articleList;
    private final String articleLinkTemplate;
    private final DocumentGetter documentGetter;

    public LinksCreator(String address) {
        documentGetter = new DocumentGetter();
        this.address = address;
        articleLinkTemplate = createArticleLinkTemplate();
        monthList = new ArrayList<>();
        articleList = new ArrayList<>();
    }

    public List<String> createLinks() {
        generateMonthsLinks();
        getArticleLinks();
        Y.log("There are " + articleList.size() + " articles in " + address);
        return articleList;
    }


    private void generateMonthsLinks() {
        int maxYear = getCurrentYear();
        int currentMonth = getCurrentMonth();
        Months[] months = Months.values();
        for (int i = Z.MIN_YEAR; i <= maxYear; i++) {
            for (int j = Z.MIN_MONTH; j <= Z.MAX_MONTH; j++) {
                if (i == maxYear && j == currentMonth + 1) {
                    break;  // Don't generate links for future months.
                }
                String yearMonth = String.valueOf(i) + Z.SLASH + months[j-1].monthNumber;
                monthList.add(address + yearMonth);
            }
        }
    }

    private void getArticleLinks() {
        Document doc;
        Y.log("Getting links of articles...");
        for (String link : monthList) {
            try {
                doc = Jsoup.connect(link).get();
                Elements articleHrefs = doc.select(Z.TAG_LINK_PURE);
                Y.debug("In " + link + " there are " + articleHrefs.size() + " links.");
                String absHref;
                for (Element el : articleHrefs) {
                    absHref = el.attr(Z.HREF_ATTRIBUTE_KEY);
                    if (absHref.isEmpty()) {
                        continue;
                    }
                    if (matchArticleTemplate(absHref)) {
                        articleList.add(absHref);
                    }
                }

            } catch (IOException e) {
                Y.log(Z.CANT_CONNECT + link + Z.NEW_LINE + Z.EXITING + Z.NEW_LINE + e);
                GlobalFlags.URL_NOT_FOUND = true;
                break;
            }
        }
    }

    private boolean matchArticleTemplate(String candidate) {
        Pattern pattern = Pattern.compile(articleLinkTemplate);
        Matcher m = pattern.matcher(candidate);
        return m.find();
    }

    private String createArticleLinkTemplate() {
        String ret = address.replace(Z.SLASH, Z.REPLACED_SLASH).replace(Z.STOP, Z.REPLACED_STOP) + Z.ARTICLE_TEMPLATE;
        Y.debug("Template is " + ret);
        return ret;
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    private int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1; // MONTH is 0-based
    }

}
