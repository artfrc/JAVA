// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

public class firstUniqueChar {
}

class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }


        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer repeat = mp.get(c);
            if(repeat == 1) return i;
        }

        return -1;

    }
}
