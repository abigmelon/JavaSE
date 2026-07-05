# Java 内部类笔记

Java 中的内部类，也叫嵌套类，指的是定义在另一个类内部的类。

常见类型有四种：

| 类型 | 定义位置 | 是否有名字 | 是否需要外部类对象 | 典型用途 |
| --- | --- | --- | --- | --- |
| 成员内部类 | 外部类的成员位置 | 有 | 需要 | 和外部类对象关系很紧密 |
| 静态内部类 | 外部类中，用 `static` 修饰 | 有 | 不需要 | 只是逻辑上归属于外部类 |
| 局部内部类 | 方法、构造器、代码块中 | 有 | 通常需要 | 只在某个方法内部使用 |
| 匿名内部类 | 表达式中 | 没有 | 通常需要 | 临时实现接口或继承类 |

## 1. 成员内部类

成员内部类定义在外部类的成员位置，和成员变量、成员方法同级。

```java
class Outer {
    private int num = 10;

    class Inner {
        void show() {
            System.out.println(num);
        }
    }
}
```

特点：

- 可以直接访问外部类的成员，包括 `private` 成员。
- 它依赖某个具体的外部类对象。
- 创建成员内部类对象时，通常要先创建外部类对象。

创建方式：

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
```

适合场景：

- 内部类对象必须依附于外部类对象存在。
- 内部类经常需要访问外部类的实例变量或实例方法。

## 2. 静态内部类

静态内部类是在外部类中使用 `static` 修饰的内部类。

```java
class Outer {
    private static int count = 100;

    static class Inner {
        void show() {
            System.out.println(count);
        }
    }
}
```

特点：

- 不依赖外部类对象。
- 可以直接访问外部类的静态成员。
- 不能直接访问外部类的非静态成员，如果要访问，需要创建外部类对象。

创建方式：

```java
Outer.Inner inner = new Outer.Inner();
```

适合场景：

- 这个类只是逻辑上属于外部类。
- 它不需要使用外部类对象中的普通成员变量。

## 3. 局部内部类

局部内部类定义在方法、构造器或代码块内部。

```java
class Outer {
    void method() {
        class Inner {
            void show() {
                System.out.println("局部内部类");
            }
        }

        Inner inner = new Inner();
        inner.show();
    }
}
```

特点：

- 只能在定义它的方法或代码块内部使用。
- 可以访问外部类的成员。
- 可以访问方法中的局部变量，但这个局部变量必须是 `final` 或事实上的 `final`。

事实上的 `final` 是指变量虽然没有写 `final`，但赋值后没有再被修改。

```java
void method() {
    int x = 10;

    class Inner {
        void show() {
            System.out.println(x);
        }
    }

    // x = 20; // 如果这样修改，内部类中再访问 x 就会报错
}
```

适合场景：

- 某个类只在一个方法内部使用。
- 不希望这个辅助类暴露到方法外面。

## 4. 匿名内部类

匿名内部类没有类名，通常用于临时实现接口或继承类。

```java
interface Animal {
    void eat();
}

class Test {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("吃东西");
            }
        };

        animal.eat();
    }
}
```

特点：

- 没有类名。
- 定义类的同时创建对象。
- 通常只使用一次。
- 常见于接口回调、事件监听、线程任务、排序规则等场景。

线程例子：

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("线程运行");
    }
}).start();
```

如果接口是函数式接口，可以用 Lambda 表达式简化：

```java
new Thread(() -> System.out.println("线程运行")).start();
```

## 成员内部类和静态内部类的核心区别

最容易混的是成员内部类和静态内部类。

| 对比点 | 成员内部类 | 静态内部类 |
| --- | --- | --- |
| 是否有 `static` | 没有 | 有 |
| 是否依赖外部类对象 | 依赖 | 不依赖 |
| 创建方式 | `outer.new Inner()` | `new Outer.Inner()` |
| 能否直接访问外部类实例成员 | 可以 | 不可以 |
| 常见用途 | 和某个外部类对象绑定 | 只是为了分类和封装 |

## 速记

- 成员内部类：属于对象，依赖外部类对象。
- 静态内部类：属于类，不依赖外部类对象。
- 局部内部类：定义在方法里，只能在方法里用。
- 匿名内部类：没有名字，临时用一次。

## 小结

如果内部类需要访问外部类对象的普通成员，优先考虑成员内部类。

如果内部类只是为了放在外部类下面进行组织，并不依赖外部类对象，优先考虑静态内部类。

如果类只在某个方法中使用，可以考虑局部内部类。

如果只是临时实现一个接口或继承一个类，可以使用匿名内部类；如果能用 Lambda，代码通常会更简洁。
