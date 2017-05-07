import utils.Z;
import utils.Y;

import java.util.Scanner;

/**
 * Created by Antoha on 5/7/2017.
 */
public class AddressAsker {

    public AddressAsker() {}

    public String askAddress() {
        return printStartingMessage();
    }

    private String printStartingMessage() {
        Y.log(Z.STARTING_MESSAGE);
        return readUserInput();
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return checkInputContent(input);
    }

    private String checkInputContent(String input) {
        if (input.toLowerCase().equals(Z.EXIT)) {
            Y.log(Z.EXITING);
            System.exit(0);
        }
        if (!input.contains(Z.LJ_POSTFIX)) {
            input = input + Z.LJ_POSTFIX;
        }
        if (!input.contains(Z.URL_PREFIX)) {
            input = Z.URL_PREFIX + input;
        }
        Y.log(Z.PARSING_ADDRESS + input);
        return input;
    }

}
