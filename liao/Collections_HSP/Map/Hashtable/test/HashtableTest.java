package Collections_HSP.Map.Hashtable.test;

import java.util.Hashtable;


@SuppressWarnings("all")
public class HashtableTest {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        try {
            hashtable.put("1","a");
            hashtable.put("1","b");
            hashtable.put(null,"1");
            
        
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            try {
                hashtable.put("1",null);
            } catch (Exception e1) {
                //TODO: handle exception
                e1.printStackTrace();
            }finally{
                hashtable.put("1","a");
            }

        }finally{
            System.out.println(hashtable);
        }

    }
}
