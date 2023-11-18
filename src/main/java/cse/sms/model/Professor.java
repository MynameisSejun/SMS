/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.model;

/**
 *
 * @author 915
 */
public class Professor {
    private String name;
    private String professorId;
    private String major;
    private String secretNum;
    private String secretNum2;

    public Professor(String name, String professorId, String major, String secretNum, String secretNum2) {
        this.name = name;
        this.professorId = professorId;
        this.major = major;
        this.secretNum = secretNum;
        this.secretNum2 = secretNum2;
    }
    
    public String getName() {
        return name;
    }

    public String getProfessorId() {
        return professorId;
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
