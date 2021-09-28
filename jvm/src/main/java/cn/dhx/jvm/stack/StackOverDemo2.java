package cn.dhx.jvm.stack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class StackOverDemo2 {
    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setName("market");

        Emp emp = new Emp();
        emp.setName("zhangsan");
        emp.setDept(dept);

        Emp emp1 = new Emp();
        emp.setName("lisi");
        emp.setDept(dept);

        List<Emp> emps = Arrays.asList(emp, emp1);
        dept.setEmpList(emps);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(dept);
        System.out.println(s);
    }


}

@Data
class Emp{
    private String name;

    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

@Data
class Dept{
    private String name;

    private List<Emp> empList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
