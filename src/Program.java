import files.DirectoryCreator;
import parser.LinksCreator;
import utils.GlobalFlags;

import java.util.List;

/**
 * Created by Antoha on 5/7/2017.
 */
public class Program {

    private final String address;
    private final List<String> linksList;
    private final String dirName;

    public Program() {
        address = askAddress();
        linksList = createLinksList();
        dirName = prepareDirectories();
    }

    public void startProgram() {
//        prepareDirectories();
        downloadLJ();
        createPDF();
    }

    private String askAddress() {
        AddressAsker asker = new AddressAsker();
        return asker.askAddress();
    }

    private List<String> createLinksList() {
        LinksCreator linksCreator = new LinksCreator(address);
        return linksCreator.createLinks();
    }

    private String prepareDirectories() {
        if (GlobalFlags.URL_NOT_FOUND) {
            return null;
        }
        DirectoryCreator dirsCreator = new DirectoryCreator(address);
        return dirsCreator.createDirs();
    }

    private void downloadLJ() {
        Downloader downloader = new Downloader();
        downloader.download(linksList, dirName);
    }

    private void createPDF() {

    }

}
