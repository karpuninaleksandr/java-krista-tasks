package reflect;

public class Task {
    public String nameOfTask;
    public String bodyOfTask;
    public int priorityOfTask;

    public Task(String nameOfTask, String bodyOfTask, taskPriorities taskPriority) {
        this.nameOfTask = nameOfTask;
        this.bodyOfTask = bodyOfTask;
        switch (taskPriority) {
            case Low:
                this.priorityOfTask = 1;
                break;
            case Normal:
                this.priorityOfTask = 2;
                break;
            case High:
                this.priorityOfTask = 3;
                break;
            case VeryHigh:
                this.priorityOfTask = 4;
                break;
        }
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

    @Override
    public String toString() {
        return "Name: " + nameOfTask + "\n"
                + "Body: " + bodyOfTask + "\n"
                + "Priority: " + priorityOfTask + "\n";
    }
}