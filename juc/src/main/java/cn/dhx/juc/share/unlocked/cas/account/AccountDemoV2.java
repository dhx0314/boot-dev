package cn.dhx.juc.share.unlocked.cas.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author daihongxin
 * @create 2023/5/18 20:07
 */
@Slf4j
public class AccountDemoV2 {

    @Test
    public void casSafe() {
        Account casAccount = new CasAccount(new AtomicInteger(10000));
        Account.demo(casAccount);
    }
}

@NoArgsConstructor
class CasAccount implements Account {

    private AtomicInteger balance;

    public CasAccount(AtomicInteger balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            if (balance.compareAndSet(prev, next)) {
                return;
            }
        }
    }


}
