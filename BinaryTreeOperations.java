/**
 * Created by oscar on 9/8/2016.
 */

class BinaryTreeOperations{

    public void Insert(Node node, Node root) {
        if (node.key == root.key) { // if there's already a node with same number increase counter
            root.count++;
        } else if (node.key < root.key) {
            if (root.left == null) { // if the left root is null then new node will go to left
                root.left = node;
            } else {
                Insert(node, root.left); // else keep looking to the left
            }
        } else if (node.key > root.key) { // if the right root is null then new node will go to the right
            if (root.right == null) {
                root.right = node;
            } else {
                Insert(node, root.right); // else keep looking to the right
            }
        }
    }

    public void delete(int data, Node root){
        Node parent = null;

        while(root.key != data) {
            parent = root; // parent will equal to the root
            if (data < root.key) {
                root = root.left;
            } else if (data > root.key) {
                root = root.right;
            }
        }
        deleteNode(root, parent);
    }

    public boolean deleteNode(Node root, Node parent){
        //case 1 leaf node
        if(root.left == null && root.right == null){
            if(root.key < parent.key){
                parent.left = null; // parent's left node will now be null
            }
            else{
                parent.right = null; // parent's right node will now be null
            }
            return true;
        }

        //case 2 where node has 1 child
        else if(root.left == null){ // root has only right child
            if(root.key < parent.key){
                parent.left = root.right; // parent's left node becomes the root's right node
            }
            else{
                parent.right = root.right; // parents right node becomes the root's right node
            }
            root.right = null; // the right node will now be null
            return true;
        }

        else if(root.right == null){ // if the root only has a left node
            if(root.key < parent.key){
                parent.left = root.left;
            }
            else{
                parent.right = root.left;
            }
            root.left = null;
            return true;
        }

        // case 3 where node has 2 children
        Node nodeTemp = findMin(root.right); // find the minimum of the root's right subtree
        root.key = nodeTemp.key; // duplicate the min value to the root's value
        deleteNode(nodeTemp, root.right);  // delete the dublicate value in the right subtree
        return true;
    }

    public Node findMin(Node root){
        while(root.left != null){ // if the root has a left node keep traversing, else return
            root = root.left;
        }
        return root;
    }

    public int Search(Node node, Node root) {
        if (node.key == root.key) {
            return (node.key);
        } else if (node.key < root.key) {
            if (root.left != null) {
                return Search(node, root.left);
            }
        } else if (root.right != null) {
            return Search(node, root.right);
        }
        return 0;
    }


    public void inOrderTrans(Node root) {
        if (root != null) {
            if (root.left != null) {
                inOrderTrans(root.left);
            }
            System.out.println(root.key + " " + root.count + "\n");
            if (root.right != null) {
                inOrderTrans(root.right);
            }
        }
    }

    public void preOrderTrans(Node root) {
        if (root != null) {
            System.out.println(root.key + " " + root.count + "\n");
            if (root.left != null) {
                preOrderTrans(root.left);
            }
            if (root.right != null) {
                preOrderTrans(root.right);
            }
        }
    }

    public void postOrderTrans(Node root) {
        if (root != null) {
            if (root.left != null) {
                preOrderTrans(root.left);
            }
            if (root.right != null) {
                preOrderTrans(root.right);
            }
            System.out.println(root.key + " " + root.count + "\n");
        }
    }
}