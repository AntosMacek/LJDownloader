import java.util.List;

/**
 * Created by Antoha on 5/7/2017.
 */
public class Program {

    private final String address;
    private final List<String> linksList;

    public Program() {
        address = askAddress();
        linksList = createLinksList();
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

    private List<String> createLinksList() {
        LinksCreator linksCreator = new LinksCreator(address);
        return linksCreator.createLinks();
    }

    private void prepareDirectories() {

    }

    private void downloadLJ() {

    }

    private void createPDF() {

    }

}
