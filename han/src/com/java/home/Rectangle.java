package com.java.home;

public class Rectangle extends Type {

    private double perimeter;  //周长
    private double area;       //面积
    Rectangle(double a, double b){
        // 如果半径大于等于0，再继续执行
        if(a >= 0 && b >=0){
            this.perimeter = 2*(a + b);
            this.area = a * b;
        }else{
            System.out.println("边长必须非负！");
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
