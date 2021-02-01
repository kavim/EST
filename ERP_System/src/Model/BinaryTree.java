package Model;

public class BinaryTree {

    Nodo root;

    public void addNode(int product_id, Product product) {

        // Create a new Node and initialize it

        Nodo newNode = new Nodo(product_id, product);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            Nodo focusNode = root;

            // Future parent for our new Node

            Nodo parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (product_id < focusNode.product_id) {

                    // Switch focus to the left child

                    focusNode = focusNode.left;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.left = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.right;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.right = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    public Nodo findNode(int key) {

        Nodo focusNode = root;

        while (focusNode.product_id != key) {
            if (key < focusNode.product_id) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }
}
