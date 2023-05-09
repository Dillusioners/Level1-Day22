/*
 * Author - Debag101
 * Purpose - Palindrome checker
 * Date - 09/05/2023
 */

//Importing important packages for input
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Palindrome {

    boolean isPalindrome(String str, int len) {// Taking the string and its length input
        if (str == "") {// Empty strings are always palindrom
            return true;
        } else if (len == 1) {// A single character string is always a palindrome
            return true;
        } else {
            int midPoint = len / 2;// Finding the midpoint index
            for (int i = 0; i <= midPoint; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    return false;// if we find any instance of not equals we return false
                }
            }
        }
        return true;// Else we return true
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Palindrome padObj = new Palindrome();// Creating class obj to call method
        String inputString = "";
        try {
            System.out.println(">> Enter the string => ");
            inputString = rd.readLine();// getting string input
            if (padObj.isPalindrome(inputString, inputString.length())) {
                System.out.printf(">> %s is a palindrome !", inputString);
            } else {
                System.out.printf(">> %s is not a palindrome !", inputString);
            }
        } catch (Exception StringIndexOutOfBoundsException) {
            System.err.printf("%s string is a palindrome !", inputString);
        }
    }// program ends
}
