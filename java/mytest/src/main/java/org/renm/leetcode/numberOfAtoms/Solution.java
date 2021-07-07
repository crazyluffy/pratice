package org.renm.leetcode.numberOfAtoms;

import java.util.*;

public class Solution {
    //too bad, need refactor.
    public String countOfAtoms(String formula) {
        HashMap<String, Integer> map = analyze(formula);
        StringBuilder builder = new StringBuilder();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, Integer> entry : list) {
            builder.append(entry.getKey());
            Integer count = entry.getValue();
            if (count > 1) {
                builder.append(count);
            }
        }
        return builder.toString();
    }

    private HashMap<String, Integer> analyze(String formula) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isUpperCase(c)) {
                AtomInFormula atomInFormula = new AtomInFormula(formula, i);
                atomInFormula.analyze();
                map.compute(atomInFormula.getElementName(), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return v + atomInFormula.getCount();
                });
                i = atomInFormula.getElementAndCountEnd();
                continue;
            }
            if (c == '(') {
                SubFormula subFormula = new SubFormula(formula, i);
                subFormula.analyze();
                Map<String, Integer> count = subFormula.count();
                count.forEach((k,v)-> map.compute(k, (s, t) -> {
                    if (t == null) {
                        t = 0;
                    }
                    return t + v;
                }));
                i = subFormula.getSubFormulaAndCountEnd();
            }
        }
        return map;
    }

    static class AtomInFormula {
        private final String sourceFormula;
        private final int elementStart;
        private int elememtEnd;
        private int elementAndCountEnd;

        private String elementName;
        private int count;

        public AtomInFormula(String sourceFormula, int elementStart) {
            this.sourceFormula = sourceFormula;
            this.elementStart = elementStart;
        }

        public int getElememtEnd() {
            return elememtEnd;
        }

        public int getElementAndCountEnd() {
            return elementAndCountEnd;
        }

        public int getCount() {
            return count;
        }

        public int getElementStart() {
            return elementStart;
        }

        public String getElementName() {
            return elementName;
        }

        public void analyze() {
            int i;

            for (i = elementStart + 1; i < sourceFormula.length(); i++) {
                char c = sourceFormula.charAt(i);
                if (!Character.isLowerCase(c)) {
                    break;
                }
            }
            elememtEnd = i - 1;
            elementName = sourceFormula.substring(elementStart, elememtEnd + 1);

            if (i == sourceFormula.length() || !Character.isDigit(sourceFormula.charAt(i))) {
                count = 1;
                elementAndCountEnd = i - 1;
                return;
            }
            for (; i < sourceFormula.length(); i++) {
                if (!Character.isDigit(sourceFormula.charAt(i))) {
                    break;
                }
            }
            elementAndCountEnd = i - 1;
            count = Integer.parseInt(sourceFormula.substring(elememtEnd + 1, i));
        }
    }

    private static class SubFormula {
        private final String sourceFormula;
        private final int start;

        private int subFormulaEnd;
        private int subFormulaAndCountEnd;
        private int subFormulaCount;

        private List<SubFormula> subSubFormulas = new ArrayList<>();
        private List<AtomInFormula> atoms = new ArrayList<>();


        public SubFormula(String sourceFormula, int start) {
            this.sourceFormula = sourceFormula;
            this.start = start;
        }

        public void analyze() {
            int i;
            for (i = start + 1; i < sourceFormula.length(); i++) {
                char c = sourceFormula.charAt(i);
                if (c == '(') {
                    SubFormula subFormula = new SubFormula(sourceFormula, i);
                    subFormula.analyze();
                    subSubFormulas.add(subFormula);
                    i = subFormula.getSubFormulaAndCountEnd();
                    continue;
                }
                if (c == ')') {
                    i++;
                    break;
                }
                if (Character.isUpperCase(c)) {
                    AtomInFormula atomInFormula = new AtomInFormula(sourceFormula, i);
                    atomInFormula.analyze();
                    atoms.add(atomInFormula);
                    i = atomInFormula.getElementAndCountEnd();
                }
                /*
                else {
                    throw new Exception("Does not match the rule");
                }
                 */
            }
            subFormulaEnd = i - 1;

            if (i == sourceFormula.length() || !Character.isDigit(sourceFormula.charAt(i))) {
                subFormulaCount = 1;
                subFormulaAndCountEnd = i - 1;
                return;
            }

            for (; i < sourceFormula.length(); i++) {
                if (!Character.isDigit(sourceFormula.charAt(i))) {
                    break;
                }
            }

            subFormulaAndCountEnd = i - 1;
            subFormulaCount = Integer.parseInt(sourceFormula.substring(subFormulaEnd + 1, i));
        }

        public Map<String, Integer> count() {
            HashMap<String, Integer> map = new HashMap<>();
            for (AtomInFormula atom : atoms) {
                map.compute(atom.getElementName(), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return v + atom.getCount() * subFormulaCount;
                });
            }

            for (SubFormula formula : subSubFormulas) {
                Map<String, Integer> count = formula.count();
                count.forEach((k,v)->{
                    map.compute(k, (s, t) -> {
                        if (t == null) {
                            t = 0;
                        }
                        return t + v * subFormulaCount;
                    });
                });
            }
            return map;
        }

        public String getSourceFormula() {
            return sourceFormula;
        }

        public int getStart() {
            return start;
        }

        public int getSubFormulaEnd() {
            return subFormulaEnd;
        }

        public int getSubFormulaAndCountEnd() {
            return subFormulaAndCountEnd;
        }

        public int getSubFormulaCount() {
            return subFormulaCount;
        }

        public List<SubFormula> getSubSubFormulas() {
            return subSubFormulas;
        }

        public List<AtomInFormula> getAtoms() {
            return atoms;
        }

    }
}
