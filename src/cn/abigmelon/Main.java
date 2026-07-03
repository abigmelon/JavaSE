package cn.abigmelon;

import cn.abigmelon.entity.*;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello World!");     //这是注释
        System.out.println("im abigmelon");
        /*
        这里面的注释
        不管是多少行
        都可以
         */
        int a = 10;
        a = a + 1;
        System.out.println(a);
        System.out.println(111);
        final int b = 10;       //final表示这是一个常量，后续不能被更改
        //整数类型包括byte，short，int，long
        long c = 9815526629959L;
        int d = 1_000_000;
        System.out.println(0xA);
        System.out.println(012);    //0x开头是16进制，0开头是8进制
        double e = 1.2, f = 10.5;
        float g = 1.2f;
        char h = 65;
        System.out.println(h);      //这里打印的是ASCII码对应的字符
        char i = 'A';
        System.out.println(i);
        int j = '瓜';
        System.out.println(j);      //直接转换为对应的编码
        String str = "一只大西瓜";
        boolean k = true;
        System.out.println(k);
        var l = 10;     //自动推断变量命名
        int m;
        int n = m = 999;        //从右往左结算
        String str1 = "一只" + "大西瓜" + true + 1.5;     //加号可以拼接字符串以及其他类型
        System.out.println(str);
        int score = 100;
        char grade = switch (score) {
            case 100 -> 'A';
            case 90 -> 'B';
            case 80 -> 'C';
            case 60 -> 'D';
            default -> 'E';
        };
        System.out.println(grade);
        var res = switch (score) {
            case 100 -> 'A';
            case 90 -> 'B';
            case 80 -> 'C';
            case 60 -> {
                System.out.println("我是额外操作");
                yield 'D';      //在最后使用yield关键字来指定关键结果
            }
            default -> 'E';
        };
        System.out.println(res);

        new Person();
        Person p1 = new Person();        //p类似于一个快捷方式
        Person p2 = new Person();
        Person p3 = p1;
        System.out.println(p1 == p2);
        System.out.println(p1 == p3);

        Person p4 = new Person();
        p4.name = "melon";
        System.out.println(p4.name);

        p4.hello();     //方法的调用
        int sum = p4.sum(1, 2);
        System.out.println(sum);

        p4.setName("abc");
        System.out.println(p4.name);

        System.out.println(p1.sum(10, 20));     //可以通过后面加.sout快速写出输出
        System.out.println(p1.sum(1.2, 1.3));

        Person p = new Person();
        System.out.println(p.name);     //手动定义的构造方法

        Person.info = "hello";
        System.out.println(p2.info);        //指向的是同一个东西

        //访问权限控制

        Person p5 = new Person();
        p5.hello();

        Human h1 = new Human();
        h1.setAge(18);

        student stu1 = new student();
        stu1.hello();

        teacher tea1 = new teacher();
        tea1.hello();
        tea1.teach();

        Person p6 = new Person();
        student stu2 = new student();

        final String string = p6.toString();
        System.out.println(string);

        Person p01 = new Person("melon", 18, "male");
        Person p02 = new Person("melon", 18, "male");
        System.out.println(p01 == p02);     //比较的是对象（壳子）
        System.out.println(p02.equals(p01));        //比较的是内容

        System.out.println(p01);

        testClone();

        stu1.setStatus(Status.RUNNING);
        System.out.println(stu1.getStatus());

        TestData order1 = new TestData(1, "milktea", "111");
        System.out.println(order1);     //此处已经自动重写了
        System.out.println(order1.id());
    }

    public static void testClone() throws CloneNotSupportedException {  //这里向上抛出一下异常，还没学异常，所以说照着写就行了
        Person p001 = new Person("小明", 18, "男");
        Person clone = (Person) p001.clone();   //调用clone方法，得到一个克隆的对象
        System.out.println(p001);
        System.out.println(clone);
        System.out.println(p001 == clone);//壳子
        System.out.println(p001.equals(clone));//内容
    }

    private static void test(Person person) {
        if(person instanceof student student) {  //直接在instanceof后写变量名称，作为判断成功之后转换的此类型变量名称
            student.hello();
        }
    }  //有点类似于typedef的写法，直接强制类型转换了
}

//public class Object {
//
//    private static native void registerNatives();   //标记为native的方法是本地方法，底层是由C++实现的
//    static {
//        registerNatives();   //这个类在初始化时会对类中其他本地方法进行注册，本地方法不是我们SE中需要学习的内容，我们会在JVM篇视频教程中进行介绍
//    }
//
//    //获取当前的类型Class对象，这个我们会在最后一章的反射中进行讲解，目前暂时不会用到
//    public final native Class<?> getClass();
//
//    //获取对象的哈希值，我们会在第五章集合类中使用到，目前各位小伙伴就暂时理解为会返回对象存放的内存地址
//    public native int hashCode();
//
//    //判断当前对象和给定对象是否相等，默认实现是直接用等号判断，也就是直接判断是否为同一个对象
//    public boolean equals(Object obj) {
//        return (this == obj);
//    }
//
//    //克隆当前对象，可以将复制一个完全一样的对象出来，包括对象的各个属性
//    protected native Object clone() throws CloneNotSupportedException;
//
//    //将当前对象转换为String的形式，默认情况下格式为 完整类名@十六进制哈希值
//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }
//
//    //唤醒一个等待当前对象锁的线程，有关锁的内容，我们会在第六章多线程部分中讲解，目前暂时不会用到
//    public final native void notify();
//
//    //唤醒所有等待当前对象锁的线程，同上
//    public final native void notifyAll();
//
//    //使得持有当前对象锁的线程进入等待状态，同上
//    public final native void wait(long timeout) throws InterruptedException;
//
//    //同上
//    public final void wait(long timeout, int nanos) throws InterruptedException {
//        ...
//    }
//
//    //同上
//    public final void wait() throws InterruptedException {
//        ...
//    }
//
//    //当对象被判定为已经不再使用的“垃圾”时，在回收之前，会由JVM来调用一次此方法进行资源释放之类的操作，这同样不是SE中需要学习的内容，这个方法我们会在JVM篇视频教程中详细介绍，目前暂时不会用到
//    protected void finalize() throws Throwable { }
//}

//方法重载默认找最接近的