package may_10;

public class CreditAccount extends Account{
    private double credit;
    private double creditLimit;

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditAccount(String name, String id, double creditLimit) {
        super(name, id);
        credit = creditLimit;
        this.creditLimit = creditLimit;
    }

    @Override
    public double withdraw(double a) {
        if (getBalance() < a){
            if (getBalance() + creditLimit > a){
                creditLimit -= getBalance();
                setBalance(0);
                System.out.println("取款" + a + "元,账户余额：0元，使用信用额度:"
                        + (credit - creditLimit) + "元，剩余信用额度:" +creditLimit+"元"  );
            }else {
                System.out.println("您的信用额度和余额不足");
            }
        }else {
            setBalance(getBalance() - a);
            System.out.println("取款"+ a +"元，账户余额："+ getBalance());
        }
       return getBalance();
    }

    @Override
    public double deposit(double b) {
        super.setBalance(getBalance() + b);
        System.out.println("已存款:"+b+"元,账户余额："+getBalance()+"元");
        return getBalance();
    }

    @Override
    public Object transfer(Account a, double money) {
        System.out.println("只能使用余额转账，不可使用信用额度");
        if (getBalance() < money){
            System.out.println("余额不足，请确认余额");
            return a;
        }else {
            setBalance(getBalance() - money);
            a.setBalance(a.getBalance() + money);
            System.out.println("给账户" + a.getName() + "转账" + money +
                    "元" + "现可用余额:" + getBalance() + "元");
        }
        return a;
    }

    @Override
    public String toString() {
        if (getBalance() > 0){
            return "账号:"+getName()+"\t账户存款:"+getBalance()+"\t可用金额:"+
                    (getBalance() + creditLimit) + "\t开户时间:"+dateCreated;
        }else if (creditLimit < credit){
            return "账号:"+getName()+"\t账户欠款:"+ (credit - creditLimit) +"\t可用金额:"+
                    getBalance() + creditLimit + "\t开户时间:"+dateCreated;
        }
        return "账号:"+getName()+"\t账户存款:"+getBalance()+"\t可用金额:"+
                (getBalance() + creditLimit) + "\t开户时间:"+dateCreated;
    }
}
