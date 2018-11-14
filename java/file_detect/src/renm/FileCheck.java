package renm;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCheck implements Checker{
/*
    String fileName = null;

    public FileCheck() {
    }

    public FileCheck(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
*/

    @Override
    public DetectResult check(String fileName, DetectResult result) {
        if(result == null){
            result = new DetectResult(System.currentTimeMillis(), fileName, false);
        }
        result.setFileName(fileName);
        result.setTime(System.currentTimeMillis());
        try {
            FileReader fin = new FileReader(fileName);
            BufferedReader bin = new BufferedReader(fin);
            String s = bin.readLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date now = new Date();
            String today = format.format(now);
            result.setDone(today.equals(s));
        } catch (FileNotFoundException e) {
            System.out.println("does not find file: " + fileName);
            result.setDone(false);
        } catch (IOException e) {
            System.out.println("read file[" + fileName +"] fail:" + e);
            result.setDone(false);
        }
        return null;
    }
}
