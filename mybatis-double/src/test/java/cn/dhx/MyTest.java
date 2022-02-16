package cn.dhx;


//import cn.dhx.dao.master.second.TAgentDetailDao;
import cn.dhx.dao.master.TAgentDetailDao2;
import cn.dhx.dao.second22.TAgentDetailDao;
import cn.dhx.entity.TAgentDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTest {

    @Autowired
    private TAgentDetailDao agentDetailDao;

    @Autowired
    private TAgentDetailDao2 tAgentDetailDao2;

    @Test
    public void fun234() {
        TAgentDetail tAgentDetail = agentDetailDao.queryById(33L);
        System.out.println(tAgentDetail);
        System.out.println("------");
    }

    @Test
    public void fun2342() {
        TAgentDetail tAgentDetail = tAgentDetailDao2.queryById(30L);
        System.out.println(tAgentDetail);
        System.out.println("------");
    }

}
