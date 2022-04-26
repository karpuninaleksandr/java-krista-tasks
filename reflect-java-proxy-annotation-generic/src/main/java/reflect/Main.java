package reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Task> tasks = Arrays.asList(
            new Task("First Task", "Try adding Task to Queue", taskPriorities.Normal),
            new Task("Second Task", "Try adding one more Task to Queue", taskPriorities.VeryHigh),
            new Task("Third task", "Text", taskPriorities.High),
            new Task("Fourth task", "Text", taskPriorities.Low),
            new Task("Fifth Task", "Deleting element", taskPriorities.Normal));
        //список задачек

        MyQueue<Task> queue = (MyQueue<Task>) ProxyQueue.newInstance(new QueueAsSet());
        //создание проксиОчереди

        tasks.forEach(task ->
            {
                try {
                    queue.push(task);
                } catch (
                    InvocationTargetException |
                    NoSuchMethodException |
                    IllegalAccessException e
                ) {
                    e.printStackTrace();
                }
            }
        );
        //запуск серии пушей в проксиОчередь

        tasks.forEach(task -> queue.pop());
        //запуск серии попов из проксиОчереди
    }
}

enum taskPriorities {
    VeryHigh,
    High,
    Normal,
    Low,
}
//перечисление приоритетов задач