# Java Lambda 表达式笔记

Lambda 表达式是 Java 8 引入的一种简化写法，主要用来简化匿名内部类。

它常用于：

- 实现函数式接口
- 创建线程任务
- 集合遍历
- 集合排序
- Stream 流操作

## 1. 基本格式

Lambda 的基本格式：

```java
(参数列表) -> {
    方法体;
}
```

例如：

```java
() -> {
    System.out.println("Hello Lambda");
}
```

可以理解为：

```java
参数 -> 要执行的代码
```

## 2. Lambda 必须配合函数式接口使用

Lambda 不能单独存在，它必须赋值给一个函数式接口。

函数式接口：只有一个抽象方法的接口。

```java
interface MyInterface {
    void show();
}
```

使用匿名内部类：

```java
MyInterface m = new MyInterface() {
    @Override
    public void show() {
        System.out.println("匿名内部类");
    }
};
```

使用 Lambda：

```java
MyInterface m = () -> {
    System.out.println("Lambda 表达式");
};
```

调用：

```java
m.show();
```

## 3. 无参数、无返回值

```java
interface Study {
    void learn();
}

public class Test {
    public static void main(String[] args) {
        Study study = () -> {
            System.out.println("正在学习 Java");
        };

        study.learn();
    }
}
```

如果方法体只有一行代码，可以省略大括号：

```java
Study study = () -> System.out.println("正在学习 Java");
```

## 4. 有参数、无返回值

```java
interface Printer {
    void print(String message);
}

public class Test {
    public static void main(String[] args) {
        Printer printer = (String message) -> {
            System.out.println(message);
        };

        printer.print("Hello");
    }
}
```

参数类型可以省略，因为编译器可以自动推断：

```java
Printer printer = message -> System.out.println(message);
```

注意：如果只有一个参数，参数的小括号也可以省略。

## 5. 有参数、有返回值

```java
interface Calculator {
    int add(int a, int b);
}

public class Test {
    public static void main(String[] args) {
        Calculator calculator = (int a, int b) -> {
            return a + b;
        };

        System.out.println(calculator.add(3, 5));
    }
}
```

可以简化为：

```java
Calculator calculator = (a, b) -> a + b;
```

如果方法体只有一行，并且这一行就是返回值，可以省略 `{}` 和 `return`。

## 6. 用 Lambda 创建线程

匿名内部类写法：

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("线程运行");
    }
}).start();
```

Lambda 写法：

```java
new Thread(() -> System.out.println("线程运行")).start();
```

原因：

`Runnable` 是函数式接口，它只有一个抽象方法 `run()`。

## 7. 用 Lambda 遍历集合

```java
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("MySQL");
        list.add("Spring");

        list.forEach(s -> System.out.println(s));
    }
}
```

也可以使用方法引用：

```java
list.forEach(System.out::println);
```

## 8. 用 Lambda 排序

```java
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);

        Collections.sort(list, (a, b) -> a - b);

        System.out.println(list);
    }
}
```

升序：

```java
(a, b) -> a - b
```

降序：

```java
(a, b) -> b - a
```

更推荐的写法：

```java
Collections.sort(list, (a, b) -> Integer.compare(a, b));
```

## 9. Lambda 的省略规则

Lambda 表达式可以省略一些内容：

| 情况 | 可以省略 |
| --- | --- |
| 参数类型可以推断 | 省略参数类型 |
| 只有一个参数 | 省略参数小括号 |
| 方法体只有一行 | 省略大括号 |
| 一行代码直接返回结果 | 省略 `return` |

完整写法：

```java
(int a, int b) -> {
    return a + b;
}
```

简化写法：

```java
(a, b) -> a + b
```

## 10. Lambda 和匿名内部类的区别

| 对比点 | 匿名内部类 | Lambda 表达式 |
| --- | --- | --- |
| 写法 | 比较长 | 更简洁 |
| 是否有类 | 会生成一个匿名内部类 | 更像函数式写法 |
| 使用条件 | 可以继承类或实现接口 | 只能用于函数式接口 |
| 常见场景 | 复杂临时实现 | 简单行为传递 |

Lambda 不能完全替代匿名内部类。

如果要继承一个普通类，或者接口里有多个抽象方法，就不能使用 Lambda。

## 速记

- Lambda 是匿名内部类的简化写法。
- Lambda 只能用于函数式接口。
- 函数式接口只有一个抽象方法。
- 左边写参数，右边写方法体。
- 一行代码时，可以省略 `{}`、`;` 和 `return`。

## 小结

看到这种匿名内部类：

```java
new 接口名() {
    @Override
    public 返回值类型 方法名(参数) {
        方法体;
    }
}
```

如果这个接口只有一个抽象方法，就可以考虑改成 Lambda：

```java
(参数) -> 方法体
```
