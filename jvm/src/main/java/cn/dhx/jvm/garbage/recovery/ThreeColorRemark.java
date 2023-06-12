package cn.dhx.jvm.garbage.recovery;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/6/11 20:31
 */
@Slf4j
public class ThreeColorRemark {

    public static void main(String[] args) {
        A a = new A();
        D d = a.b.d;
        a.b.d = null;
        a.d = d;
    }
}

class A{
    B b = new B();
    D d = null;
}

class B{
    C c = new C();
    D d = new D();
}

class C{

}

class D{

}
