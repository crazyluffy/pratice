package org.renm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TLambda {
    public static void main(String[] args) {
        TLambda tLambda = new TLambda();
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(n-> System.out.println(n + "1"));
        List<String> list1 = new ArrayList<String>();
        list1.forEach(s -> tLambda.out(s));
    }

    @Test
    private void test() {
        List<String> list = Arrays.asList("m", "n", "o");
        list.forEach(this::out);
    }

    public void out(String s){
        System.out.println(s);
    }
    @Test
    public void test14() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 可改变对象
        list.stream().map((i) -> i * 3).forEach(System.out::println);

        // 不可改变元有对象
        list.forEach(i -> i = i * 3);
        list.forEach(System.out::println);
        ;
    }
}
