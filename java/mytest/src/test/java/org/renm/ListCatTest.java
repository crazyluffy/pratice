package org.renm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCatTest {
    private List<List<String>> source;

    @Before
    public void prepareLists() {
        source = new ArrayList<>();
        source.add(Arrays.asList("aaa", "bbb"));
        source.add(Arrays.asList("ccc", "ddd"));
        source.add(Arrays.asList("eeee", "ffff", "ggg"));
    }

    @Test
    public void testByForeach() {
        System.out.println(listCatByForeach(source));
    }

    private List<String> listCatByForeach(List<List<String>> lists) {
        List<String> list = new ArrayList<>();
        lists.forEach(list::addAll);
        return list;
    }

    @Test
    public void testByStream() {
        System.out.println(listCatByStream(source));
    }

    private List<String> listCatByStream(List<List<String>> lists) {
        List<String> list = new ArrayList<>();
        return lists.stream().reduce(list, (dest, l) -> {
            dest.addAll(l);
            return dest;
        });
    }
}
