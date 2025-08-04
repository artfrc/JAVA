// https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true

import java.math.BigInteger;

public class extraLongFactorials {

    public static void main(String[] args) {
    }

    public static void extraLongFactorials(int n) {
        BigInteger response = BigInteger.ONE;

        for(int i = n; i > 0; i--) {
            response = response.multiply(BigInteger.valueOf(i));
        }
        System.out.println(response);
    }


}
