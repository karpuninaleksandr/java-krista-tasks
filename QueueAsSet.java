package reflect;

import java.util.Set;
import java.util.TreeSet;

@Queue(name = "set")
public class QueueAsSet implements MyQueue {
    private final Set<Task> queue;

    public QueueAsSet() {
        queue = new TreeSet<>(Task::comparePriority);
    }
    //конструктор класса

    @Override
    public void push(Task newTask) {
        queue.add(newTask);
    }
    //пуш в очередь

    @Override
    public Task pop() {
        Task first = null;
        if (!queue.isEmpty()) {
            first = queue.stream().findFirst().get();
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
