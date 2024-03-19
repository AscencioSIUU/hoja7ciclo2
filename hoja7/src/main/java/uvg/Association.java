package uvg;

public class Association<K extends Comparable<K>, T> implements Comparable<Association<K, T>> {
     public K key;
     public T value;

     public Association(K key, T value) {
          this.key = key;
          this.value = value;
     }

     public int compareTo(Association<K, T> other) {
          return this.key.compareTo(other.key);
     }

     public String toString() {
          return key.toString() + ":" + value.toString();
     }

     public T getValue() {
          return value;
     }
     
     public K getKey() {
          return key;
     }
}
