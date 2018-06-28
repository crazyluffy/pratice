
public class TestPause {
    public static void main(String[] args) {
        System.out.println("TestPause");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
