package cn.dhx.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stu implements Serializable {

    private static final long serialVersionUID = -4392658638228508589L;


    private String id;



    private String name;

    private Boolean aa;

    public static byte[] bytes = {1};

    private byte[] wavDirect;

    public int add(int a) {
        return 1;
    }

    public long add(int a, int b) {
        return 1;
    }

    public Stu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void finlize() throws Throwable {
        super.finalize();
    }

}
