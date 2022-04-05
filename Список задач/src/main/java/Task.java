public class Task {
    private String nameOfTask;
    private String bodyOfTask;
    private int priorityOfTask;

    public Task(String nameOfTask, String bodyOfTask, int priorityOfTask)
    {
        this.nameOfTask = nameOfTask;
        this.bodyOfTask = bodyOfTask;
        this.priorityOfTask = priorityOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }
    public void setBodyOfTask(String bodyOfTask) {
        this.bodyOfTask = bodyOfTask;
    }
    public void setPriorityOfTask(int priorityOfTask) {
        this.priorityOfTask = priorityOfTask;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }
    public String getBodyOfTask() {
        return bodyOfTask;
    }
    public int getPriorityOfTask() {
        return priorityOfTask;
    }

    public int compareTo(Task task) {
        return task.getPriorityOfTask() - this.priorityOfTask;
    }
}
