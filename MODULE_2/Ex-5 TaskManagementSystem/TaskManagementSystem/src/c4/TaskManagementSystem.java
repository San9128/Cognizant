package c4;
public class TaskManagementSystem {
    private Node head;
    private int size;
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskManagementSystem() {
        head = null;
        size = 0;
    }
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
    public void deleteTaskById(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        } else {
            System.out.println("Task not found.");
        }
    }
}
