package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(new Task("First Task", "Try adding Task to Queue", taskPriorities.Normal),
                new Task("Second Task", "Try adding one more Task to Queue", taskPriorities.VeryHigh),
                new Task("Third task", "Text", taskPriorities.High),
                new Task("Fourth task", "Text", taskPriorities.Low),
                new Task("Fifth Task", "Deleting element", taskPriorities.Normal));

        QueueAsMap queue;
        try {
            Class c = Class.forName(QueueAsMap.class.getName());
            queue = (QueueAsMap) c.newInstance();
            tasks.forEach(task -> {
                try {
                    Method push = QueueAsMap.class.getDeclaredMethod("push", Task.class);
                    push.setAccessible(true);
                    push.invoke(queue, task);
                    Method print = QueueAsMap.class.getDeclaredMethod("printQueue");
                    print.setAccessible(true);
                    print.invoke(queue);
                    Method size = QueueAsMap.class.getDeclaredMethod("size");
                    size.setAccessible(true);
                    Method isEmpty = QueueAsMap.class.getDeclaredMethod("isEmpty");
                    System.out.println("Size: " + size.invoke(queue) + " Empty: " + isEmpty.invoke(queue));
                    System.out.println("--------------------------------");
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
            tasks.forEach(task -> {
                try {
                    Method pop = QueueAsMap.class.getDeclaredMethod("pop");
                    pop.setAccessible(true);
                    pop.invoke(queue);
                    Method print = QueueAsMap.class.getDeclaredMethod("printQueue");
                    print.setAccessible(true);
                    print.invoke(queue);
                    Method size = QueueAsMap.class.getDeclaredMethod("size");
                    size.setAccessible(true);
                    Method isEmpty = QueueAsMap.class.getDeclaredMethod("isEmpty");
                    System.out.println("Size: " + size.invoke(queue) + " Empty: " + isEmpty.invoke(queue));
                    System.out.println("--------------------------------");
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

enum taskPriorities {
    VeryHigh,
    High,
    Normal,
    Low,
}