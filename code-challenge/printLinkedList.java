// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem?isFullScreen=true

public static void main(String[] args) {

}

static void printLinkedList(SinglyLinkedListNode head) {
    while(head != null) {
        System.out.println(head.data);
        head = head.next;
    }

}