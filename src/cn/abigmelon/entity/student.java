package cn.abigmelon.entity;

//Object->Person->student

public class student extends Person implements Study1, Study2, Cloneable{
    private int id;
    private String name;
    private int age;

    @Override
    public void study() {
        System.out.println("study");
    }

    @Override
    public void work(){
        System.out.println("work");
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
