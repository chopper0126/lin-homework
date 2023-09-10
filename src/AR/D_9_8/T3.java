package AR.D_9_8;

/**
 * @author chopper
 * @version 1.0
 * @description: TODO
 * @date 2023/9/8 19:57
 */
import java.util.Arrays;

public class T3 {
    public static void main(String[] args) {
        String x = "0";
        String nextNumber = findNextDifferentTernaryNumber(x);
        System.out.println(nextNumber); // Output: 120
    }

    public static String findNextDifferentTernaryNumber(String x) {
        // Convert the input ternary number to an array of characters for easier manipulation
        char[] numberArray = x.toCharArray();

        // Find the first occurrence of a digit that can be incremented
        int i;
        for (i = numberArray.length - 1; i >= 0; i--) {
            if (numberArray[i] < '2') {
                // Increment the digit and break the loop
                numberArray[i]++;
                break;
            }
        }

        // If no digit can be incremented, the number itself is the largest possible
        if (i < 0) {
            int len = x.length();
            StringBuilder sb = new StringBuilder();

            while(len > 0){
                if (len % 2 == 0){
                    sb.append('0');
                }else {
                    sb.append('1');
                }
                len--;
            }
            return sb.toString();

        }

        // Set all subsequent digits to the smallest possible value '0'
        Arrays.fill(numberArray, i + 1, numberArray.length, '0');

        // Check if the adjacent digits are the same and modify them if necessary
        for (int j =  1; j < numberArray.length; j++) {
            // If the current digit is the same as the previous one, increment it
            if (numberArray[j] == numberArray[j - 1]) {
                numberArray[j]++;
                Arrays.fill(numberArray, j + 1, numberArray.length, '0');
                // Check if the incremented digit becomes '2', in which case it should be set to '0'
                if (numberArray[j] > '2') {
                    numberArray[j] = '0';
                    numberArray[j - 1]++;
                }
            }
        }

        // Convert the modified array back to a string and return it as the result
        return String.valueOf(numberArray);
    }
}

