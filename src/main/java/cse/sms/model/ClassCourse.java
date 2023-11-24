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

    public ClassCourse(String num, String name, String pname, String grade, String infor) {
        this.num = num;
        this.name = name;
        this.pname = pname;
        this.grade = grade;
        this.infor = infor;
    }

    public ClassCourse(String num, String name, String pname, String infor) {
        this.num = num;
        this.name = name;
        this.pname = pname;
        this.infor = infor;
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
    
}
