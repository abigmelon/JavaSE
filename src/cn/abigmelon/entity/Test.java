package cn.abigmelon.entity;

public class Test {
    private final String name;

    public Test(String name){
        this.name = name;
    }
    public class Inner {

        String name;
        public void test(String name){
            System.out.println("方法参数的name = "+name);    //依然是就近原则，最近的是参数，那就是参数了
            System.out.println("成员内部类的name = "+this.name);   //在内部类中使用this关键字，只能表示内部类对象
            System.out.println("成员内部类的name = "+Test.this.name);
            //如果需要指定为外部的对象，那么需要在前面添加外部类型名称
        }
    }
}
