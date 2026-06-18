public class Main {
    public static void main(String[] args) {
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
        final int b = 10;       //final表示这是一个常量
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

        System.out.println(p4.age);     //默认为0

        p4.hello();     //方法的调用
        int sum = p4.sum(1, 2);
        System.out.println(sum);
    }
}