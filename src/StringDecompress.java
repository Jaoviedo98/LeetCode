import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringDecompress {
    public static void main (String[] args) {
        System.out.println(decompress("2[3[a]b]"));
        System.out.println(decompress("a[]b"));
        System.out.println(decompress("0[abc]"));
    }

    public static String decompress (String input) {
        return helper(1, input);
    }

    private static String helper(int multiplier, String input) {
        if (input.equals("")) {
            return "";
        }
        String toRet = "";
        for (int j = 0; j < multiplier; j++) {
            int openCounter = 0;
            String tempInt = "";
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (current >= 97 && current <= 122) {
                    toRet += current;
                } else if (current >= 48 && current <= 57) {
                    tempInt += current;
                } else if (current == '[') {
                    openCounter++;
                    int multi = 1;
                    try {
                        multi = Integer.parseInt(tempInt);
                    } catch (Exception e) {
                        continue;
                    }
                    tempInt = "";
                    String tempInput = "";
                    while (openCounter > 0) {
                        i++;
                        current = input.charAt(i);
                        if (current == '[') {
                            openCounter++;
                        }
                        if (current == ']') {
                            openCounter--;
                            if (openCounter != 0) {
                                tempInput += ']';
                            }
                        } else {
                            tempInput += current;
                        }
                    }
                    toRet += helper(multi, tempInput);
                }
            }
        }
        return toRet;
    }

    @Test
    public void testDecompress() {
        assertEquals("abcabcabcababababc", decompress("3[abc]4[ab]c"), "10 x 0 must be 0");
        assertEquals("aaaaaaaaaa", decompress("10[a]"), "10 x 0 must be 0");
        assertEquals("aaabaaab", decompress("2[3[a]b]"), "10 x 0 must be 0");
    }

}
