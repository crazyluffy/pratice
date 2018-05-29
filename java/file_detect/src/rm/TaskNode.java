package rm;

import java.util.List;

public class TaskNode {
    String cronExpression = null;
    String fileName = null;

    public TaskNode(String cronExpression, String fileName) {
        this.cronExpression = cronExpression;
        this.fileName = fileName;
    }

    public TaskNode() {
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskNode taskNode = (TaskNode) o;

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

    public void detect (DailyDetect detect){
        boolean done = detect.check(fileName);
    }
}
