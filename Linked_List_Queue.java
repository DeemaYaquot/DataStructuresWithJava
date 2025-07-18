import java.util.Scanner;

class Node {
    public int data;
    public Node next;
    public Node prev;
}

class LinkedListQueue {
    Node enter = null;
    Node monitor = null;
    int size = 0;

    public Node create(int d) {
        Node node = new Node();
        if (node != null) {
            node.data = d;
            node.next = null;
            node.prev = null;
        }
        return node;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void enqueue(int d) {
        Node node = create(d);
        size++;
        if (node != null) {
            if (enter == null) {
                enter = monitor = node;
            } else {
                node.next = enter;
                enter.prev = node;
                enter = node;
            }
        }
    }

    public int dequeue() {
        size--;
        int k = monitor.data;
        if (enter == monitor) {
            enter = monitor = null;
        } else {
            monitor = monitor.prev;
            monitor.next = null;
        }
        return k;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        try {
            LinkedListQueue queue = new LinkedListQueue();
            Scanner input = new Scanner(System.in);
            String M = input.nextLine().replaceAll("\\[|\\]", "");
            String[] word = M.split(", ");
            int[] array = new int[word.length];
            if (word.length == 1 && word[0].isEmpty()) {
                array = new int[] {};
            } else {
                for (int i = word.length - 1; i >= 0; i--)
                    array[i] = Integer.parseInt(word[i]);
            }
            for (int i = array.length - 1; i >= 0; i--) {
                queue.enqueue(array[i]);
            }
            int numberone;
            String operation = input.nextLine();
            switch (operation) {
                case "isEmpty":
                    if (queue.isEmpty()) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "size":
                    System.out.println(queue.size);
                    break;
                case "enqueue":
                    numberone = input.nextInt();
                    queue.enqueue(numberone);
                    print(queue);
                    break;
                case "dequeue":
                    if (queue.isEmpty()) {
                        input.close();
                        throw new Exception();
                    } else {
                        queue.dequeue();
                        print(queue);
                    }
                    break;
                default:
                    input.close();
                    throw new Exception();
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void print(LinkedListQueue queue) {
        System.out.print("[");
        int j = queue.size();
        Node current = queue.enter;
        for (int i = 0; i < j; i++) {
            System.out.print(current.data);
            current = current.next;
            if (i != j - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}
