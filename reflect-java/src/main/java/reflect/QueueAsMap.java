package reflect;

import java.util.HashMap;
import java.util.Map;

public class QueueAsMap implements MyQueue {
    private final Map<Integer, Task> queue;
    private int index = 0;

    public QueueAsMap() {
        queue = new HashMap<>();
    }

    public void push(Task newTask) {
        if (index == 0) {
            queue.put(index, newTask);
        } else {
            for (int i = 0; i < index; ++i) {
                if (queue.get(i).getPriorityOfTask() <= newTask.getPriorityOfTask()) {
                    for (int j = index; j >= i; --j) {
                        queue.put(j, queue.get(j - 1));
                    }
                    queue.put(i, newTask);
                    break;
                }
                if (i == index - 1) {
                    queue.put(index, newTask);
                }
            }
        }
        ++index;
    }

    public Task pop() {
        Task first = null;
        if (!queue.isEmpty()) {
            int key = 0;
            while (key < index) {
                if (queue.containsKey(key)) {
                    first = queue.get(key);
                    queue.remove(key);
                    return first;
                }
                ++key;
            }
        }
        return null;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        for (int i = 0; i < index; ++i) {
            if (queue.containsKey(i)) {
                System.out.println("Name: " + queue.get(i).getNameOfTask() + "\n"
                        + "Body: " + queue.get(i).getBodyOfTask() + "\n"
                        + "Priority: " + queue.get(i).getPriorityOfTask() + "\n");
            }
        }
    }
}
