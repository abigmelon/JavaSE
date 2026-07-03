package cn.abigmelon.entity;

public final class teacher extends Person{
    public teacher(){
        super(18);
    }//如果父类存在构造方法

    public void teach(){
        System.out.println("i_study_java");
    }
}       //标记为final之后这个类不允许被继承
