// https://www.hackerrank.com/challenges/crush/problem

import java.util.Arrays;
import java.util.List;

public class arrayManipulation {
    public static void main(String[] args) {

    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] diffArray = new long[n + 1];

        for (List<Integer> query : queries) {
            int a = query.get(0) - 1;
            int b = query.get(1);
            long k = query.get(2);

            diffArray[a] += k;
            if (b < n) {
                diffArray[b] -= k;
            }
        }


        long max = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += diffArray[i];
            max = Math.max(max, currentSum);
        }

        return max;
    }
}

