package may_10;

public class AcountTest {
    public static void main(String[] args) {
        Account creditAccount = new CreditAccount("张三","1",20);
        Account savingAccount = new SavingAccount("李四","2");
        creditAccount.deposit(30);
        creditAccount.withdraw(60);
        creditAccount.withdraw(20);
        creditAccount.withdraw(20);
        creditAccount.deposit(70);
        creditAccount.transfer(savingAccount,60);
        System.out.println(savingAccount.toString());
        System.out.println(creditAccount.toString());
    }
}
