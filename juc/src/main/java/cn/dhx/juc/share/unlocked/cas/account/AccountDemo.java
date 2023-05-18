package cn.dhx.juc.share.unlocked.cas.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/18 19:48
 */
@Slf4j
public class AccountDemo {

    @Test
    public void unsafeDemo() {
        Account unSafeAccount = new UnSafeAccount(10000);
        Account.demo(unSafeAccount);
    }

    @Test
    public void safeDemo() {
        Account safeAccount = new SafeAccount(10000);
        Account.demo(safeAccount);
    }
}


@AllArgsConstructor
@NoArgsConstructor
class UnSafeAccount implements Account {

    private Integer balance;

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        balance -= amount;
    }
}

@AllArgsConstructor
@NoArgsConstructor
class SafeAccount implements Account {

    private Integer balance;

    @Override
    public Integer getBalance() {
        synchronized (this) {
            return balance;
        }
    }

    @Override
    public void withdraw(Integer amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
}