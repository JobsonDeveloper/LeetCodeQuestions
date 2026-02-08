package Roman_To_Integer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code {
    public static void main(String[] args) {
        String[] list = new String[]{"III", "LVIII", "MCMXCIV"};

        for (String number : list) {
            System.out.println(number + ": " + romanToInt(number));
        }

        System.out.println("------------Expected------------");
        System.out.println("III: 3");
        System.out.println("LVIII: 58");
        System.out.println("MCMXCIV: 1994");
    }

    public static int romanToInt(String s) {
        String[] symbols = new String[s.length()];
        int[] splitNumber = new int[s.length()];
        HashMap<String, Integer> parser = new HashMap<>(Map.of(
                "I", 1, "V", 5,
                "X", 10, "L", 50,
                "C", 100, "D", 500,
                "M", 1000
        ));

        for (int i = 0; i < s.length(); i++) {
            symbols[i] = s.substring(i, i + 1);
        }

        for (int i = 0; i < symbols.length; i++) {
            Integer currentNum = parser.get(symbols[i]);

            if ((i + 1) < symbols.length) {
                Integer nextNum = parser.get(symbols[i + 1]);

                if (nextNum > currentNum) {
                    splitNumber[i + 1] -= currentNum;
                } else {
                    splitNumber[i] += currentNum;
                }
            } else {
                splitNumber[i] += currentNum;
            }
        }

        return Arrays.stream(splitNumber).sum();
    }
}
