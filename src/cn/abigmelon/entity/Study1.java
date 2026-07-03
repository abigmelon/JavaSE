package cn.abigmelon.entity;

public interface Study1 {
    public void study();

    default void test001(){
        System.out.println("test001");
        inner();
    }
    //接口中可以存在方法的默认实现，还可以写静态变量和静态方法
    //但是静态方法必须被default调用
    static void inner(){
        System.out.println("inner");
    }

    int a = 10;//直接就是final的
}
