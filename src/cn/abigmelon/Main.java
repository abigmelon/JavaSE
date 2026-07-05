package cn.abigmelon;

import cn.abigmelon.entity.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, TestException {
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

        Integer i01 = Integer.valueOf(666);
        Integer i02 = 666;//自动装箱机制
        int i03 = i02.intValue();
        int i04 = i02;//自动拆箱机制
        int i05 = i01 * i02;
        System.out.println(i05);//自动拆箱成基本类型参与到运算当中
        System.out.println(i01 == i02);
        System.out.println(i01.equals(i02));

//        IntegerCache会默认缓存-128~127之间的所有值，将这些值提前做成包装类放在数组中存放，
//        虽然我们目前还没有学习数组，但是各位小伙伴只需要知道，
//        我们如果直接让-128~127之间的值自动装箱为Integer类型的对象，那么始终都会得到同一个对象,
//        这是为了提升效率，因为小的数使用频率非常高，有些时候并不需要创建那么多对象，创建对象越多，内存也会消耗更多。

        Integer i06 = Integer.valueOf("ABC", 16);//字符串和进制
        Integer i07 = Integer.decode("0x3f");
        System.out.println(i06);
        System.out.println(i07);
        System.out.println(Integer.toHexString(i06));//转成16进制

        BigInteger i08 = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(i08);
        BigInteger i09 = i08.pow(100);
        System.out.println(i09);//非常厉害，几乎想算什么都可以
        BigInteger i010 = i08.add(BigInteger.valueOf(1000));//这个不支持自动拆箱和装箱，必须给BigInteger类型

        BigDecimal i011 = BigDecimal.valueOf(10);
        i011 = i011.divide(BigDecimal.valueOf(3), 100, RoundingMode.CEILING);
        //这里的三个参数分别是被除数，精确到小数点之后多少位，舍入模式为向上取整
        System.out.println(i011);

        int[] arr = new int[10];
        Object obj = arr;//既然是类那肯定是向上兼容的
        arr[0] = 1;
        System.out.println(arr.length);

        String[] arr1 = new String[]{"aaa", "bbb"};
        String[] arr2 = arr1.clone();
        System.out.println(Arrays.toString(arr2));
        for (String element: arr2){
            System.out.println(element);
        }//简化的for循环，得到的元素+遍历的数组

        int[][] arr3 = new int[2][10];
        arr3[0][2] = 111;
        for(int[] array: arr3){
            for(int num: array){
                System.out.println(num);
            }
        }

        Person man = new Person();
        man.test("man", "what can i say", "manba out");

        String str01 = "hello ovo";
        String str02 = "hello ovo";
        System.out.println(str01.equals(str02));
        System.out.println(str01.length());
        String str03 = str01.substring(0, 5);//[start,end)的区间
        System.out.println(str03);
        String[] strings = str01.split(" ");//分开
        for(String string04: strings){
            System.out.println(string04);
        }

        char[] charArray = str01.toCharArray();
        for(char character: charArray){
            System.out.println(character);
        }
//        可以用的函数还有很多，列表找一下就行

        StringBuilder builder = new StringBuilder();
        builder.append("aaa");
        builder.append("bbb");
        System.out.println(builder.toString());

        builder.delete(2, 4);//[start, end)区间
        System.out.println(builder.toString());

        String string1 = "   111222   ";
        System.out.println(string1.strip());
        System.out.println(string1.stripLeading());
        System.out.println(string1.stripTrailing());

        String string2 = "  ";
        System.out.println(string2.isBlank());

        String string3 = "abc";
        System.out.println(string3.repeat(5));

        String multiLine = """
                "@#$%^&*()""";
        System.out.println(multiLine);//三引号文本块

        String string4 = "ooo";
        System.out.println(string4.matches("o+"));

        test2(1);
        test2(str1);//类型判断
        String empty = "";
        test2(empty);

        System.out.println(test3(90));

        Test test1 = new Test("hello");
        Test.Inner inner = test1.new Inner();//创建成员内部类比较麻烦
        inner.test("world");

        System.out.println("===== 匿名内部类示例 =====");

        Study1 anonymousStudy = new Study1() {
            @Override
            public void study() {
                System.out.println("我是匿名内部类实现的 study 方法");
            }
        };
        anonymousStudy.study();

        Person anonymousPerson = new Person() {
            @Override
            public void hello() {
                System.out.println("我是匿名内部类重写的 hello 方法");
            }
        };
        anonymousPerson.hello();

        System.out.println("===== Lambda 表达式示例 =====");
        Study1 lambdaStudy = () -> System.out.println("我是 Lambda 实现的 study 方法");
        lambdaStudy.study();

        Consumer<String> printMessage = message -> System.out.println("接收到的消息：" + message);
        printMessage.accept("一个参数、没有返回值的 Lambda");

        BinaryOperator<Integer> add = (left, right) -> left + right;
        System.out.println("10 + 20 = " + add.apply(10, 20));

        jie_kou_1 qiu_he = (a1, b1) -> a1 + b1;
        System.out.println(qiu_he.sum(10, 20));

//        方法 名称 (参数列表) -> {
//            方法体
//        }

        jie_kou_1 qiu_he2 = Integer::sum;//方法引用
        System.out.println(qiu_he2.sum(10, 20));

        div2(10, 1);

        try{
            Object obj1 = null;
            obj1.toString();
        }catch (NullPointerException err){
            System.out.println("异常错误信息：" + err);
        }

        System.out.println("不受影响的代码");

        try{
            test4();
        }catch (StudyException err){
            System.out.println(err);
        }finally {
            System.out.println("不管有没有发生异常都要收尾");
        }

//        try {
//            test();
//        } catch (FileNotFoundException e) {
//            System.out.println("文件没找到");
//        } catch (ClassNotFoundException e) {
//            System.out.println("类没找到");
//        } catch (Exception e) {
//            System.out.println("其他异常");
//        }更推荐像这样写多重异常捕获，不要直接写Exception这个父类，报错信息不是很明确

//        Math.pow(5, 3);
//        Math.abs(-1);
//        Math.max(10, 20);
//        Math.min(10, 20);
//        Math.sqrt(9);
//        Math.sin(Math.PI / 2);
//        Math.cos(Math.PI);
//        Math.tan(Math.PI / 4);
//        Math.asin(1);
//        Math.acos(1);
//        Math.atan(0);
//        Math.ceil(4.5);向上取整
//        Math.floor(4.5);向下取整
//        Math.round(4.5);四舍五入
//        Math.log(Math.E);
        Random random = new Random();
        for (int index = 0; index < 30; index++) {
            System.out.print(random.nextInt(100)+" ");  //nextInt方法可以指定创建0 - x之内的随机数
        }
        System.out.print("\n");
        int[] array = {1, 2, 3, 4, 5, 9, 8, 7, 6};
        Arrays.sort(array, 0, 5);//升序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[10];
        Arrays.fill(array2, 1);

        int[] array3 = Arrays.copyOf(array2, 10);
        System.out.println(Arrays.toString(array3));

        int[] array4 = new int[10];
        System.arraycopy(array2, 0, array4, 0, 10);
        System.out.println(Arrays.toString(array4));

        int[] array5 = {1, 5, 8, 7, 9, 6, 4, 3, 2};
        Arrays.sort(array5);
        System.out.println(Arrays.binarySearch(array5, 4));//查找有序数组中某个元素的位置

        // ===== java.time 获取当前日期/时间（推荐方式）=====
        LocalDate today = LocalDate.now();              // 2026-07-05
        LocalTime timeNow = LocalTime.now();            // 14:30:25.123
        LocalDateTime dateTime = LocalDateTime.now();   // 2026-07-05T14:30:25.123
        ZonedDateTime zoned = ZonedDateTime.now();      // 带时区
        Instant instant = Instant.now();                // 时间戳（UTC）

        // ===== 获取具体字段 =====
        int year = today.getYear();                     // 2026
        int month = today.getMonthValue();              // 7（1-12，比旧版友好）
        int day = today.getDayOfMonth();                // 5
        int hour = timeNow.getHour();                   // 14
        int minute = timeNow.getMinute();               // 30
        int second = timeNow.getSecond();               // 25
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);

        // ===== 格式化 =====
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = dateTime.format(fmt);        // "2026-07-05 14:30:25"
        System.out.println(formatted);

        // ===== 解析字符串 =====
        LocalDate parsed = LocalDate.parse("2026-07-05");
        LocalDateTime parsed2 = LocalDateTime.parse("2026-07-05 14:30:25", fmt);

        // ===== 时间计算 =====
        LocalDate tomorrow = today.plusDays(1);
        LocalDate lastMonth = today.minusMonths(1);
        long daysBetween = ChronoUnit.DAYS.between(
                LocalDate.of(2026, 1, 1), today
        );
        System.out.println("距年初已过 " + daysBetween + " 天");

        // ===== 时间戳转换 =====
        long epochSecond = instant.getEpochSecond();    // 秒级时间戳
        long epochMilli = instant.toEpochMilli();       // 毫秒时间戳
        Instant fromMilli = Instant.ofEpochMilli(epochMilli);
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

    private static void test2(Object obj){
        String type = switch (obj){
            case String s when s.isEmpty() -> "Empty";//守卫条件
            case String _ -> "String";
            case Integer _ -> "Integer";
            default -> "Other";
        };
        System.out.println(type);
    }

    private static String test3(int score){
        return switch (score) {
            case int c when c >= 90 -> "优秀";   //注意switch是从上往下匹配，大于90要放前面优先匹配
            case int c when c >= 80 -> "良好";   //走到这里一定小于90，再判断是否大于80
            case int c when c >= 60 -> "及格";
            default -> "滚蛋";
        };
    }

    private static int div(int a, int b){
        if(b == 0) throw new StudyException("Divisor cannot be zero");
        return a / b;
    }

    private static int div2(int a, int b) throws TestException {
        if(b == 0) throw new TestException("Divisor cannot be zero");
        return a / b;
    }//非运行时异常，即编译时异常一定要添加方法签名，往上级抛

    private static void test4() {
        throw new StudyException("自定义的异常");
    }
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
