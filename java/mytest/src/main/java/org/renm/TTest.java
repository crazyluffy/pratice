package org.renm;

import java.util.HashMap;

public class TTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test for intellij project");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    System.out.println("print");
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        }).start();
//        Thread.sleep(10000);
        System.out.println("sleep over");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Double> map1 = new HashMap<String, Double> ();
        System.out.println(map.getClass());
        System.out.println(map1.getClass());
        System.out.println(map.getClass() == map1.getClass());
    }
}
