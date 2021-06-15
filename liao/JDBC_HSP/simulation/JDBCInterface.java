package JDBC_HSP.simulation;


//定义JDBC接口，各数据库厂商实现该接口，面向接口编程实现与数据库的交互
interface JDBCInterface{
    void connection();
    void crud();
    void close();
}