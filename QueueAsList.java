package reflect;

import java.util.ArrayList;
import java.util.List;

@Queue(name = "list")
public class QueueAsList implements MyQueue {
    private final List<Task> queue;

    public QueueAsList() {
        queue = new ArrayList<>();
    }
    //конструктор класса

    @Override
    public void push(Task newTask) {
        queue.add(newTask);
        queue.sort(Task::comparePriority);
    }
    //пуш в очередь

    @Override
    public Task pop() {
        Task first = null;
        if (!queue.isEmpty()) {
            first = queue.get(0);
            queue.remove(first);
        }
        return first;
    }
    //поп первого элемента очереди

    @Override
    public int size() {
        return queue.size();
    }
    //размер очереди

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    //пустота очереди

    @Override
    public String printQueue() {
        String print = "";
        for (Task taskToPrint: queue) {
            print += taskToPrint.toString() + "\n";
        }
        return print;
    }
    //печать очереди для наглядности
}
