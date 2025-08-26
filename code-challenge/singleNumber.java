// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(Integer num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(Integer number : mp.keySet()) {
            if(mp.get(number) == 1) {
                return number;
            }
        }

        return 0;
    }
}