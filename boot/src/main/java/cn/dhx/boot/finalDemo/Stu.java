package cn.dhx.boot.finalDemo;

public class Stu {
    private final String session;
    private final int age;

    public Stu(String session, int age) {
        this.session = session;
        this.age = age;
    }

    public String getSession() {
        return session;
    }

    public int getAge() {
        return age;
    }
}
