package exceptions.finale;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws Exception{
        Exception origin = null;
        try {
            Integer.parseInt("abc");            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("catched");
            origin = e;
            throw e;
            
        }finally{
            System.out.println("finally");
            Exception e = new IllegalArgumentException();
            if(origin != null){
                e.addSuppressed(origin);
            }
            throw e;
        }

       
        
    }
   
}
