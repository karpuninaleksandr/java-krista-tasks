import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(new Task("First Task", "Try adding Task to Queue", 10),
                new Task("Second Task", "Try adding one more Task to Queue", 9),
                new Task("Third task", "Text", 8),
                new Task("Fourth task", "Text", 11),
                new Task("Fifth Task", "Deleting element", 7));
        MyQueueAsList myQueue = new MyQueueAsList();
        for (Task task: tasks)
        {
            myQueue.push(task);
            myQueue.printQueue();
            System.out.println("Empty: " + myQueue.isEmpty() + "\n" + "Size: " + myQueue.size());
            System.out.println("------------------------");
        }
        for (int i = 0; i < tasks.size(); ++i) {
            Task taskToPop = myQueue.pop();
            myQueue.printQueue();
            System.out.println("Empty: " + myQueue.isEmpty() + "\n" + "Size: " + myQueue.size());
            System.out.println("------------------------");
        }
    }
}
