package adam;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    // שאלה 1
    public static Node<Integer> a(int[] a){
        Node<Integer> fr = new Node<Integer>(a[0]);
        Node<Integer> last = fr;
        for(int i=1; i<a.length; i++) {
            Node<Integer> x = new Node<Integer>(a[i]);
            last.setNext(x);
            last = x;
        }
        return fr;
    }

    // שאלה 2 א
    public static void printList(Node<Integer> a) {
        while(a.getNext() != null) {
            System.out.println(a.getValue());
            a = a.getNext();
        }
    }

    // שאלה 2 ב
    public static void printListRec(Node<Integer> a) {
        if(a == null)
            return;
        System.out.println(a.getValue());
        printListRec(a.getNext());
    }

    // שאלה 2 ג
    public static void printListRecRev(Node<Integer> a) {
        if(a == null)
            return;
        printListRecRev(a.getNext());
        System.out.println(a.getValue());
    }

    // שאלה 3
    public static Node<Integer> inputList(){
        System.out.println("enter num or -1 to stop");
        Node<Integer> first = new Node<Integer>(null);
        Node<Integer> p = first;
        int num = reader.nextInt();
        Node<Integer> x;
        while(num != -1) {
            x = new Node<Integer>(num);
            p.setNext(x);
            p = x;
            System.out.println("enter num or -1 to stop");
            num = reader.nextInt();
        }
        return first.getNext();
    }

    // שאלה 4
    public static void printZogi(Node<Integer> a) {
        while(a != null) {
            if(a.getValue() % 2 == 0)
                System.out.println(a.getValue());
            a = a.getNext();
        }
    }

    // שאלה 5 א
    public static boolean check(Node<Integer> h, int x) {
        while(h != null) {
            if(x == h.getValue())
                return true;
            h = h.getNext();
        }
        return false;
    }

    // שאלה 5 ב
    public static boolean checkRec(Node<Integer> h, int x) {
        if(h == null) {
            return false;
        }
        if(h.getValue() == x)
            return true;
        return checkRec(h.getNext(), x);
    }

    // שאלה 6
    public static Node<Integer> erase(Node<Integer> a, int n){
        if(a.getValue() == n)
            return a.getNext();
        Node<Integer> list = a;
        Node<Integer> save = list;
        while(a != null) {
            if(a.getValue() == n) {
                list.setNext(a.getNext());
                return save;
            }
            list = a;
            a = a.getNext();
        }
        return save;
    }

    // שאלה 7
    public static Node<Integer> eraseIndex(Node<Integer> a, int i) {
        if(i == 1) {
            return a.getNext();
        }
        Node<Integer> prev = a;
        Node<Integer> save = a;
        for(int j = 0; j < i - 1; j++) {
            prev = a;
            a = a.getNext();
        }
        prev.setNext(a.getNext());
        return save;
    }

    // שאלה 8
    public static boolean isAppear(Node<Integer> L1, Node<Integer> L2, Node<Integer> s) {
        if(L1 == null)
            return true;
        if(L2 == null)
            return false;
        if(L1.getValue() == L2.getValue()) {
            return isAppear(L1.getNext(), s, s);
        }
        return isAppear(L1.getNext(), L2.getNext(), s);
    }

    // שאלה 9
    public static void printAppBoth(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> saveL2 = L2;
        while(L1 != null) {
            L2 = saveL2;
            while(L2 != null) {
                if(L1.getValue() == L2.getValue())
                    System.out.println(L1.getValue());
                L2 = L2.getNext();
            }
            L1 = L1.getNext();
        }
    }

    // שאלה 10
    public static Node<Integer> nodoble(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> fir = new Node<Integer>(null);
        Node<Integer> d = fir;
        Node<Integer> saveL2 = L2;
        while(L1 != null) {
            L2 = saveL2;
            while(L2 != null) {
                if(L1.getValue() == L2.getValue()) {
                    Node<Integer> a = new Node<Integer>(L1.getValue());
                    d.setNext(a);
                    d = a;
                }
                L2 = L2.getNext();
            }
            L1 = L1.getNext();
        }
        return fir.getNext();
    }

    // שאלה 11
    public static Node<Integer> divide(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> saveL1 = L1;
        Node<Integer> saveL2 = L2;
        while(L1 != null) {
            L2 = saveL2;
            while(L2 != null) {
                if(L1.getNext().getValue() == L2.getNext().getValue())
                    L1.setNext(L1.getNext().getNext());
                L2 = L2.getNext();
            }
            L1 = L1.getNext();
        }
        return saveL1;
    }
}
