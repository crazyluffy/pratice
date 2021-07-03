package org.renm.leetcode.excelSheetColumnTitle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionComplete {
    private Solution solution = new Solution();

    @Test
    public void convertToTitle() {
        convertToTitleAssert("Z", 26);
        convertToTitleAssert("AB", 28);
        convertToTitleAssert("ZY", 701);
        convertToTitleAssert("BA", 53);
        convertToTitleAssert("AZ", 52);
    }

    private void convertToTitleAssert(String expected, int columnNumber) {
        assertEquals("covert\"" + columnNumber + "\", expected \"" + expected +"\"", expected,
                solution.convertToTitle(columnNumber));
    }
    @Test
    public void test() {
        int i = 'c' - 'a';
        int i1 = 'a' + 2;
        System.out.println('c' - 'a');
        System.out.println(3 % 26);
        System.out.println(i1);
        System.out.println((char) i1);
    }

}