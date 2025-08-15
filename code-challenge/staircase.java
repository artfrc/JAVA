// https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true

public static void main(String[] args) {
    public static void staircase(int n) {
        int aux = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j < aux) System.out.printf(" ");
                else System.out.printf("#");
            }
            System.out.println("");
            aux--;
        }

    }
}