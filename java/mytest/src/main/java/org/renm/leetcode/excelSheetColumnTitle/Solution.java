package org.renm.leetcode.excelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int tmp = columnNumber;
        int c = 'A';
        while (tmp > 0) {
            i = tmp % 26;
            tmp = tmp / 26;
            if (i == 0) {
                c = 'Z';
                tmp --;
            } else {
                c = 'A' - 1 + i;
            }
            stringBuilder.append((char) c);
        }
        return stringBuilder.reverse().toString();
    }
}
