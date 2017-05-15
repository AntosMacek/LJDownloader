package files;

import utils.Y;
import utils.Z;

import java.io.File;

/**
 * Created by Antoha on 5/13/2017.
 */
public class DirectoryCreator {

    private final String mainDirName;

    public DirectoryCreator(String name) {
        mainDirName = name.replace(Z.URL_PREFIX, Z.EMPTY_STR).replace(Z.LJ_POSTFIX, Z.EMPTY_STR);
    }

    public String createDirs() {
        File journalDir = new File(mainDirName);
        try {
            if (!journalDir.mkdir()) {
                Y.debug(Z.FAIL_DIR_CREATE + mainDirName);
            }
        } catch (Exception e) {
            Y.log(e);
        }
        return mainDirName;
    }

}
