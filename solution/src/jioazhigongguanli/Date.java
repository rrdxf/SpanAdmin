package jioazhigongguanli;

import java.io.Serializable;

public class Date implements Serializable {
    private String year;
    private String month;
    private String day;

    public Date(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(String date) {
        String []  strings = date.split("/");
        this.year = strings[0];
        this.month = strings[1];
        this.day = strings[2];
    }

    public Date() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return  year + "/" + month + "/" + day;
    }
}
