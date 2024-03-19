package uvg;

import java.util.*;

public class BST<E extends Comparable<E>> {
     public class Node {
          public E value;
          public Node leftChild = null;
          public Node rightChild = null;
          public Node parent = null;

          public Node(E cValue) {
               this.value = cValue;
               this.leftChild = null;
               this.rightChild = null;
               this.parent = null;
          }

          public Node addNode(E newVal) {
               int compCase = newVal.compareTo(value);
               if (compCase < 0) {
                    if (leftChild == null) {
                         leftChild = new Node(newVal);
                         leftChild.parent = this;
                         return leftChild;
                    } else {
                         return leftChild.addNode(newVal);
                    }
               } else if (compCase > 0) {
                    if (rightChild == null) {
                         rightChild = new Node(newVal);
                         rightChild.parent = this;
                         return rightChild;
                    } else {
                         return rightChild.addNode(newVal);
                    }
               } else {
                    value = newVal;
                    return this;
               }
          }
     }

     private Node root;

     public BST() {
          this.root = null;
     }

     public void add(E newVal) {
          root = addNode(root, newVal);
     }

     private Node addNode(Node current, E newVal) {
          if (current == null) {
               return new Node(newVal);
          }

          int compCase = newVal.compareTo(current.value);
          if (compCase < 0) {
               current.leftChild = addNode(current.leftChild, newVal);
          } else if (compCase > 0) {
               current.rightChild = addNode(current.rightChild, newVal);
          } else {
               current.value = newVal;
          }

          return current;
     }

     public int height() {
          return calculateHeight(root);
     }

     private int calculateHeight(Node current) {
          if (current == null) {
               return -1;
          }
          int leftHeight = calculateHeight(current.leftChild);
          int rightHeight = calculateHeight(current.rightChild);
          return Math.max(leftHeight, rightHeight) + 1;
     }

     public E get(E key) {
          Node node = getNode(root, key);
          return node != null ? node.value : null;
     }

     private Node getNode(Node current, E key) {
          if (current == null) {
               return null;
          }

          int compCase = key.compareTo(current.value);
          if (compCase == 0) {
               return current;
          } else if (compCase < 0) {
               return getNode(current.leftChild, key);
          } else {
               return getNode(current.rightChild, key);
          }
     }
     
     public String toString() {
          return vPrintSubTree(root, 0);
     }

     public String vPrintSubTree(Node x, int depth) {
          StringBuilder txt = new StringBuilder();
          txt.append(" ".repeat(depth))
                    .append("->").append(x.value.toString()).append("\n");
          if (x.leftChild != null) {
               txt.append(vPrintSubTree(x.leftChild, depth + 1)).append("\n");
          }
          if (x.rightChild != null) {
               txt.append("\n").append(vPrintSubTree(x.rightChild, depth + 1));
          }
          return txt.toString();
     }


}