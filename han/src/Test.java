public class Test {
    public static void main(String args[]){
        try{
            Circle c1 = new Circle(-2);
            System.out.println("c1的面积为："+c1.getArea());
            System.out.println("c1的周长为："+c1.getPerimeter());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        try {
            Triangle t2 = new Triangle(1,2,4);
            System.out.println("t1的面积为："+t2.getArea());
            System.out.println("t1的周长为："+t2.getPerimeter());
        } catch (IllegalArgumentException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        try{
            Rectangle r1 = new Rectangle(1,2);
            System.out.println("r1的面积为："+r1.getArea());
            System.out.println("r1的周长为："+r1.getPerimeter());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
