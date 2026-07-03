package cn.abigmelon.entity;

public class mi_feng_lei{

}

//密封类型有以下要求：
//
//可以基于普通类、抽象类、接口，也可以是继承自其他接抽象类的子类或是实现其他接口的类等。
//必须有子类继承，且不能是匿名内部类或是lambda的形式
//sealed写在原来final的位置，但是不能和final、non-sealed关键字同时出现，只能选择其一。
//继承的子类必须显式标记为final、sealed或是non-sealed类型。

//但是如果此时我们主动将B设定为non-sealed类型：
//public non-sealed class B extends A {
//
//}
//这样就可以正常继承了，因为B指定了non-sealed主动放弃了密封特性，这样就显得非常灵活了。

//public sealed [abstract] [class/interface] 类名 [extends 父类] [implements 接口, ...] permits [子类, ...]{
//        //里面的该咋写咋写
//}

//public [final/sealed/non-sealed] class 子类 extends 父类 {   //必须继承自父类
//    final类型：任何类不能再继承当前类，到此为止，已经封死了。
//    sealed类型：同父类，需要指定由哪些类继承。
//    non-sealed类型：重新开放为普通类，任何类都可以继承。
//}