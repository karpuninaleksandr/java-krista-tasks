package reflect;

import java.util.ArrayList;
import java.util.List;

public class QueueAsList implements MyQueue {
    private final List<Task> queue;

    public QueueAsList() {
        queue = new ArrayList<>();
    }

    public void push(Task newTask) {
        queue.add(newTask);
        queue.sort(Task::comparePriority);
    }

    public Task pop() {
        Task first = null;
        if (!queue.isEmpty()) {
            first = queue.get(0);
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
