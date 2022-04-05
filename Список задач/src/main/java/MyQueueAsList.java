import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class MyQueueAsList implements QueueOfTasks {
    private final List<Task> listOfTasks;

    public MyQueueAsList() {
        listOfTasks = new ArrayList<>();
    }

    public void push(Task taskToAdd) {
        listOfTasks.add(taskToAdd);
        listOfTasks.sort(Task::compareTo);
    }

    public Task pop() {
        if (!listOfTasks.isEmpty()) {
            Task taskToPop = listOfTasks.get(0);
            listOfTasks.remove(taskToPop);
            return taskToPop;
        }
        return null;
    }

    public void delete(Task taskToDelete) {
        listOfTasks.remove(taskToDelete);
    }

    public int size() {
        return listOfTasks.size();
    }

    public boolean isEmpty() {
        return listOfTasks.isEmpty();
    }

    public List<Task> getQueue() {
        return listOfTasks;
    }

    public void printQueue() {
        for (Task task: listOfTasks) {
            System.out.println("Name: " + task.getNameOfTask() + "\n" + "Body: " + task.getBodyOfTask() + "\n" + "Priority: " + task.getPriorityOfTask() + "\n");
        }
    }
}
