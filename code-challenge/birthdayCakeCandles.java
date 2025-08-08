// https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true

public static void main(String[] args) {

    public static int birthdayCakeCandles(List<Integer> candles) {

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        int max = 0;

        for(Integer candle : candles) {
            mp.put(candle, mp.getOrDefault(candle, 0) + 1);

            if(candle > max) max = candle;
        }

        return mp.get(max);

    }
}