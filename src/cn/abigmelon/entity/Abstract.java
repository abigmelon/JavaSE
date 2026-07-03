package cn.abigmelon.entity;

public abstract class Abstract {   //通过添加abstract关键字，表示这个类是一个抽象类
    protected String name;   //大体内容其实普通类差不多
    protected int age;
    protected String sex;
    protected String profession;

    protected Abstract(String name, int age, String sex, String profession) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.profession = profession;
    }

    public abstract void exam();   //抽象类中可以具有抽象方法，也就是说这个方法只有定义，没有方法体
    //而具体的实现，需要由子类来完成，而且如果是子类，必须要实现抽象类中所有抽象方法

    public void test(){
        System.out.println("test");
    }//也可以是不抽象的方法
}

//抽象类一般只用做继承，抽象的子类也是抽象
//抽象当然不能private，如果private了子类怎么定义呢
