/**
 * Created by oscar on 9/8/2016.
 */
public class Node { // creates new nodes with given params

    int key;
    int count;
    Node left;
    Node right;

    Node(int key){
        this.key = key;
        this.count = 1;
        this.left = null;
        this.right = null;
    }
}
