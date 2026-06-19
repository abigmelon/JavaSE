package cn.abigmelon.entity;

public class Person {
    public String name = "melon";
    public int age = 18;
    public String gender = "male";
    public static String info;     //所有的成员操作的是同一个变量属性 变成了类的属性

    public void hello(){
        System.out.println("My name is "+name);
    }

    public int sum(int a, int b){
        return a+b;
    }

    public double sum(double a, double b){
        return a+b;
    }       //方法的重载

    public void setName(String name){
        this.name=name;     //this表示这个对象
    }

    public String getGender() {
        return gender;
    }

    public Person(int age) {
        name = "melon";
        this.age = age;
        gender = "male";
    }       //也可以为构造方法设定参数，现在手动定义了一个有参构造

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(){}       //构造方法可以有很多个，反正可以重载

    public Person(int age, String gender){
        this(null, age, gender);        //还可以利用别人来完成初始化
    }

    public static void setInfo(String info){
        Person.info = info;
        System.out.println(info);
    }       //静态方法同样是属于类的，静态方法中无法获取成员的值，但是可以获得静态的值
}
