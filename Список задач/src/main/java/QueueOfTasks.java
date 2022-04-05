import java.util.Collection;

public interface QueueOfTasks {

    void push(Task taskToAdd);

    Task pop();

    void delete(Task taskToDelete);
    //пусть и в очереди нет как такового метода удаления,
    //мне он понравился и я его написал, пусть и не использую

    int size();

    boolean isEmpty();

    Collection<Task> getQueue();

    void printQueue();

}