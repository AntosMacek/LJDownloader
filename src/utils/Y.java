package utils;

/**
 * Created by Antoha on 5/7/2017.
 */

/** Class with utility methods */
public class Y {

    public static void log(Object msg) {
        System.out.println(msg);
    }

    public static void debug(Object msg) {
        if (GlobalFlags.DEBUG) {
            log(msg);
        }
    }

}
