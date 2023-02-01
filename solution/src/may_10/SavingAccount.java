package may_10;

public class SavingAccount extends  Account {
    public SavingAccount(String name,String id){
        super(name,id);
    }
    public double withdraw(double a){
        double b=0;
        if(this.getBalance()>=a){
            b=this.getBalance()-a;
            setBalance(b);
        }else{
            System.out.println("对不起您的余额已不足！");
        }
        return this.getBalance();
    }//取款方法withdraw，从账户提取指定数额，余额不足，不可以取款，提示用户

    public double deposit(double b){
        double x;
        x=this.getBalance();
        x=x+b;
        setBalance(x);
        return this.getBalance();
    }//存款方法deposit，向账户存指定数额

    public Object transfer(Account a,double money){
        if(this.getBalance()>=money){
            double m;
            m=this.getBalance()-money;
            setBalance(m);
            a.setBalance(money+a.getBalance());
        }
        else{
            System.out.println("对不起您的余额不足,无法转账！");
        }
        return this.getBalance();
    }

}
