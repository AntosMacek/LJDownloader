package utils;

/**
 * Created by Antoha on 5/7/2017.
 */

/** Class with constants */
public class Z {

    // Special symbols
    public static final String NEW_LINE = "\n";
    public static final String TAB = "\t";
    public static final String SPACE = " ";
    public static final String EMPTY_STR = "";
    public static final String GREATER_SIGN = ">";
    public static final String LESS_SIGN = "<";

    // LJ templates
    public static final String LJ_POSTFIX = ".livejournal.com/";
    public static final String URL_PREFIX = "http://";
    public static final String ARCHIVE_POSTFIX = "calendar";
    public static final String ARCHIVE_DOM = "<div class=\"entry-title\">\n" +
            "       Archive\n" +
            "      </div> ";
    public static final String YEARS_LIST_DOM_PREFIX = "<li><a href=\"";

    // DOM tags
    public static final String END_OF_LIST = "</ul>";
    public static final String LAST_OF_LIST = "<li class=\"active\">";

    // Console messages
    public static final String STARTING_MESSAGE = NEW_LINE + "Enter Live Journal to download: ";
    public static final String PARSING_ADDRESS = NEW_LINE + "Parsing address: ";
    public static final String EXIT = "exit";
    public static final String EXITING = "Exiting...";

    // Links Map Keys
    public static final String INITIAL_ADDRESS = "Initial_address";
    public static final String ARCHIVE_ADDRESS = "Archive_address";

}
