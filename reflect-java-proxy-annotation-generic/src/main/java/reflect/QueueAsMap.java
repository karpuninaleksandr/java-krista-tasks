package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Queue(name = "map")
public class QueueAsMap<T> implements MyQueue<T> {
    private final Map<Integer, T> queue;
    private int index = 0;

    public QueueAsMap() {
        queue = new HashMap<>();
    }
    //конструктор класса

    @Override
    public void push(T newTask) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (index == 0) {
            queue.put(index, newTask);
        } else {
            for (int i = 0; i < index; ++i) {
                Method getPriority = newTask.getClass().getDeclaredMethod("getPriorityOfTask");
                getPriority.setAccessible(true);
                int a = (int) getPriority.invoke(queue.get(i));
                int b = (int) getPriority.invoke(newTask);
                if (a <= b) {
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
    //пуш в очередь

    @Override
    public T pop() {
        T first = null;
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
    public Collection<T> getQueue() {
        return queue.values();
    }
    //получение очереди целиком
}
