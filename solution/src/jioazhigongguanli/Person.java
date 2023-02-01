package jioazhigongguanli;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int sex;
    private String perid;//身份证号
    private String date;
    private Date date1;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPerid() {
        return perid;
    }

    public void setPerid(String perid) {
        this.perid = perid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Person(String name, int sex, String perid, String date, Date date1) {
        this.name = name;
        this.sex = sex;
        this.perid = perid;
        this.date = date;
        this.date1 = date1;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Person() {
    }

    public Person(String name, int sex, String perid, String date) {
        this.name = name;
        this.sex = sex;
        this.perid = perid;
        this.date = date;
    }

}
