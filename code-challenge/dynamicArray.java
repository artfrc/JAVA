// https://www.hackerrank.com/challenges/dynamic-array/problem?isFullScreen=true

import java.util.ArrayList;
import java.util.List;

public class dynamicArray {

    public static void main(String[] args) {

    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<Integer>[] arrays = new ArrayList[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arrays[i] = new ArrayList<>();
        }

        int lastAnswer = 0;

        for(int i = 0; i < queries.size(); i++) {
            int query = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            int idx = (x ^ lastAnswer) % n;

            if(query == 1) {
                arrays[idx].add(y);

            } else {
                int size = arrays[idx].size();
                lastAnswer = arrays[idx].get(y % arrays[idx].size());
                ans.add(lastAnswer);
            }

        }

        return ans;

    }
}
