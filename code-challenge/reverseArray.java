// https://www.hackerrank.com/challenges/arrays-ds/problem?isFullScreen=true

import java.util.Collections;
import java.util.List;

public class reverseArray {
    public static void main(String[] args) {

    }
    public static List<Integer> reverseArray(List<Integer> a) {
        int left = 0;
        int right = a.size()-1;
        while(left < right) {
            Collections.swap(a, left, right);
            left++;
            right--;
        }

        return a;

    }
}
