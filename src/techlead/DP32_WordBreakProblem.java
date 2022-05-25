package techlead;

//https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/?ref=lbp
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DP32_WordBreakProblem {
    public static boolean wordBreak(String s, List<String> dictionary) {
        // create a dp table to store results of subproblems
        // value of dp[i] will be true if string s can be segmented
        // into dictionary words from 0 to i.
        boolean[] dp = new boolean[s.length() + 1];

        // dp[0] is true because an empty string can always be segmented.
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] dictionary = {"mobile", "samsung", "sam", "sung", "man",
                "mango", "icecream", "and", "go", "i", "q",
                "like", "ice", "cream", "sungmanq", "qwerty"};

        List<String> dict = new ArrayList<>();
        for (String s : dictionary) {
            dict.add(s);
        }

        if (wordBreak("qwerty", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("ilikesamsung", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("iiiiiiii", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("samsungandmango", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("ilikesamsung", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("samsungandmangok", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
