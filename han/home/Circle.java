package han.home;
public class Circle extends Type {
    // 圆的构造方法：为perimeter和area赋值
    static final Double PI = 3.14;
    private double perimeter;  //周长
    private double area;       //面积
    Circle(double r){
        // 如果半径大于等于0，再继续执行
        if(r >= 0){
            this.perimeter = 2*PI*r;
            this.area = PI*r*r;
        }else{
            System.out.println("半径必须非负！");
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
