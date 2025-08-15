// https://www.hackerrank.com/challenges/2d-array/problem?isFullScreen=true

import java.util.List;

public class hourglassSum {

    public static void main(String[] args) {

    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(i).size() - 3; j++) {
                int sum =
                        arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                                arr.get(i+1).get(j+1) +
                                arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
