package helpers;

public class IndexCount {

    /**
     * @return index for the number in the string
     */

    public static int findNumberInString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                return index;
            }
        }
        return 0;
    }

}
