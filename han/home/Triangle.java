package han.home;
import java.lang.Math;
class Triangle extends Type {

    static final Double PI = 3.14;
    private double perimeter;  //周长
    private double area;       //面积
    Triangle(double a, double b, double c){
        if(a>0 && b>0 && c>0 && (a+b)>c && (a+c)>b && (b+c)>a && Math.abs(a-b)<c && Math.abs(a-c)<b && Math.abs(b-c)<a){
            double p = (a + b + c)/2;
            this.perimeter = 2*p;
            this.area = Math.sqrt(p*(p-a)*(p-c)*(p-b));
        }else{
            System.out.println("边长不符合三角形规定！");
            throw new IllegalArgumentException();
        }
    }
    @Override
    double getPerimeter() {
        // TODO Auto-generated method stub
        return this.perimeter;
    }

    @Override
    double getArea() {
        // TODO Auto-generated method stub
        return this.area;
    }
    
}
