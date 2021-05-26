package Collections_HSP.Map.Hashtable.source;

import java.util.Hashtable;

/**
 * Hashtable底层为Hashtable$Entry[11]数组，初始化为11
 * 
 * 扩容机制
 *      if (count >= threshold) {  thredshold = 8
            // Rehash the table if the threshold is exceeded
            rehash();
        int newCapacity = (oldCapacity << 1) + 1; //扩容两倍+1
        加载因子0.75 11:8,23:17
 */

@SuppressWarnings("all")
public class HashtableSource {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        for(int i=0;i<17;i++){
            hashtable.put(i,1);
        }
        hashtable.put(17,1);
    }
}
