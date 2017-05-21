import org.jsoup.nodes.Element;
import parser.DocumentGetter;
import utils.Y;
import utils.Z;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Antoha on 5/13/2017.
 */
public class Downloader {

    private final List<String> divs = Arrays.asList("div.entry-content", "div.asset-content");  // Must try more and update this list
    private final int PERCENT_SHOWER = 20;

    public void download(List<String> links, String dirName) {
        DocumentGetter docGetter = new DocumentGetter();
//        PrintWriter writer = null;
//        String fileName = null;
//        if (!GlobalFlags.MULTIPLE_FILES) {
//            fileName = System.getProperty("user.dir") + Z.FILE_SEPARATOR + dirName + Z.FILE_SEPARATOR + dirName + ".txt";
//            try {
//                writer = new PrintWriter(fileName, Z.UTF8);
//                Y.debug("Writing to file " + fileName);
//            } catch (FileNotFoundException | UnsupportedEncodingException e) {
//                Y.debug(e);
//            }
//        }
        int linksSize = links.size();
        int percentDelimiter = linksSize / PERCENT_SHOWER;
        int percent = percentDelimiter;
        for (int i = 0; i < linksSize; i++) {
            String filePath;
            String link = links.get(i);
            Element content = getContentFromDocument(link, docGetter);
            if (content == null) {
                continue;
            }
//            if (GlobalFlags.MULTIPLE_FILES) {
                filePath = System.getProperty("user.dir") + Z.FILE_SEPARATOR + dirName + Z.FILE_SEPARATOR + (i + 1) + ".txt";
                writeToMultipleFiles(formattedContent(content.text()), filePath);
//            } else {
//                writeToOneFile(content.text(), writer);
//            }

            // TODO: write to one file
            if (i == percent) {
                percent += percentDelimiter;
                String percentCounter = String.format("%.2f", ((float) i/ (float) linksSize) * 100);
                Y.log(percentCounter + "% (" + i + "/" + linksSize + ")");
//                try {
//                    writer.close();
//                    writer = new PrintWriter(System.getProperty("user.dir") + Z.FILE_SEPARATOR + dirName + Z.FILE_SEPARATOR + dirName + percentCounter + ".txt", Z.UTF8);
//                } catch (IOException e) {
//                    Y.debug(e);
//                }
            }
        }
//        if (!GlobalFlags.MULTIPLE_FILES && writer != null) {
//            writer.close();
//        }
    }

    private void writeToMultipleFiles(String content, String filePath) {
        List<String> lines = Collections.singletonList(content);
        Path file = Paths.get(filePath);
        try {
            if (file != null) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
                Files.write(file, lines, Charset.forName(Z.UTF8));
                Y.debug("Writing to file " + filePath);
            } else {
                Y.log("The file not found!");
            }
        } catch (IOException e) {
            Y.debug(e);
        }
    }

//    private void writeToOneFile(String content, PrintWriter writer) {
////        try /*(PrintWriter writer = new PrintWriter(fileName, Z.UTF8))*/ {
//            writer.println(content);
////            Y.debug("Writing to file " + fileName);
////        } catch (IOException e) {
////            Y.log(e);
////        }
//    }

    private Element getContentFromDocument(String link, DocumentGetter docGetter) {
        Element ret = null;
        for (String div : divs) {
            ret = docGetter.getDocument(link).select(div).first();
            if (ret != null) {
                return ret;
            }
        }
        return ret;
    }

    private String formattedContent(String text) {
        return text.replace(". ", ".\n");
    }

}
