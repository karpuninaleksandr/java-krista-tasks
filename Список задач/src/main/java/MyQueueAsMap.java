import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Optional;

public class MyQueueAsMap implements QueueOfTasks{
    private final Map<Integer, Task> mapOfTasks;
    private int index = 0;

    public MyQueueAsMap() {
        mapOfTasks = new HashMap<>();
    }

    public void push(Task taskToAdd) {
        if (index == 0) {
            mapOfTasks.put(index, taskToAdd);
        } else {
            for (int i = 0; i < index; ++i) {
                if (mapOfTasks.get(i).getPriorityOfTask() <= taskToAdd.getPriorityOfTask()) {
                    for (int j = index; j >= i; --j) {
                        mapOfTasks.put(j, mapOfTasks.get(j - 1));
                    }
                    mapOfTasks.put(i, taskToAdd);
                    break;
                }
                if (i == index - 1) {
                    mapOfTasks.put(index, taskToAdd);
                }
            }
        }
        ++index;
    }

    public Task pop() {
        if (!mapOfTasks.isEmpty()) {
            int f = 0;
            while (f < index) {
                if (mapOfTasks.containsKey(f)) {
                    Task taskToPop = mapOfTasks.get(f);
                    mapOfTasks.remove(f);
                    return taskToPop;
                }
                ++f;
            }
        }
        return null;
    }

    public void delete(Task taskToDelete) {
        for (int i = 0; i < index; ++i) {
            if (mapOfTasks.containsKey(i)) {
                if (mapOfTasks.get(i).equals(taskToDelete)) {
                    mapOfTasks.remove(i);
                }
            }

        }
    }

    public int size() {
        return mapOfTasks.size();
    }

    public boolean isEmpty() {
        return mapOfTasks.isEmpty();
    }

    public Collection<Task> getQueue() {
        return mapOfTasks.values();
    }

    public void printQueue() {
        for (int i = 0; i < index; ++i) {
            if (mapOfTasks.containsKey(i)) {
                System.out.println("Name: " + mapOfTasks.get(i).getNameOfTask() + "\n" + "Body: " + mapOfTasks.get(i).getBodyOfTask() + "\n" + "Priority: " + mapOfTasks.get(i).getPriorityOfTask() + "\n");
            }
        }
    }
}
