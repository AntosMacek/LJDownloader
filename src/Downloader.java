import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import parser.DocumentGetter;
import utils.Y;
import utils.Z;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Created by Antoha on 5/13/2017.
 */
public class Downloader {

    public void download(List<String> links, String dirName) {
        DocumentGetter docGetter = new DocumentGetter();
        Document document;
        for (int i = 0; i < links.size(); i++) {
            String filePath = System.getProperty("user.dir") + Z.FILE_SEPARATOR + dirName + Z.FILE_SEPARATOR + i + ".txt";
            String link = links.get(i);
            document = docGetter.getDocument(link);
            Element content = document.select("div.entry-content").first(); // specific for kungurov? For rest div.asset-content. Needs more research.
            writeToFile(formattedContent(content.text()), filePath);
        }
    }

    private void writeToFile(String content, String filePath) {
        List<String> lines = Collections.singletonList(content);
        Path file = Paths.get(filePath);
        try {
            if (file != null) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
                Files.write(file, lines, Charset.forName("UTF-8"));
                Y.debug("Writing to file " + filePath);
            } else {
                Y.log("The file not found!");
            }
        } catch (IOException e) {
            Y.log(e);
        }
    }

    private String formattedContent(String text) {
        return text.replace(". ", ".\n");
    }

}
