// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

class Solution {
    public boolean isPalindrome(String s) {
        
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] list = cleanedString.toCharArray();
        
        int l = 0, r = list.length -1;
        
        while(l < r) {
            Character cl = list[l];
            Character cr = list[r];
            if(Character.toUpperCase(cl) != Character.toUpperCase(cr)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}

