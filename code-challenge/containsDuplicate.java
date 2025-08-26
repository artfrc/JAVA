// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                return true;
            } else {
                mp.put(nums[i], nums[i]);
            }
        }

        return false;

    }
}