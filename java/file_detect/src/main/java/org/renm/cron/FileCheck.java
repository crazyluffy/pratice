package org.renm.cron;

import org.renm.pojo.FileCheckResult;
import org.renm.pojo.FileCron;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class FileCheck {
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    private FileCheckManagerThread managerThread = new FileCheckManagerThread();
    private boolean managerThreadRun = false;
    private HashMap<String, Set<FileCron>> CheckResults = new HashMap<String, Set<FileCron>>();

    public FileCheck() {
        managerThreadRun = true;
        threadPool.submit(managerThread);
    }

    public void addFileCheckTask(FileCron fileCron) {
        managerThread.addTask(fileCron);
    }

    private String getDayString(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    public void addFileCheckTask(List<FileCron> fileCronList) {
        managerThread.addTask(fileCronList);
    }

    public class FileCheckManagerThread implements Runnable {
        private List<FileCron> fileCronList = new ArrayList<>();
        private List<FileCron> cache = new ArrayList<FileCron>();
        private List<Future<FileCheckResult>> futureList = new ArrayList<Future<FileCheckResult>>();

        @Override
        public void run() {
            Date date = new Date();
            initCheckTask();
            while (managerThreadRun) {
                /* add cached task to task list in loop,
                *  watch the status of the task in task list,
                *  start a tasks of a new day when all task in task list is done
                * */
                if (futureList.isEmpty()){
                    if (isEarlierThanToday(date)) {  // TODO: if -> while ??
                        date = getNextDay(date);
                        startCheckTask(date);
                    }
                }
                activateCachedWorkThread();
                for (Future<FileCheckResult> f : futureList) {
                    if (f.isDone()) {
                        FileCheckResult fileCheckResult = null;
                        try {
                            fileCheckResult = f.get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        recordFileArriveToLocal(fileCheckResult);
                        recordFileArriveToDb(fileCheckResult);
                        futureList.remove(f);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }

            }
        }

        private void initCheckTask() {
            initCheckTask(fileCronList);
        }

        private void initCheckTask(List<FileCron> list) {
            list.forEach(this::initCheckTask);
        }

        private void initCheckTask(FileCron fileCron) {
            FileCheckResult lastRecord = getLastSuccessRecord(fileCron);
            if (lastRecord == null) {
                futureList.add(createWorkThread(fileCron, new Date()));
                return;
            }
            Date date = lastRecord.getTime();
            date = getStartDate(date);
            while (!isLaterThanToday(date)) {
                lastRecord.setTime(date);
                futureList.add(createWorkThread(lastRecord));
                date = getNextDay(date);
            }
        }

        private void startCheckTask(Date date) {
            for (FileCron fileCron : fileCronList) {
                Future<FileCheckResult> future = createWorkThread(fileCron, date);
                futureList.add(future);
            }
        }

        // record to resultList
        private void recordFileArriveToLocal(FileCheckResult fileCheckResult) {
            Date date = fileCheckResult.getTime();
            String dayString = getDayString(date);
            Set<FileCron> fileCronSet = CheckResults.get(dayString);
            if(fileCronSet == null){
                fileCronSet = new HashSet<FileCron>();
            }
            fileCronSet.add(fileCheckResult.getFileCron());
        }

        private void recordFileArriveToDb(FileCheckResult fileCheckResult) {
            //TODO record to DB

        }

        private void activateCachedWorkThread() {
            //TODO lock cacheLock?
            initCheckTask(cache);
            fileCronList.addAll(cache);
            cache.clear();
            //TODO unlock cacheLock?
        }

        private boolean isToday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int yearDate = calendar.get(Calendar.YEAR);
            int dayDate = calendar.get(Calendar.DAY_OF_YEAR);
            Date today = new Date();
            calendar.setTime(today);
            int yearToday = calendar.get(Calendar.YEAR);
            int dayToday = calendar.get(Calendar.DAY_OF_YEAR);
            return (yearDate == yearToday) && (dayDate) == (dayToday);
        }

        private boolean isLaterThanToday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int yearDate = calendar.get(Calendar.YEAR);
            int dayDate = calendar.get(Calendar.DAY_OF_YEAR);
            Date today = new Date();
            calendar.setTime(today);
            int yearToday = calendar.get(Calendar.YEAR);
            int dayToday = calendar.get(Calendar.DAY_OF_YEAR);
            return (yearDate > yearToday) || (dayDate) > (dayToday);
        }

        private boolean isEarlierThanToday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int yearDate = calendar.get(Calendar.YEAR);
            int dayDate = calendar.get(Calendar.DAY_OF_YEAR);
            Date today = new Date();
            calendar.setTime(today);
            int yearToday = calendar.get(Calendar.YEAR);
            int dayToday = calendar.get(Calendar.DAY_OF_YEAR);
            return (yearDate < yearToday) || (dayDate) < (dayToday);
        }

        private Date getNextDay(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            return calendar.getTime();
        }

        /*
        *  if date - today > 3 day {date = today - 3day}
        *  parameter： date - the date of last success record
        * */
        private Date getStartDate(Date date) {
            Calendar calendar = Calendar.getInstance();
            Date today = new Date();
            calendar.setTime(today);
            calendar.add(Calendar.DAY_OF_YEAR, -3);//-3 - the most count of days can be checked
            long time3DayAgo = calendar.getTimeInMillis();
            Date date3DayAgo = calendar.getTime();
            if (date == null) {
                date = today;
            } else {
                calendar.setTime(date);
                long timeDate = calendar.getTimeInMillis();
                if (timeDate < time3DayAgo) {
                    date = date3DayAgo;
                }
            }
            return date;
        }


        private FileCheckResult getLastSuccessRecord(FileCron fileCron) {
            //TODO select last success record from db and return
            return null;
        }

        private Future<FileCheckResult> createWorkThread(FileCron t, Date date) {
            FileCheckResult result = new FileCheckResult();
            result.setTime(date);
            result.setFileCron(t);
            return createWorkThread(result);
        }

        private Future<FileCheckResult> createWorkThread(FileCheckResult result) {
            FileCheckWorkThread thread = new FileCheckWorkThread(result);
            return threadPool.submit(thread);
        }

        public void addTask(FileCron fileCron) {
            cacheTask(fileCron);
        }

        public void addTask(List<FileCron> fileCrons) {
            cacheTask(fileCrons);
        }

        private void cacheTask(List<FileCron> fileCrons) {
            //TODO lock cacheLock?
            cache.addAll(fileCrons);
            //TODO unlock cacheLock?
        }

        private void cacheTask(FileCron fileCron) {
            //TODO lock cacheLock?
            cache.add(fileCron);
            //TODO unlock cacheLock?
        }

    }

    private class FileCheckWorkThread implements Callable<FileCheckResult> {

        private final FileCheckResult result;

        public FileCheckWorkThread(FileCheckResult result) {
            this.result = result;
        }

        @Override
        public FileCheckResult call() throws Exception {
            /* TODO check file reach or not
            * */
            return result;
        }
    }
}
