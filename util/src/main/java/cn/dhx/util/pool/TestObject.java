package cn.dhx.util.pool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestObject {


    private String name;
    private boolean isActive;
    private int age;

    public TestObject(int age) {
        this.age = age;
    }

    public void destroy(){

    }
}
