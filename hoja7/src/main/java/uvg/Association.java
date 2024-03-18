package uvg;

public class Association<K extends Comparable<K>, T> implements Comparable<Association<K, T>> {
     public K key;
     public T data;
     public Association(K cKey, T cData){
          this.key = cKey;
          this.data = cData;
     }
     public int compareTo(Association<K, T> other){
          return this.key.compareTo(other.key);
     }
     public String toString(){
          return key.toString() + ":" + data.toString();
     }    
}
