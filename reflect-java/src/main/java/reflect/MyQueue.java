package reflect;

public interface MyQueue {
    void push(Task taskToAdd);
    Task pop();
    int size();
    boolean isEmpty();
    void printQueue();
}