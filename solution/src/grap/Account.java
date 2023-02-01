package grap;

public class Account {
    private String id;
    private String password;
    private double balance;

    public Account() {
        this.balance=10000;
        this.id="123";
        this.password="123";
    }

    public Account(String id, String password, double balance) {
        this.id = id;
        this.password = password;
        this.balance = balance;
    }
    public boolean verify(String id,String pwd){
        if (this.id.compareTo(id)==0&&this.password.compareTo(pwd)==0){
            return true;
        }
        return false;
    }
   void transter(double money){
        if (this.balance-money>=0){
            this.balance+=money;
            if (money>0){
                System.out.println("存入金额："+money);
                System.out.println("余额："+this.balance);
            }else {
                System.out.println("取出金额："+(-money));
                System.out.println("余额："+this.balance);
            }
        }else {
            System.out.println("账号余额不足");
        }
   }
}
