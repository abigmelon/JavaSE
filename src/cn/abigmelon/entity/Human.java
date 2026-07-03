package cn.abigmelon.entity;

public class Human {
    private String name;
    private int age;
    private String gender;
    //为了防止对象被外部乱改，需要用到类的封装

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //setter

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    //getter
    //右键也可以生成构造方法
    //甚至可以把构造方法也改成私有的，通过内部方法来构造对象

    public static Human newInstance(){
        Human h = new Human();
        return h;
    }

    private static Person Instance;

    public static Person getInstance(){
        if(Instance == null){
            Instance = new Person();
        }
        return Instance;
    }
}
