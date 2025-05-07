import java.util.Arrays;

public class LatexParser {
    public static String parseNumber(String number, String prefix, String suffix) {
        return prefix + number + suffix;
    }

    public static String parseFraction(String numerator, String denominator, boolean positive, String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        if (!positive) {
            sb.append("-");
        }
        sb.append(prefix).append("\\frac{").append(numerator).append("}{").append(denominator).append("}").append(suffix);
        return sb.toString();
    }

    public static String parseSquareRoot(String value, String prefix, String suffix) {
        return prefix + "\\sqrt{" + value + "}" + suffix;
    }

    /**
     * This method parses a given String array with strings that are already parsed to LaTeX
     * as a LaTeX polynom. Entries containing the value null will be seen as 0 for the current position
     * of the polynom and hence won't be parsed. There is an alternative method if zeros are supposed
     * to be added
     * @param values the values have to be parsed to LaTeX before calling this method
     * @return The entire polynom put together as one big LaTeX String
     */
    public static String parsePolynom(String[] values, String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < values.length; i++) {
            if (i == values.length - 1 && values[i] != null) {
                sb.append(values[i]);
            } else if (i == values.length - 2 && values[i] != null) {
                sb.append(values[i]).append("x ");
            } else if (values[i] != null){
                sb.append(values[i]).append("x^{").append(values.length - 1 - i).append("} ");
            }

            if (leftOverExists(values, i) && !nextValueIsNegative(values, i) && sb.charAt(sb.length() - 1) != '+') {
                sb.append("+");
            }
        }
        sb.append(suffix);
        return sb.toString();
    }

    /**
     * A method for checking if there are none null values left from the current index + 1
     * onwards
     * @param array A string array potentially not having Strings left from the current
     *              index + 1 onwards
     * @param index The method will start checking from the index: index +1. So when used
     *              in a loop, the functions checks if there exists at least one not null
     *              value to the right of the given index
     * @return      Returns true, if there is a not null value left from index + 1 onwards
     */
    private static boolean leftOverExists(String[] array, int index) {
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method for checking if the next valid value is negative. Next valid value means
     * the next not null value. If the entire array has been checked from index + 1 onwards,
     * and it hasn't found a valid value it will return false. The checking is only a very simple
     * implementation, for proper investigation it is advised to use a different method
     * @param array A string array potentially not having a (valid) next value from the current
     *              index + 1 onwards
     * @param index The method will start checking from the index: index +1. So when used
     *              in a loop, the functions checks if there exists at least one not null
     *              value to the right of the given index
     * @return Returns true if the first character of the next valid value starts with '-'
     */
    private static boolean nextValueIsNegative(String[] array, int index) {
        if (index + 1 < array.length) {
            if (array[index + 1] == null) {
                return nextValueIsNegative(array, index + 1);
            }
            return array[index + 1].charAt(0) == '-';
        }
        return false;
    }
}
