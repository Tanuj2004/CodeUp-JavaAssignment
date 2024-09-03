/***
 *Task 5: Longest Substring Without Repeating Characters
 *Given a string s, find the length of the longest substring without repeating characters.
 *Example 1:
          ● Input: s = "abcabcbb"
          ● Output: 3
          ● Explanation: The answer is "abc", with the length of 3.
 * Owner = TanujYadav
 * Date = 09/02/2024
 */

import java.util.Scanner;

public class LongestSubString {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        while (true) {
            System.out.println(Constants.PROMPT_MESSAGE);
            String s = reader.nextLine();
            
            // Check if the user wants to exit
            if (s.equalsIgnoreCase("exit")) {
                break;
            }
            
            Result result = lengthOfLongestSubstring(s);
            System.out.println(Constants.LONG + result.length);
            System.out.println(Constants.LONGESTSTRING + result.substring);
        }
        
        reader.close();
    }

    public static Result lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int start = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (charIndex[currentChar] > left) {
                left = charIndex[currentChar];
            }
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = left;
            }
            charIndex[currentChar] = right + 1;
        }

        String longestSubstring = s.substring(start, start + maxLength);
        return new Result(maxLength, longestSubstring);
    }
}

class Result {
    int length;
    String substring;

    Result(int length, String substring) {
        this.length = length;
        this.substring = substring;
    }
}
