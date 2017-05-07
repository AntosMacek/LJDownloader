import java.util.Map;

/**
 * Created by Antoha on 5/7/2017.
 */
public class Program {

    private final LJAddress address;
    private final Map<PostingDate, LJAddress> linksMap;

    public Program() {
        address = askAddress();
        linksMap = createLinksMap();
    }

    public void startProgram() {
        prepareDirectories();
        downloadLJ();
        createPDF();
    }

    private LJAddress askAddress() {
        AddressAsker asker = new AddressAsker();
        return asker.askAddress();
    }

    private Map<PostingDate, LJAddress> createLinksMap() {
        LinksMapCreator mapCreator = new LinksMapCreator();
        return mapCreator.createMap(address);
    }

    private void prepareDirectories() {

    }

    private void downloadLJ() {

    }

    private void createPDF() {

    }

}
