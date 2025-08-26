// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/

class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[s] != nums[i]) {
                nums[s+1] = nums[i];
                s++;
            }
        }

        return s+1;

    }
}