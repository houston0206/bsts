package edu.ttap.bsts;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading

    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        /**
         * @param value the value of the node
         * @param left  the left child of the node
         * @param right the right child of the node
         */
        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        public Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * @param node the root of the tree
     * @return the number of elements in the specified tree
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in this tree
     */
    public int size() {
        return sizeH(root);
    }

    ///// Part 1: Insertion

    /**
     * @param node the binary search tree
     * @param v    the value to insert
     */
    private Node<T> insertH(Node<T> node, T v) {
        if (node == null) {
            return new Node<>(v);
        } else {
            if (v.compareTo(node.value) < 0) {
                node.left = insertH(node.left, v);
            } else {
                node.right = insertH(node.right, v);
            }
            return node;
        }
    }

    /**
     * Inserts the given value into this binary search tree.
     * 
     * @param v the value to insert
     */
    public void insert(T v) {
        root = insertH(root, v);
    }

    ///// Part 2: Contains
    
    /**
     * @param node the binary search tree
     * @param v    the value to insert
     */
    private boolean containH(Node<T> node, T v) {
        if (node == null) {
            return false;
        } else {
            if(v.compareTo(node.value) == 0) {
                return true;
            } else if(v.compareTo(node.value) < 0) {
                return containH(node.left, v);
            } else {
                return containH(node.right, v);
            }
        }
    }

    /**
     * Check iff v is contained within the given tree.
     * @param v the value to find
     * @return true iff this tree contains <code>v</code>
     */
    public boolean contains(T v) {
        return containH(root, v);
    }

    ///// Part 3: Ordered Traversals

    /**
     * @param node the binary search tree
     */
    private String toStringH(Node<T> node) {
        if(node == null){
            return "";
        }
        if (toStringH(node.left).isEmpty() && toStringH(node.right).isEmpty()) {
            return node.value.toString();
        } else if (toStringH(node.left).isEmpty()) {
            return node.value + ", " + toStringH(node.right);
        } else if (toStringH(node.right).isEmpty()) {
            return toStringH(node.left) + ", " + node.value;
        } else {
            return toStringH(node.left) + ", " + node.value + ", " + toStringH(node.right);
        } 
    }

    /**
     * Display values in a tree as string.
     * @return the (linearized) string representation of this BST
     */
    @Override
    public String toString() {
        return "[" + toStringH(root) + "]";
    }

    /**
     * @param node the binary search tree
     * @param list the list we record the elements of the tree
     */
    private void toListH(Node<T> node, List<T> list) {
        if(node == null){
            return;
        }
        toListH(node.left, list);
        list.add(node.value);
        toListH(node.right, list);
    }

    /**
     * Display the elements of the tree as a list.
     * @return a list contains the elements of this BST in-order.
     */
    public List<T> toList() {
        List<T> list = new ArrayList();
        toListH(root, list);
        return list;
    }

    ///// Part 4: BST Sorting
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * @param <T> the carrier type of the lists
     * @param lst the list to sort
     * @return a copy of <code>lst</code> but sorted
     * @implSpec <code>sort</code> runs in ___ time if the tree remains balanced.
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> lst) {
        List<T> events = new ArrayList<>();
        int length = lst.size();
        if (length == 0 || length == 1) {
           return events;
        }
        for (int i = 0; i < length; i++) {
            T min = lst.get(i);
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (lst.get(j).compareTo(min) < 0) {
                    min = lst.get(j);
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(lst, i, minIndex);
            }
        }
        return events;
   } 

    ///// Part 5: Deletion

    /*
     * The three cases of deletion are:
     * 1. (TODO: fill me in!)
     * 2. (TODO: fill me in!)
     * 3. (TOOD: fill me in!)
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code>
     * found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        throw new UnsupportedOperationException();
    }
}
