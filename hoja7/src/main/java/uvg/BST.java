package uvg;

public class BST<E extends Comparable<E>> {
     public class Node <E extends Comparable<E>>{
          public E value;
          public Node leftChild = null;
          public Node rightChild = null;
          public Node parent = null;
          public Node(E cValue){
               this.value = cValue;
          }
          public Node(E cValue, Node<E> parent){
               this.value = cValue;
               this.parent = parent;
          }

          public String toString(){
               return value.toString();
          }
          public Node<E> addNode(E newVal){
               int compCase = newVal.compareTo(value);
               if(compCase < 0){
                    if (leftChild == null){
                         return leftChild = new Node(newVal, this);
                    } else {
                         return leftChild.addNode(newVal);
                    }
               } 
               if(compCase == 0){
                    value = newVal;
                    return this;
               }
               if (rightChild == null){
                    return rightChild = new Node(newVal, this);
               }
               return rightChild.addNode(newVal);
          }
          public int nodeHeight(){
               int currHeight = -1;
               if (this.leftChild != null){
                   currHeight = this.leftChild.nodeHeight();
               }
               if (this.rightChild != null){
                   int rightHeight = this.rightChild.nodeHeight();
                   if (rightHeight > currHeight){
                       currHeight = rightHeight;
                   }
               }
               return currHeight + 1;
          }

          public int nodeDepth(){
               if(this.parent == null){
                    return 0;
               }
               return 1 + this.parent.nodeDepth();
          }

          public Node<E> getNode(E key){
               if(this.value.compareTo(key) == 0){
                    return this;
               }
               return null;
          }
     }

     private Node<E> root;

     public BST(){
          this.root = null;
     }
     public E add(E newVal){
          if (root == null){
              root = new Node<E>(newVal);
              return root.value;
          }
          return (E) root.addNode(newVal).value;
      }
  
      public int height(){
          if (this.root  == null){
              return -1;
          }
          return this.root.nodeHeight();
      }
  
      public E get(E key){
  
          return null;
      }
  
      public String toString() {
          if (this.root != null) {
              return vPrintSubTree(this.root, 1);
          }
          return "X";
      }
  
      public String vPrintSubTree(Node<E> x, int depth){
          String txt = "";
          txt = " ".repeat(depth);
          txt += "->" + x.value.toString() + "\n";
          if (x.leftChild!=null){
              txt = vPrintSubTree(x.leftChild, depth + 1) + "\n" + txt;
          }
          if (x.rightChild!=null){
              txt = txt + "\n" + vPrintSubTree(x.rightChild, depth + 1);
          }
          return txt;
      }  
}