class stacks {
    class Node { // create the node class
        int value;
        Node link;
    }

    Node top = null;

    private void push(int num) {
        Node temp = new Node();
        temp.value = num;
        temp.link = top; // link node to where node top is pointing to
        top = temp; // new node becomes the new top
    }

    private void pop() {
        Node curr;
        if (isEmpty() != true) {
            curr = top; // curr points to top node of link list
            top = top.link; // increase the top to the next node
            curr = null; // previous top becomes a null value
        }
    }

    private void peekTopValue() { // peek top value of stack
        Node curr = top;
        if (isEmpty() != true) { // as long as link list is not empty
            System.out.println("Top value is: " + curr.value);
        }
    }

    boolean isEmpty() { // checks if link list is empty and returns true or false
        Node curr = top;
        if (curr.link == null)
            return true;
        return false;
    }

    private void iterateLinkList(){ // prints out the link list
        Node curr = top;
        while(curr != null){ // as long as top is not null
            System.out.println("Number is " + curr.value);
            curr = curr.link; // increase curr pointer
        }
    }


    public static void main(String[] args) {
        stacks node = new stacks();
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