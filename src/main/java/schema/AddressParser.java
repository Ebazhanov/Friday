package schema;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import static helpers.IndexCount.findNumberInString;

public class AddressParser {

    private final static Gson GSON = new Gson();

    /**
     * @return exact index of element base on conditions
     */
    private static int findElementInString(String input) {
        if (input.contains("No")) {
            return input.indexOf("No");
        } else if (input.contains(",")) {
            return input.indexOf(",") + 1;
        } else if (Character.isDigit(input.charAt(0))) {
            return input.indexOf(" ") + 1;
        } else {
            return findNumberInString(input);
        }
    }

    public String selectParseMethod(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return parseWhenNumbersIsFirst(input);
        } else if (input.contains(",") | input.contains("No")) {
            return parseWhenNumbersIsLast(input);
        } else {
            return parseWhenNumbersIsLast(input);
        }
    }

    /**
     * @return json if housenumber located at the END
     */
    private String parseWhenNumbersIsLast(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(0, firstNumberIndex - 1);
        final String houseNumber = input.substring(firstNumberIndex).trim();
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    /**
     * @return json if housenumber located at the BEGINING
     */
    private String parseWhenNumbersIsFirst(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(firstNumberIndex).trim();
        final String houseNumber = input.substring(0, firstNumberIndex - 1);
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

}
