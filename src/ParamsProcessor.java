import utils.GlobalFlags;
import utils.Z;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Antoha on 5/13/2017.
 */
public class ParamsProcessor {

    public void processParams(String[] args) {
        List<String> paramsList = Arrays.asList(args);
        for (String s : paramsList) {
            if (s.equalsIgnoreCase(Z.MULTIPLE_FILES)) {
                GlobalFlags.MULTIPLE_FILES = true;
            }
        }
    }

}
