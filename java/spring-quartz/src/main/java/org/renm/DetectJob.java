package org.renm;

// for test
import java.util.Date;

public class DetectJob {
    public void detect(){
        System.out.println("detect:" + new Date());
    }
    public void detect(String symbol){
        System.out.println("detect(symbol["+ symbol +"])" + new Date());
    }
    public void detect(String symbol1, String symbol2){
        System.out.println("detect(symbol1["+ symbol1 +"] symbol2[" + symbol2 +"])" + new Date());
    }
}
