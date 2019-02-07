package helpers;

public class IndexCount {

    public static int findFirstNumberInString(String input) {
        for (int index = 0; index < input.length(); index++) {
            final char charAt = input.charAt(index);
            if (Character.isDigit(charAt)) {
                return index;
            }
        }
        return -1;
    }

}
