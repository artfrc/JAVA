// https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true

import java.util.List;

public class simpleArraySum {

    public static void main(String[] args) {
    }

    public static int simpleArraySum(List<Integer> ar) {
        int sum =0;
        for(Integer number : ar) {
            sum += number;
        }

        return sum;

    }

}
