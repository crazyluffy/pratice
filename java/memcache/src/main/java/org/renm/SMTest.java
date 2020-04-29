package org.renm;

public class SMTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("this is test for SimpleMemCache");
//        SimpleMemcache  cache = new SimpleMemcache<String, String>(); //need use factory method
//        cache.start();
//        Thread.sleep(10000);
//        System.out.println("sleep over");
//        cache.stop();
//        cache.put("1", "val1");
//        cache.put("2", "val2");
//        Thread.sleep(1000);
//        System.out.println(cache.get("1"));
        SimpleMemcache<String, String> sCache = SimpleMemcache.getSimpleMemcache(String.class, String.class);
//        sCache.start();
        Thread.sleep(10000);
        System.out.println("sleep over");
        sCache.put("1", "val1");
        sCache.put("2", "val2");
        Thread.sleep(1000);
        System.out.println(sCache.get("1"));

    }
}
