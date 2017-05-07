import java.util.Map;

/**
 * Created by Antoha on 5/7/2017.
 */
public class Program {

    private final String address;
    private final Map<String, String> linksMap;

    public Program() {
        address = askAddress();
        linksMap = createLinksMap();
    }

    public void startProgram() {
        prepareDirectories();
        downloadLJ();
        createPDF();
    }

    private String askAddress() {
        AddressAsker asker = new AddressAsker();
        return asker.askAddress();
    }

    private Map<String, String> createLinksMap() {
        LinksMapCreator mapCreator = new LinksMapCreator(address);
        return mapCreator.createMap();
    }

    private void prepareDirectories() {

    }

    private void downloadLJ() {

    }

    private void createPDF() {

    }

}
