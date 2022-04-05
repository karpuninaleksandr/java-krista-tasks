import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class MyQueueAsSet implements QueueOfTasks {
    private final Set<Task> setOfTasks;

    public MyQueueAsSet() {
        setOfTasks = new TreeSet<>(Task::compareTo);
    }

    public void push(Task taskToAdd) {
        setOfTasks.add(taskToAdd);
    }

    public Task pop() {
        Task taskToPop = setOfTasks.stream().findFirst().get();
        setOfTasks.remove(taskToPop);
        return taskToPop;
    }

    public void delete(Task taskToDelete) {
        setOfTasks.remove(taskToDelete);
    }

    public int size() {
        return setOfTasks.size();
    }

    public boolean isEmpty() {
        return setOfTasks.isEmpty();
    }

    public Set<Task> getQueue() {
        return setOfTasks;
    }

    public void printQueue() {
        for (Task task: setOfTasks) {
            System.out.println("Name: " + task.getNameOfTask() + "\n" + "Body: " + task.getBodyOfTask() + "\n" + "Priority: " + task.getPriorityOfTask() + "\n");
        }
    }
}
