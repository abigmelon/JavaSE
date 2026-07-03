package cn.abigmelon.entity;

public class Person implements Cloneable{
    public String name = "melon";
    protected int age = 18;     //protected可以被子类使用
    public String gender = "male";
    public static String info;     //所有的成员操作的是同一个变量属性 变成了类的属

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

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof Person person){
            return this.name.equals(person.name) && this.age == person.age && this.gender.equals(person.gender);
        }
        return false;
    }       //方法的重写

    @Override
    public String toString(){
        return "Person[name="+name+", age="+age+", gender="+gender;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
