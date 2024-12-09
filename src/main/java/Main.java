package adam;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    // שאלה 1
    public static Node<Integer> a(int[] a) {
        Node<Integer> head = new Node<Integer>(a[0]);
        Node<Integer> current = head;

        for (int i = 1; i < a.length; i++) {
            current = current.setNext(new Node<Integer>(a[i]));
        }
        return head;
    }

    // שאלה 2
    public static Node<Integer> buildNode(int x, int y, int n) {
        Node<Integer> head = new Node<Integer>((int)(Math.random() * (x + y - 1) + x));
        Node<Integer> current = head;

        for (int i = 1; i < n; i++) {
            current = current.setNext(new Node<Integer>((int)(Math.random() * (x + y - 1) + x)));
        }
        return head;
    }

    // שאלה 3
    public static int count(Node<Integer> h, int x) {
        int count = 0;
        for (Node<Integer> current = h; current != null; current = current.getNext()) {
            if (current.getValue() == x) {
                count++;
            }
        }
        return count;
    }

    // שאלה 4
    public static void printList(Node<Integer> a) {
        Node<Integer> current = a;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    // שאלה 5 - חלק א
    public static void printListRec(Node<Integer> a) {
        if (a != null) {
            System.out.println(a.getValue());
            printListRec(a.getNext());
        }
    }

    // שאלה 5 - חלק ב
    public static void printListRecRev(Node<Integer> a) {
        if (a != null) {
            printListRecRev(a.getNext());
            System.out.println(a.getValue());
        }
    }

    // שאלה 6
    public static Node<Integer> inputList() {
        System.out.println("Enter numbers or -1 to stop:");
        Node<Integer> head = new Node<Integer>(null);
        Node<Integer> current = head;

        while (true) {
            int num = reader.nextInt();
            if (num == -1) {
                break;
            }
            current = current.setNext(new Node<Integer>(num));
            current = current.getNext();
        }
        return head.getNext();
    }

    // שאלה 7
    public static void printZogi(Node<Integer> a) {
        for (Node<Integer> current = a; current != null; current = current.getNext()) {
            if (current.getValue() % 2 == 0) {
                System.out.println(current.getValue());
            }
        }
    }

    // שאלה 8 - חלק א
    public static boolean check(Node<Integer> h, int x) {
        for (Node<Integer> current = h; current != null; current = current.getNext()) {
            if (current.getValue() == x) {
                return true;
            }
        }
        return false;
    }

    // שאלה 8 - חלק ב
    public static boolean checkRec(Node<Integer> h, int x) {
        return (h != null) && (h.getValue() == x || checkRec(h.getNext(), x));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("List from array:");
        printList(a(arr));

        Node<Integer> rachel = buildNode(1, 10, 20);
        System.out.println("Random list:");
        printList(rachel);

        System.out.println("Count of 3: " + count(rachel, 3));
        System.out.println();

        System.out.println("Print list recursively:");
        printListRec(rachel);

        System.out.println("Print list in reverse recursively:");
        printListRecRev(rachel);

        System.out.println("Even values:");
        printZogi(rachel);

        System.out.println("Check if 1 is in list:");
        System.out.println(checkRec(rachel, 1));
    }
}
