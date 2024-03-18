package uvg;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class BTStest {
     @Test
     public void addNodeTest(){
          BST<Integer>.Node<Integer> node = new BST<Integer>().new Node<>(5);

          BST<Integer>.Node<Integer> leftChild = node.addNode(2);
          BST<Integer>.Node<Integer> rightChild = node.addNode(7);

          assertEquals(2,(int) leftChild.value);
          assertEquals(7, (int) rightChild.value);
          assertEquals(5, rightChild.parent.value);
     }

     @Test
     public void printSubTreeTest(){
          BST<Integer>.Node<Integer> node = new BST<Integer>().new Node<>(5);
          BST<Integer>.Node<Integer> leftChild = node.addNode(2);
          BST<Integer>.Node<Integer> rightChild = node.addNode(7);

          node.leftChild = leftChild;
          node.rightChild = rightChild;
          leftChild.parent = node;
          rightChild.parent = node;

          String result = new BST<Integer>().vPrintSubTree(node, 0);

          assertEquals(" ->2\n ->5\n ->7\n", result);

     }
}
