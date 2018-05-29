package rm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
//plan 1
class ThreadNodeInfo{
    String fileName;
    boolean done = false;

    public ThreadNodeInfo(String fileName) {
        this.fileName = fileName;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
*/

// plan 2
class ThreadInfo {
    boolean done = false;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

public class DailyDetect {
//    List<ThreadNodeInfo> fileList = new ArrayBlockingQueue<ThreadNodeInfo>(); // plan 1
    HashMap<String, ThreadInfo> taskMap = new HashMap<String, ThreadInfo>(); // plan 2

    public DailyDetect(List<TaskNode> task) {
        System.out.println("daily detect init: add file from task list, check whether file already come");
        detect();
    }

    public void update(){
        System.out.println("daily detect update");
        detect();
    }

    private void detect() {
        System.out.println("create detect thread for every file in fileList(taskMap)");
    }

    public boolean check(String fileName){
        System.out.println("check whether fileName still in fileList(taskMap)");
        return true; // just for test
    }

    public void cancel(String fileName){
        System.out.println("remove fileName from fileList(taskMap), cancel thread which deal fileName");
    }
}
