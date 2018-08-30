package com.multithread.synch;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午5:44
 * @Function : 给指定的对象枷锁
 */

/**
 * 银行账户类
 */
class Account {
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }
    //存钱
    public  void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱
    public  void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}

/**
 * 账户操作类
 */
class AccountOperator implements Runnable {
    private Account account;
    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);

            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}


public class SynchObject {

    public static void main(String[] args) {

        Account account = new Account("zhang san", 1000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int NUM = 5;
        Thread thread[] = new Thread[NUM];

        for(int i=0;i<NUM;++i){
            thread[i] = new Thread(accountOperator,"Thread"+i);
            thread[i].start();
        }



    }

}
