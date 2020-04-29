package org.renm.cron;


import java.util.*;
import java.util.concurrent.*;

public class FileChecker {

    public static void main(String[] args) {

    }

    // Actual file name could be like 'FileA_2018-11-11.txt'
    private List<String> fileNames;

    private Map<Date, Set<String>> arrivedFiles = new HashMap<>();

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void startCheck() {
        checkFiles(fileNames);
    }

    private void checkFiles(List<String> fileNames) {
        Date date = getStartDate();
        while (true) {
            checkFilesForDate(fileNames, date);
            date = getNextDate(date);
        }
    }

    private Date getNextDate(Date date) {
        // TODO: get next business date
        return null;
    }

    private void checkFilesForDate(List<String> fileNames, Date checkDate) {
        List<Future<ThreadResult>> futureList = new ArrayList<>();

        for (String file : fileNames) {
            futureList.add(startCheckThread(file, checkDate));
        }

        FutureTask
        while (!isAllArrived(checkDate)) {
            for (Future<ThreadResult> f : futureList) {
                if (f.isDone()) {
                    ThreadResult result = null;
                    try {
                        result = f.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    Date date = result.getDate();
                    String file = result.getFile();
                    addToArrivedFiles(file, date);
                }
            }
        }
    }

    private boolean isAllArrived(Date checkDate) {
        return arrivedFiles.get(checkDate).size() == fileNames.size();
    }

    private void addToArrivedFiles(String file, Date date) {
        // TODO: if date not exists, add new list and add file. Otherwise add file into list directly.
    }

    private Future<ThreadResult> startCheckThread(String file, Date checkDate) {
        FileCheckThread t = new FileCheckThread(file, checkDate);
        return executorService.submit(t);
    }

    public Date getStartDate() {
        // TODO: get start date
        return null;
    }

    private static final class FileCheckThread implements Callable<ThreadResult> {

        private String file;

        private Date date;

        public FileCheckThread(String file, Date date) {
            this.file = file;
            this.date = date;
        }

        @Override
        public ThreadResult call() {
            while (true) {
                if (isArrived(file, date)) {
                    persistToDB(file, date);
                    return new ThreadResult(file, date);
                }

                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void persistToDB(String file, Date date) {
            // TODO: write result to DB
        }

        private boolean isArrived(String file, Date date) {
            // TODO: check if file arrived or not
            return false;
        }

    }

    private static final class ThreadResult {
        private String file;

        private Date date;

        public ThreadResult(String file, Date date) {
            this.file = file;
            this.date = date;
        }

        public String getFile() {
            return file;
        }

        public Date getDate() {
            return date;
        }
    }

}
