package Palindrome_Number;

import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        int[] list = new int[]{123};

        System.out.println("Palindrome numbers of the list: " + Arrays.toString(list));
        for (int num : list) {
            boolean result = isPalindromeTwo(num);
            System.out.println(num + ": " + result);
        }
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        String invertingNumber = "";
        int numberSize = number.length();

        while (numberSize > 0) {
            if (numberSize == 0) {
                invertingNumber = invertingNumber + number.substring(numberSize);
            } else {
                invertingNumber = invertingNumber + number.substring(numberSize - 1, numberSize);
            }

            numberSize--;
        }

        return number.equals(invertingNumber);
    }

    public static boolean isPalindromeTwo(int x) {
        if(x < 0) {
            return false;
        }

        int reverse = 0;
        int xcopy = x;

        while(x > 0) {
            int mult = reverse * 10;
            int rest = x % 10;
            reverse = mult + rest;
            x = x / 10;

            System.out.println("mult: " + mult);
            System.out.println("rest: " + rest);
            System.out.println("reverse: " + reverse);
            System.out.println("x: " + x);
            System.out.println("-------------");
        }

        return reverse == xcopy;
    }

//    public static boolean isPalindromeNoString(int x) {
//        int rest = x;
//        int divisor = 1;
//        String numberSize = "";
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<Integer> reverseList = new ArrayList<>();
//
//        if (x < 0) {
//            return false;
//        }
//
//        while (rest > 0) {
//            divisor = divisor * 10;
//            rest = x / divisor;
//
//            if ((rest < x) && (rest > 0)) {
//                if (rest > 10) {
//                    list.add(x - (rest * divisor));
//                    reverseList.add(x - (rest * divisor));
//                    numberSize = numberSize + (x - (rest * divisor));
//                } else if (rest == 10) {
//                    list.add(rest / divisor);
//                    reverseList.add(rest / divisor);
//                    numberSize = numberSize + (rest / divisor);
//                }
//
//                numberSize = numberSize + (rest % divisor);
//                if (Integer.parseInt(numberSize) <= x) {
//                    list.add(rest % divisor);
//                    reverseList.add(rest % divisor);
//                }else {
//                    list.add(rest / divisor);
//                    reverseList.add(rest / divisor);
//                }
//            } else if (rest == 0) {
//                numberSize = numberSize + rest;
//
//                if (Integer.parseInt(numberSize) == x) {
//                    list.add(rest);
//                    reverseList.add(rest);
//                }
//            }
//        }
//
//        Collections.reverse(reverseList);
//        return list.equals(reverseList);
//    }
}
