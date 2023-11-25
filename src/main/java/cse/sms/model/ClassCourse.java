/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.model;

/**
 *
 * @author suk22
 */
public class ClassCourse {
    /**
     * Creates new form ClassCourse
     */
  private String num;
    private String name;
    private String pname;
    private String grade;
    private String infor;
    private String major;
    private String mpeople;
    private String credit;

    public ClassCourse(String num, String name, String pname, String mpeople, String infor) {
        this.num = num;
        this.name = name;
        this.pname = pname;
        this.mpeople = mpeople;
        this.infor = infor;
    }

    public ClassCourse(String num, String name, String major, String grade) {
        this.num = num;
        this.name = name;
        this.grade = grade;
        this.major = major;
    }
    
    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
    
    public String getPName() {
        return pname;
    }

    public String getGrade() {
        return grade;
    }

    public String getInfor() {
        return infor;
    }
        public String getMajor() {
        return major;
    }
      public String getMpeople() {
        return mpeople;
    }    
        public void setCredit(String credit) {
        this.credit = credit;
    }
        public void setMajor(String Major) {
        this.major = Major;
    }
            public String getCredit() {
        return credit;
    }
}
