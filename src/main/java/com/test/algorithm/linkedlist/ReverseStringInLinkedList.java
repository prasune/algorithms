package com.test.algorithm.linkedlist;

public class ReverseStringInLinkedList {

    public static void main(String[] args) {
        LinkedList head = createLinkedListForString("practise makes a man perfect");
        head = reverse(head);
        LinkedList current = head;
        while(current != null) {
            System.out.print(current.data);
            current = current.next;
        }
    }

    private static LinkedList reverse(LinkedList head) {
        LinkedList current = head;
        LinkedList previous = null;
        while (current != null) {
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static LinkedList createLinkedListForString(String inputString) {
        LinkedList head = new LinkedList("" +inputString.charAt(0));
        LinkedList current = head;
        for (int i = 1; i < inputString.length(); i++) {
            LinkedList linkedList = new LinkedList("" +inputString.charAt(i));
            current.next = linkedList;
            current = current.next;
        }
        return head;
    }

    static class LinkedList {
        public String data;
        public LinkedList next;
        public LinkedList(String data) {
            this.data = data;
        }
    }
}
