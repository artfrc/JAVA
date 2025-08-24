// https://www.hackerrank.com/challenges/sparse-arrays/problem?isFullScreen=true

public static void main(String[] args) {

}

public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    HashMap<String, Integer> hmp = new HashMap<>();
    for (String str : stringList) {
        hmp.put(str, hmp.getOrDefault(str, 0) + 1);
    }


    List<Integer> ans = new ArrayList<>();
    for(String str : queries) {
        ans.add(hmp.containsKey(str) ? hmp.get(str) : 0);
    }

    return ans;

}