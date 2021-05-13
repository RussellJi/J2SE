package src.com.hidee;
public class Main {
    public static void main(String[] args){
        //保留案发现场
        try {
            process1();
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
    static void process1(){
        try {
            process2();
        } catch (NullPointerException e) {
            //TODO: handle exception
            // throw new IllegalArgumentException();
            // 保留案发现场
            throw new IllegalArgumentException(e);

        }
    }

    static void process2(){
        throw new NullPointerException();
    }
}
