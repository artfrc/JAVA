public class Utilities {

   private String[] leftShifts = new String[17]; // posicao 0 é usada para armazenar a chave permutada
   private String[] SubKeys = new String[16];

   public Utilities() {}

   public void AddLeftShift(Integer round, String leftShift) {
      this.leftShifts[round] = leftShift;
   }

   public String GetLeftShift(Integer round) {
      return leftShifts[round];
   }

   public String GetSubKey(Integer round) {
      return SubKeys[round];
   }

   public void AddSubKey(Integer round, String subKey) {
      this.SubKeys[round] = subKey;
   }

   public String IpPermutaion(String entry) {
      int[][] PcOne = {
         { 57, 49, 41, 33, 25, 17, 9 },
         { 1, 58, 50, 42, 34, 26, 18 },
         { 10, 2, 59, 51, 43, 35, 27 },
         { 19, 11, 3, 60, 52, 44, 36 },
         { 63, 55, 47, 39, 31, 23, 15 },
         { 7, 62, 54, 46, 38, 30, 22 },
         { 14, 6, 61, 53, 45, 37, 29 },
         { 21, 13, 5, 28, 20, 12, 4 }
      };

      String kp = "";

      for(int i  = 0; i < 8; i++) {
         for(int j = 0; j < 7; j++) {
            kp += entry.charAt(PcOne[i][j] - 1);
         }
      }

      return kp;
   }

   public String LeftHalf(String entry) {
      return entry.substring(0, entry.length() / 2);
   }

   public String RightHalf(String entry) {
      return entry.substring(entry.length() / 2);
   }

   public void LeftShifts(Utilities utilities, int round) {
      int numberOfShifts = 0;
      if(round == 1 || round == 2 || round == 9 || round == 16) {
         numberOfShifts = 1;
      } else {
         numberOfShifts = 2;
      }

      String leftHalf = utilities.LeftHalf(utilities.GetLeftShift(round - 1));
      String rightHalf = utilities.RightHalf(utilities.GetLeftShift(round - 1));

      for(int i = 0; i < numberOfShifts; i++) {
         leftHalf = leftHalf.substring(1) + leftHalf.charAt(0);
         System.out.println(">> C" + round + " = " + leftHalf + " ||" + " Length: " + leftHalf.length());
         rightHalf = rightHalf.substring(1) + rightHalf.charAt(0);
         System.out.println(">> D" + round + " = " + rightHalf + " ||" + " Length: " + rightHalf.length());
 
         /* 
            .substring(1) - pega a string a partir do segundo caractere
            .charAt(0) - pega o primeiro caractere da string.
            Logo, substring(1) + charAt(0) pega a string a partir do segundo caractere e concatena com o primeiro caractere.
          */
      }

      AddLeftShift(round, leftHalf + rightHalf);
   }

   public void generateSubKey(String leftKey) {
      int[][] PcTwo = {
         { 14, 17, 11, 24, 1, 5 },
         { 3, 28, 15, 6, 21, 10 },
         { 23, 19, 12, 4, 26, 8 },
         { 16, 7, 27, 20, 13, 2 },
         { 41, 52, 31, 37, 47, 55 },
         { 30, 40, 51, 45, 33, 48 },
         { 44, 49, 39, 56, 34, 53 },
         { 46, 42, 50, 36, 29, 32 }
      };

      String subKey = "";

      for(int i = 0; i < 8; i++) {
         for(int j = 0; j < 6; j++) {
            subKey += leftKey.charAt(PcTwo[i][j] - 1);
         }
      }
      System.out.println(">> Subkey = " + subKey + " || Length: " + subKey.length() + "\n");
   }
   
}
