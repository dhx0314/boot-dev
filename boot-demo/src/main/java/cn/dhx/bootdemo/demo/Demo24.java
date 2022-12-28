package cn.dhx.bootdemo.demo;

public class Demo24 {
    public static void main(String[] args) {
        for (int i = 9; i < 12; i++) {

            String s="ALTER table t_roster_callinfo_"+i+" ADD INDEX index_d_a_o (`deleted`,`activity_info_id`,`outbound_callee_id_number`);";
            System.out.println(s);
        }
    }
}
