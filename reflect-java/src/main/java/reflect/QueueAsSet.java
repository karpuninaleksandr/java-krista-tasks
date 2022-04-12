package reflect;

import java.util.Set;
import java.util.TreeSet;

public class QueueAsSet implements MyQueue {
    private final Set<Task> queue;

    public QueueAsSet() {
        queue = new TreeSet<>(Task::comparePriority);
    }

    public void push(Task newTask) {
        queue.add(newTask);
    }

    public Task pop() {
        Task first = null;
        if (!queue.isEmpty()) {
            first = queue.stream().findFirst().get();
            queue.remove(first);
        }
        return first;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        queue.forEach(task -> System.out.println("Name: " + task.getNameOfTask() + "\n"
                + "Body: " + task.getBodyOfTask() + "\n"
                + "Priority: " + task.getPriorityOfTask() + "\n"));
    }
}
