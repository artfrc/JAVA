  public class App {
    public static void main(String[] args) throws Exception {

        Utilities utilities = new Utilities();
        String key = "0001001100110100010101110111100110011011101111001101111111110001";
        System.out.println(">> Key: " + key + " || Length: " + key.length() + "\n");

        String permutationKey = utilities.IpPermutaion(key);
        System.out.println(">> Permutation Key: " + permutationKey + " || Length: " + permutationKey.length() + "\n");
        utilities.AddLeftShift(0, permutationKey);
        
        for(int i = 1; i <= 16; i++) {
           String leftShift = utilities.LeftShifts(utilities, i);
          //  subKey = utilities.generateSubKey(leftShift);

        }

      }
}
