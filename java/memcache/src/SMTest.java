public class SMTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("this is test for SimpleMemCache");
        SimpleMemcache  cache = new SimpleMemcache<String, String>();
        cache.start();
        Thread.sleep(10000);
        System.out.println("sleep over");
//        cache.stop();
    }
}
