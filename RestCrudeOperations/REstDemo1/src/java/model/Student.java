

package model;

public class Student {
   private int rno;
   private String name,address,mobile;

    public Student() {
    }

    public Student(int rno, String name, String address, String mobile) {
        this.rno = rno;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
