package reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public interface MyQueue<T> {
    void push(T taskToAdd) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    T pop();
    int size();
    boolean isEmpty();
    Collection<T> getQueue();
}