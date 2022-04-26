package reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Queue(name = "list")
public class QueueAsList<T> implements MyQueue<T> {
    private final List<T> queue;

    public QueueAsList() {
        queue = new ArrayList<>();
    }
    //конструктор класса

    @Override
    public void push(T newTask) {
        queue.add(newTask);
        queue.sort(comparator);
    }
    //пуш в очередь

    @Override
    public T pop() {
        T first = null;
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
    public List<T> getQueue() {
        return queue;
    }
    //получение очереди целиком

    Comparator<T> comparator = (o1, o2) -> {
        try {
            Field f = o1.getClass().getDeclaredField("priorityOfTask");
            return (int) f.get(o2) - (int) f.get(o1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    };
    //для сортировки по приоритету задачи
}
