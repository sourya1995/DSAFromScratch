package TwoPointers;

/* Leetcode 443 - String Compression */
public class StringCompression {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int readIndex = 0;
        int n = chars.length;

        while (readIndex < n) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count occurrences of the current character
            while (readIndex < n && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character
            chars[writeIndex++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex;
    }
}
