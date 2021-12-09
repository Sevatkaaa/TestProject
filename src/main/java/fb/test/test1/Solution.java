package fb.test.test1;

public class Solution {
    String rotationalCipher(String input, int rotationFactor) {
        char[] inputChars = input.toCharArray();
        for(int i = 0; i < inputChars.length; i++) {
            char current = inputChars[i];
            if (current >= '0' && current <= '9') { // digit
                inputChars[i] = (char)(current + (rotationFactor % 10));
                if (inputChars[i] > '9') {
                    inputChars[i] -= 10;
                }
            } else if (current >= 'A' && current <= 'Z') { // cap letter
                inputChars[i] = (char)(current + (rotationFactor % 26));
                if (inputChars[i] > 'Z') {
                    inputChars[i] -= 26;
                }
            } else if (current >= 'a' && current <= 'z') { // non-cap letter
                inputChars[i] = (char)(current + (rotationFactor % 26));
                if (inputChars[i] > 'z') {
                    inputChars[i] -= 26;
                }
            }
        }
        return String.valueOf(inputChars);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.rotationalCipher("Zebra-493?", 3);
        System.out.println(ans);
    }
}
