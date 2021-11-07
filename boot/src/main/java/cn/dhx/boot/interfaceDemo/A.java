package cn.dhx.boot.interfaceDemo;

public interface A {

    default String getAll() {
        return "A";
    }
}
