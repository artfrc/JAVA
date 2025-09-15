// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880

public class reverseInt {
}

class Solution {
    public int reverse(int x) {

        boolean neg = false;
        if (x < 0){
            neg = true;
            x *= -1;
        }

        long reverse = 0;

        while(x > 0) {
            reverse = reverse*10 + (x % 10);
            x /= 10;
        }

        if(neg) {
            reverse *= -1;
        }

        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;

        return (int) reverse;
    }
}
