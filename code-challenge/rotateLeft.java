//https://www.hackerrank.com/challenges/array-left-rotation/problem?isFullScreen=true

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rotateLeft {

    public static void main(String[] args) {

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int posFirstElement = arr.size() - d;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        ans.set(posFirstElement, arr.get(0));
        for(int i = 1; i < arr.size(); i++) {
            int idx = (posFirstElement+i) % arr.size();
            ans.set(idx, arr.get(i));
        }

        return ans;
    }
}
