/**
 * Created by oscar on 9/8/2016.
 */
public class BinaryTree {

    Node root = null;
    int data;

    BinaryTreeOperations bst =new BinaryTreeOperations() ;
    Node node;

    public void insert(int data){
        node = new Node(data);
        if(root != null){
            bst.Insert(node, root);// insert new node
        }

        else{
            root = new Node(data); // create root if there's not one already
        }
    }

    public boolean delete(int data){
        if(root != null){ // if there is a root delete
            bst.delete(data,root);
        }
        return false;
    }

    public int Search(int data){
        if(root != null){
            return bst.Search(node, root);
        }
        else throw new NullPointerException();
    }

    public void inOrderTrans(){
        bst.inOrderTrans(root);
    }

    public void preOrderTrans(){
        bst.preOrderTrans(root);
    }

    public void postOrderTrans(){
        bst.postOrderTrans(root);
    }


    public static void main(String [] args){
        BinaryTree bst = new BinaryTree();
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(19);
        bst.insert(25);
        bst.insert(24);
        bst.insert(26);
        bst.insert(18);
        bst.insert(17);

        bst.delete(10);
        bst.inOrderTrans();
    }
}

