package jioazhigongguanli;

import java.io.Serializable;

public class Employee extends Person implements Serializable,Comparable<Employee> {
    private String emid;
    private String phone;
    private String branch;//部门
    private Integer competent;//职称

    public Employee() {
    }

    public String getEmid() {
        return emid;
    }

    public void setEmid(String emid) {
        this.emid = emid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getCompetent() {
        return competent;
    }

    public void setCompetent(Integer competent) {
        this.competent = competent;
    }

    public Employee(String emid, String phone, String branch, Integer competent) {
        this.emid = emid;
        this.phone = phone;
        this.branch = branch;
        this.competent = competent;
    }

    public Employee(String name, int sex, String perid, String date, String emid, String phone, String branch, Integer competent) {
        super(name, sex, perid, date);
        this.emid = emid;
        this.phone = phone;
        this.branch = branch;
        this.competent = competent;
    }

    @Override
    public String toString() {
        return "职工号："+emid + " 电话号: " + phone  + " 部门：" + branch + "  职称：" + competent
                + "  身份证号 " + getPerid() + "  姓名： " + getName() + "  性别： " + getSex() + "  生日： " + getDate1();
    }

    @Override
    public int compareTo(Employee o) {
        return this.competent - o.competent;
    }
}
