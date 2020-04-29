package org.renm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestMain {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");
        String[] names = ac.getBeanDefinitionNames();
        System.out.println(names.length);
        for (String s : names) {
            System.out.println(s);
        }
    }

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");

    }

    @Test
    public void test2() {
//        List<String> list = Arrays.asList("Aa", "Ab", "Ac");
        List<String> list = new ArrayList<String>();
//        List<String> list = new ArrayList<>("Aa", "Ab", "Ac");
//        new ArrayList<String>("Aa", "Ab", "Ac")
        list.add("Aa");
        list.add("Ab");
        list.add("Ac");
//        List<String> list1 = Arrays.asList("Ba", "Bb", "Bc");
        List<String> list1 = new ArrayList<String>();
        list1.add("Ba");
        list1.add("Bb");
        list1.add("Bc");
        System.out.println("list:" + list);
        System.out.println("list1:" + list1);
        System.out.println("---------------------");
        list.addAll(list1);
        System.out.println("list:" + list);
        System.out.println("list1:" + list1);
        System.out.println("---------------------");
        list1.add("Bd");
        System.out.println("list:" + list);
        System.out.println("list1:" + list1);
        System.out.println("---------------------");
        list1.clear();
        System.out.println("list1.clear(): " + list1);
    }

    @Test
    public void test3() {
        Date dt = new Date();
        System.out.println(dt);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR, -1);//日期减1年
        rightNow.add(Calendar.MONTH, 3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR, 10);//日期加10天
        System.out.println(rightNow.getTime());
        System.out.println(rightNow.get(Calendar.YEAR));
    }

    private Date getNextDay(Date date) {
        // TODO day + 1
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    @Test
    public void testGetNextDay() {
        Date date = new Date();
        System.out.println(date);
        date = getNextDay(date);
        System.out.println(date);
    }

    @Test
    public void test4() {
        int i = 0, j = 0, cur = 0;
        int arr[] = new int[]{1, 2, 3, 3, 4, 5, 2};
        int sz = 7;

        for (i = 0; i < 7; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (i = 0; i < sz; i++) {
            for (j = 0; j < cur; j++) {
                if (arr[i] == arr[j])
                    break;
            }
            if (j == cur) {
                arr[cur] = arr[i];
                cur++;
            }
        }
        for (i = 0; i < cur; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

