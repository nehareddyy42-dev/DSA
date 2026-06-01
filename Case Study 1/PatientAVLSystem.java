class AVLNode {

    int key;
    int height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class PatientAVLSystem {

    static int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    static int getBalance(AVLNode node) {
        return node == null ? 0 :
                height(node.left) - height(node.right);
    }

    static AVLNode rotateRight(AVLNode y) {

        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height =
                Math.max(height(y.left),
                        height(y.right)) + 1;

        x.height =
                Math.max(height(x.left),
                        height(x.right)) + 1;

        return x;
    }

    static AVLNode rotateLeft(AVLNode x) {

        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height =
                Math.max(height(x.left),
                        height(x.right)) + 1;

        y.height =
                Math.max(height(y.left),
                        height(y.right)) + 1;

        return y;
    }

    static AVLNode insert(AVLNode node,
                          int key) {

        if(node == null)
            return new AVLNode(key);

        if(key < node.key)
            node.left =
                    insert(node.left,key);

        else if(key > node.key)
            node.right =
                    insert(node.right,key);

        else
            return node;

        node.height =
                Math.max(height(node.left),
                        height(node.right)) + 1;

        int balance =
                getBalance(node);

        if(balance > 1 &&
                key < node.left.key)
            return rotateRight(node);

        if(balance < -1 &&
                key > node.right.key)
            return rotateLeft(node);

        if(balance > 1 &&
                key > node.left.key) {

            node.left =
                    rotateLeft(node.left);

            return rotateRight(node);
        }

        if(balance < -1 &&
                key < node.right.key) {

            node.right =
                    rotateRight(node.right);

            return rotateLeft(node);
        }

        return node;
    }

    static void inorder(AVLNode root) {

        if(root != null) {

            inorder(root.left);

            System.out.print(
                    root.key + " ");

            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        int ids[] = {
                20,30,35,40,45,50,
                60,65,70,75,80,85,90
        };

        AVLNode root = null;

        for(int id : ids)
            root = insert(root,id);

        System.out.println(
                "Patient IDs:");

        inorder(root);

        System.out.println(
                "\nAVL Tree Constructed Successfully");
    }
}