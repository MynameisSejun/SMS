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
    private String grade;
    private String infor;

    public ClassCourse(String num, String name, String grade, String infor) {
        this.num = num;
        this.name = name;
        this.grade = grade;
        this.infor = infor;
    }

    public ClassCourse(String num, String grade, String infor) {
        this.num = num;
        this.grade = grade;
        this.infor = infor;
    }
    
    
    
    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getInfor() {
        return infor;
    }
    
}
