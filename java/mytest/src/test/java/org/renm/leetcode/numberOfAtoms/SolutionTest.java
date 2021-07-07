package org.renm.leetcode.numberOfAtoms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testCountOfAtoms() {
        Solution solution = new Solution();
        String result = solution.countOfAtoms("H2O");
        System.out.println(result);
        expressionAssert("H2O", result);

        result = solution.countOfAtoms("Mg(OH)2");
        System.out.println(result);
        expressionAssert("H2MgO2", result);

        result = solution.countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(result);
        expressionAssert("K4N2O14S4", result);

        result = solution.countOfAtoms("Be32");
        System.out.println(result);
        expressionAssert("Be32", "Be32");
    }

    private void expressionAssert(String expect, String actual) {
        assertEquals("expect ["+expect+"]; actual: [" + actual +"]", expect, actual);
    }
}