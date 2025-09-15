// https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/

public class climbStairs {
}

class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        return climbStarirs(n, mp);

    }

    public int climbStarirs(int n, HashMap<Integer, Integer> memo) {
        if(n == 0 || n == 1) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, climbStarirs(n - 1, memo) + climbStarirs(n - 2, memo));

        return memo.get(n);
    }
}
