package rm;

import java.util.*;

// not used after know sprint util:list; will be delete

public class TaskContainer {
    List<TaskNode> container = new ArrayList<TaskNode>();

    public List<TaskNode> getContainer() {
        return container;
    }

    public void setContainer(List<TaskNode> container) {
        this.container = container;
    }

    public void addTaskNode(TaskNode node){
        container.add(node);
    }
}
