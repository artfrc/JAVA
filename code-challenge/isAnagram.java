// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] firstWord = s.toCharArray();
        char[] secondWord = t.toCharArray();
        
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);
        
        for (int i = 0; i < s.length(); i++) {
            if (firstWord[i] != secondWord[i]) {
                return false;
            }
        }
        
        return true;
        
    }
}