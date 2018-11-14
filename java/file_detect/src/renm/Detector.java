package renm;

public class Detector implements Runnable{
    boolean reported;
    String fileName;
    DetectResult result;
    boolean run = true;
//    boolean needCheck = true;
    Checker checker;
    Reporter reporter;
//    String symbol;

    public void check(){
        if (checker != null) {
            checker.check(fileName, result);
        }
    }

    public synchronized void report(){
        if(reporter != null){
//            if(!reported){
            if(reported == false){
                reporter.report(result);
                setReported(true);
            }
        }
    }

    public Checker getChecker() {
        return checker;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public synchronized void cancel (){
        setRun(false);
    }

    public synchronized void update(){
        setRun(true);
        setReported(false);
        result.reset();
    }

    @Override
    public void run() {
       while (run) {
           if(!reported && !result.isDone()){
               check();
           }
           report();
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               System.out.println("warning: sleep be interrupted unexpected");
           }
       }
    }
}

