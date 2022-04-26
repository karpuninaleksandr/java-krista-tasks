package reflect;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Queue(name = "set")
public class QueueAsSet<T> implements MyQueue<T> {
    private final Set<T> queue;

    public QueueAsSet() {
        queue = new TreeSet<>(comparator);
    }
    //конструктор класса

    @Override
    public void push(T newTask) {
        queue.add(newTask);
    }
    //пуш в очередь

    @Override
    public T pop() {
        T first = null;
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
    public Set<T> getQueue() {
        return queue;
    }
    //получения очереди целиком

    Comparator<T> comparator = (o1, o2) -> {
        try {
            Field f = o1.getClass().getDeclaredField("priorityOfTask");
            return (int) f.get(o2) - (int) f.get(o1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    };
    //для сравнения по приоритету задач
}
