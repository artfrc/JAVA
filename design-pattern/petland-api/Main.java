import java.util.Map;

public class Main {
      public static void main(String[] args) {
       
            Map <String, Integer> mp = new HashMap<String, Integer>();
            mp.put("I", 1);
            mp.put("V", 5);
            mp.put("X", 10);
            mp.put("L", 50);
            mp.put("C", 100);
            mp.put("D", 500);
            mp.put("M", 1000);
            
            String test = "III"; // 3
            String test2 = "LVIII"; // 58
            String test3 = "MCMXCIV"; // 1994

            Main main = new Main();
            System.out.println(main.romanToint(test));
            System.out.println(main.romanToint(test2));
            System.out.println(main.romanToint(test3));

      }

      public Integer romanToint(String s) {
            return 11;
      }
}