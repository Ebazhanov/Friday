package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AddressParser {

    private final static Gson GSON = new Gson();

    /**
     * @return selected method with specific index
     */

    public String selectParseMethod(String input) {
        if (isFirstLetterIsNumber(input)) {
            return parseWhenNumbersIsFirst(input);
        } else if (input.contains(",") | input.contains("No")) {
            return parseWhenNumbersIsLast(input);
        } else {
            return parseWhenNumbersIsLast(input);
        }
    }

    private int findElementInString(String input) {
        if (input.contains("No")) {
            return input.indexOf("No");
        } else if (input.contains(",")) {
            return input.indexOf(",") + 1;
        } else if (isFirstLetterIsNumber(input)) {
            return input.indexOf(" ") + 1;
        } else {
            return findNumberInTheString(input);
        }
    }

    private boolean isFirstLetterIsNumber(String input) {
        return Character.isDigit(input.charAt(0));
    }

    private int findNumberInTheString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                return index;
            }
        }
        return -1;
    }

    private String parseStringToJson(String streetName, String houseNumber) {
        final JsonObject jsonAddress = new JsonObject();
        jsonAddress.addProperty("street", streetName);
        jsonAddress.addProperty("housenumber", houseNumber);
        return GSON.toJson(jsonAddress);
    }

    private String parseWhenNumbersIsLast(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(0, firstNumberIndex - 1);
        final String houseNumber = input.substring(firstNumberIndex).trim();
        return parseStringToJson(streetName, houseNumber);
    }

    private String parseWhenNumbersIsFirst(String input) {
        final int firstNumberIndex = findElementInString(input);
        final String streetName = input.substring(firstNumberIndex).trim();
        final String houseNumber = input.substring(0, firstNumberIndex - 1);
        return parseStringToJson(streetName, houseNumber);
    }

}
