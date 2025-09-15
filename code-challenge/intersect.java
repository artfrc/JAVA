// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int num : nums2) {
            if (mp.getOrDefault(num, 0) > 0) {
                ans.add(num);
                mp.put(num, mp.get(num) - 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}