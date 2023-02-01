package may_10;

import java.util.Date;

public abstract class Account {
    private String id;//账户id
    private String name;//真实姓名
    private double balance;//账户余额
    Date dateCreated= new Date();//开户日期

    public Account(String name,String id){//构造方法赋值
        this.id = id;
        this.name=name;
    }
    //get和set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    abstract public double withdraw(double a);
    //取款方法withdraw，从账户提取指定数额，余额不足，不可以取款，提示用户
    abstract public double deposit(double b);
    //存款方法deposit，向账户存入指定数额
    abstract public Object transfer(Account a,double money);
    //转账方法transfer(Account  a ,double money)，向指定账户转指定数额，余额不足，不可以转账，提示用户
    public String toString(){
        return"账号："+this.id+"\n实名："+this.name+"\n账户余额："+this.balance+"\n开户时间"+dateCreated;
    }//public String toString()方法：返回字符串

}
