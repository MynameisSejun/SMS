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

    public Student(String name, String studentId, String major, String secretNum) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.secretNum = secretNum;
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
    
    
}
