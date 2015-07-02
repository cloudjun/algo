package lintcode.util;

import java.util.ArrayList;

/**
 * Created by jun on 7/2/2015.
 */
public class Util {
    public static void print(ArrayList<ArrayList<Integer>> arrayLists) {
        if (arrayLists == null) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (ArrayList<Integer> arrayList : arrayLists) {
            sb.append("    [");
            for (Integer item : arrayList) {
                sb.append(item);
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("],\n");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n]");
        System.out.println(sb);
    }
}
