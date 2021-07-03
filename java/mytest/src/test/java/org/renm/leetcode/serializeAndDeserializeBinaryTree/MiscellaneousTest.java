package org.renm.leetcode.serializeAndDeserializeBinaryTree;

import org.junit.Test;

import java.util.*;

public class MiscellaneousTest {

    @Test
    public void testStringBuilder() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(Integer.valueOf(3));
        builder.append(',');
        builder.append((Integer) null);
        builder.append(']');
        int length = builder.length();
        builder.setCharAt(length - 1, ')');
        String s = builder.toString();
        System.out.println(s);
    }

    @Test
    public void testFormat() {
        Codec codec = new Codec();
        String format = codec.format(Arrays.asList(3, 4, null, 5));
        System.out.println(format);
        String s = format.substring(1, format.length() - 1);
        System.out.println(s);
    }

    @Test
    public void testUnpakage() {
        Codec codec = new Codec();
        List<TreeNode> list = codec.unpakage("[1,2,null,4]");
        System.out.println(list);
    }

    @Test
    public void testTrimEnd() {
        Codec codec = new Codec();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(null);
        list.add(4);
        list.add(null);
        list.add(null);
        System.out.println(list);
        List<Integer> trimEnd = codec.trimEnd(list);
        System.out.println(trimEnd);
        System.out.println(list);
    }

    @Test
    public void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        System.out.println(list.get(0));
    }

    @Test
    public void testMapComput() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('c', 2);
        Integer c = map.get('c');
        if (c == null) {
            map.put('c', 1);
        } else {
            c++;
        }

        map.compute('a', (k, v) -> v == null ? 1 : v++);
        Integer b = map.computeIfAbsent('b', (k) -> 0);
//        ++b;
        map.put('b', ++b);

        System.out.println(map);

    }
}
