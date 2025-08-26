// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> aux = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            aux.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            int number = aux.get(i);
            int newPos = (i+k)%nums.length;
            nums[newPos] = number;
        }
    }
}