//https://www.hackerrank.com/challenges/append-and-delete/problem?isFullScreen=true

public class appendAndDelete {
    public static void main(String[] args) {
    }

    public static String appendAndDelete(String s, String t, int k) {
        int prefixCommon = 0;
        for(prefixCommon = 0; prefixCommon < Math.min(s.length(), t.length()); prefixCommon++) {
            if(s.charAt(prefixCommon) != t.charAt(prefixCommon)) {
                break;
            }
        }

        int operations = (s.length() - prefixCommon) + (t.length() - prefixCommon);
        System.out.println(operations);

        if(operations > k) return "No";
        else if(operations == k || operations < k && (k - operations) % 2 == 0 || k >= s.length() + t.length()) return "Yes";

        return "No";
    }
}
