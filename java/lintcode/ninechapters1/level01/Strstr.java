package lintcode.ninechapters1.level01;

/**
 * Created by jun on 6/29/2015.
 */
public class Strstr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int sourceLen = source.length();
        int targetLen = target.length();
        if (sourceLen < targetLen) {
            return -1;
        }

        for (int i = 0; i < sourceLen - targetLen + 1; i++) {
            int temp = i;
            for (int j = 0; j < targetLen; j++) {
                if (source.charAt(temp) == target.charAt(j)) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp == i + targetLen) {
                return i;
            }
        }

        return -1;
    }
}
