package cn.abigmelon.entity;

public record TestData(int id, String product, String address) {

}//它会在编译时，会自动编译出public get,hashcode,equals,toString等方法。
