package uvg;

import org.junit.Test;

import uvg.BST.Node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BTStest<E> {
     @Test
     public void addNodeTest() {
          BST<Integer> bst = new BST<>();
          BST<Integer>.Node node = bst.new Node(5);

          BST<Integer>.Node leftChild = node.addNode(2);
          BST<Integer>.Node rightChild = node.addNode(7);

          assertEquals(2, (int) leftChild.value);
          assertEquals(7, (int) rightChild.value);
          assertEquals(5, (int) rightChild.parent.value);
     }

     @Test
     public void printSubTreeTest() {
          BST<Integer> bst = new BST<>();
          BST<Integer>.Node node = bst.new Node(5);

          BST<Integer>.Node leftChild = node.addNode(2);
          BST<Integer>.Node rightChild = node.addNode(7);

          node.leftChild = leftChild;
          node.rightChild = rightChild;
          leftChild.parent = node;
          rightChild.parent = node;

          String result = new BST<Integer>().vPrintSubTree(node, 0);

          assertEquals("->5\n ->2\n\n\n ->7\n", result);

     }
}
