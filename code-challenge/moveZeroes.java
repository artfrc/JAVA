// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

public class moveZeroes  {

    class Solution {
        public void moveZeroes(int[] nums) {

            for(int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                if(num == 0) {
                    for(int j = i; j < nums.length - 1; j++) {
                        int tmp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }

        }
    }
}
