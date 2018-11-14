package renm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
class DetectThreadInfo {
    String file = null;
    boolean done = false;
    String date;

    public DetectThreadInfo(String file) {
        this.file = file;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

public class DailyDetect {
//    List<ThreadNodeInfo> fileList = new ArrayBlockingQueue<ThreadNodeInfo>(); // plan 1
    HashMap<String, DetectThreadInfo> taskMap = new HashMap<String, DetectThreadInfo>(); // plan 2

    public DailyDetect(List<DetectTask> tasks) {
        System.out.println("daily detect init: add file from task list, check whether file already come");
        // getTaskList();
        Iterator<DetectTask> it = tasks.iterator();
        String file;
        DetectThreadInfo info;
        while (it.hasNext()){
            file = it.next().getFileName();
            info = new DetectThreadInfo(file);
            taskMap.put(file, info);

            System.out.println("check result from db for file:" +  file);
            boolean done = false; // = checkFormDb();

            info.setDone(done);
        }
        detect();
    }

    public void update(){
        System.out.println("daily detect update");
        // getTaskList();
        detect();
    }

    private void detect() {
        System.out.println("create detect thread for every file in fileList(taskMap)");
        Iterator it=taskMap.keySet().iterator();
        String file;
        DetectThreadInfo info;
        while(it.hasNext()) {
            file = (String) it.next();
            info = taskMap.get(file);
            System.out.println(file + ":" + info);
            if(info.isDone() == false){
                System.out.println("create thread for file:" + file);
            }
        }
    }

    public boolean check(String fileName){
        System.out.println("check whether fileName still in fileList(taskMap)");
        return true; // just for test
    }

    public void cancel(String fileName){
        System.out.println("remove fileName from fileList(taskMap), cancel thread which deal fileName");
    }
}
