class queues{
    class Node{
        int value;
        Node link;
    }

    Node head, tail =  null;

    private void push(int num){
        Node temp = new Node();
        temp.value = num;
        temp.link = null;
        if(head == null){ // if there are no nodes
            head = temp; // head and tail point to the first node
            tail = temp;
        }
        else{
            tail.link = temp; // link to tail points to new node
            tail = temp; // new node becomes the tail
        }
    }

    private void pop(){
        Node curr = head;
        if(isEmpty() != true){
            if(head == tail){ // if there is only one node, then delete both head and tail
                head = null;
                tail = null;
            }
            head = head.link;
            curr = null;
        }
    }

    private void peekTopValue() { // peek top value of stack
        Node curr = head;
        if (isEmpty() != true) { // as long as link list is not empty
            System.out.println("Top value is: " + curr.value);
        }
    }

    boolean isEmpty() { // checks if link list is empty and returns true or false
        Node curr = head;
        if (curr.link == null)
            return true;
        return false;
    }

    private void iterateLinkList(){ // prints out the link list
        Node curr = head;
        while(curr != null){ // as long as head is not null
            System.out.println("Number is " + curr.value);
            curr = curr.link; // increase curr pointer
        }
    }

    public static void main(String[] args) {
        queues node = new queues();
        node.push(3);
        node.push(5);
        node.push(7);
        node.push(9);
        node.push(10);

        //node.pop();
       node.peekTopValue();

        node.iterateLinkList();
    }
}