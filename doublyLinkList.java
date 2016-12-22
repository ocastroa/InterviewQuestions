/**
 * Created by oscar on 12/13/2016.
 */
public class doublyLinkList {
    class Node{
        String value;
        Node next;
        Node prev;
    }

    Node head, tail = null;

    public Node newNode(String word){ // creates new node with String value and pointers to next and previous
        Node temp = new Node();
        temp.value = word;
        temp.next = null;
        temp.prev = null;
        return temp;
    }

    public void insertAtHead(String word){
        Node temp = newNode(word);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else {
            head.prev = temp; //current head points to new node
            temp.next = head; // new node points to current head
            head = temp; // head now becomes new node
        }
    }

    public void insertAtTail(String word){
        Node temp = newNode(word);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp; // current tail node points to new node
            temp.prev = tail; // new node points to current tail
            tail = temp; // new node becomes new tail
        }
    }

    public void removeAtHead(){
        Node curr = head;
        if(head == tail){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
            curr = null;
        }
    }

    public void removeAtTail(){
        Node curr = tail;
        if(head == tail){
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            curr = null;
        }
    }

    private void peekHead() { // peek top value of stack
        Node curr = head;
        if (isEmpty() != true) { // as long as link list is not empty
            System.out.println("Head value is: " + curr.value);
        }
    }

    private void peekTail() { // peek top value of stack
        Node curr = tail;
        if (isEmpty() != true) { // as long as link list is not empty
            System.out.println("Tail value is: " + curr.value);
        }
    }

    boolean isEmpty() { // checks if link list is empty and returns true or false
        Node curr = head;
        if (curr.next == null)
            return true;
        return false;
    }

    private void iterateInOrder(){ // prints out the link list
        Node curr = head;
        while(curr != null){ // as long as head is not null
            System.out.println(curr.value);
            curr = curr.next; // increase next pointer
        }
    }

    private void iterateInReverse(){ // prints out the link list in reverse
        Node curr = tail;
        while(curr != null){ // as long as tail is not null
            System.out.println(curr.value);
            curr = curr.prev; // increase prev pointer
        }
    }

    public static void main(String [] args){
        doublyLinkList newString = new doublyLinkList();
        newString.insertAtTail("Hello");
        newString.insertAtTail("there");
        newString.insertAtTail("awesome");
        newString.insertAtTail("world");

        newString.iterateInReverse();
       // newString.peekTail();
        //newString.iterateInOrder();


    }

}