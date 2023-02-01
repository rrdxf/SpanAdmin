package grap;

public class Custormer {
    private String name;
    private String idCard;
    private String telephone;
    private String address;
    private boolean isVip;
    public Custormer(){
        this.name="张三";
        this.idCard="43999000211111122";
        this.telephone="13988889999";
    }

    @Override
    public String toString() {
        return
                "姓名:" + name  +
                ", 身份证号：" + idCard  +
                ", 电话：" + telephone  +
                ", 地址：" + address  +
                ", Vip：" + isVip ;
    }
}
