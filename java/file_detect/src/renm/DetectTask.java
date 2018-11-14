package renm;

public class DetectTask {
    String cronExpression = null;
    String fileName = null;
    Checker checker;
    Reporter reporter;
    Detector detector;

    public DetectTask(String cronExpression, String fileName, Reporter reporter) {
        this(cronExpression, fileName, null, reporter);
    }

    public DetectTask(String cronExpression, String fileName, Checker checker, Reporter reporter) {
        this();
        this.cronExpression = cronExpression;
        this.fileName = fileName;
        if( null == checker){
            checker = new FileCheck();
        }
        setChecker(checker);
        setReporter(reporter);
    }

    private DetectTask() {
        detector = new Detector();
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        detector.setFileName(fileName);
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public String getFileName() {
        return fileName;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
        detector.setChecker(checker);
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
        detector.setReporter(reporter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetectTask taskNode = (DetectTask) o;

        if (cronExpression != null ? !cronExpression.equals(taskNode.cronExpression) : taskNode.cronExpression != null)
            return false;
        return fileName != null ? fileName.equals(taskNode.fileName) : taskNode.fileName == null;
    }

    @Override
    public int hashCode() {
        int result = cronExpression != null ? cronExpression.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }

    public void init(){
        if(fileName == null || cronExpression == null){
            System.out.println("warn: fileName or cornExpression must not be null");
            return;
        }
        if(null == reporter){
            System.out.println("warn: reporter need to be specified");
            return;
//            reporter = new DRReportDirectly();
        }
       if(null == checker) {
       }
        detector.setChecker(checker);
        detector.setReporter(reporter);
        Thread thread = new Thread(detector);
        thread.run();
        return;
    }

    public void detect(){
//        boolean done = detect.check(fileName);
        if(detector != null) {
            detector.update();
        }
    }
}
