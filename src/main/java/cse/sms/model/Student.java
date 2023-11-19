/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.model;

/**
 *
 * @author 915
 */
public class Student {
    private String name;
    private String studentId;
    private String major;
    private String secretNum;
    private String secretNum2;
    
    public Student(){}
    
    public Student(String name, String studentId, String major, String secretNum, String secretNum2) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.secretNum = secretNum;
        this.secretNum2 = secretNum2;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getSecretNum() {
        return secretNum;
    }

    public String getSecretNum2() {
        return secretNum2;
    }
    
    
}
