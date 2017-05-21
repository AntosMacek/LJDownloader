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
    public static final String SLASH = "/";
    public static final String REPLACED_SLASH = "\\/";
    public static final String STOP = ".";
    public static final String REPLACED_STOP = "\\.";
    public static final String FILE_SEPARATOR = "\\";

    // LJ templates
    public static final String LJ_POSTFIX = ".livejournal.com/";
    public static final String URL_PREFIX = "http://";
    public static final String ARCHIVE_POSTFIX = "calendar";
    public static final String ARCHIVE_DOM = "<div class=\"entry-title\">\n" +
            "       Archive\n" +
            "      </div> ";
    public static final String YEARS_LIST_DOM_PREFIX = "<li><a href=\"";
    public static final String ARTICLE_TEMPLATE = "[0-9]*\\.html";

    // DOM tags
    public static final String END_OF_LIST = "</ul>";
    public static final String LAST_OF_LIST = "<li class=\"active\">";
    public static final String TAG_LINK_PURE = "a[href]";
    public static final String HREF_ATTRIBUTE_KEY = "href";

    // Console messages
    public static final String STARTING_MESSAGE = NEW_LINE + "Enter Live Journal to download: ";
    public static final String PARSING_ADDRESS = NEW_LINE + "Parsing address: ";
    public static final String EXIT = "exit";
    public static final String EXITING = "Exiting...";
    public static final String CANT_CONNECT = "Couldn't connect to ";
    public static final String FAIL_DIR_CREATE = "Failed to create directory for LJ ";

    // Links Map Keys
    public static final String INITIAL_ADDRESS = "Initial_address";
    public static final String ARCHIVE_ADDRESS = "Archive_address";

    // Date constants
    public static final int MIN_MONTH = 1;
    public static final int MIN_YEAR = 2007;
    public static final int MAX_MONTH = 12;

    // Program parameters
    public static final String MULTIPLE_FILES = "-m";

    // Other
    public static final String UTF8 = "UTF-8";

}
