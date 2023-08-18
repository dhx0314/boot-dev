package cn.dhx.copy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author daihongxin
 * @create 2023/8/14 15:10
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Cloneable,Serializable{

    private String name;

    private int age;

    private Phone phone;



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


//    需要实现Serializable接口  user和phone都需要
    public User copyUser3() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (User) ois.readObject();
    }

    public User copyUser4() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(objectMapper.writeValueAsString(this),User.class);
    }

}
