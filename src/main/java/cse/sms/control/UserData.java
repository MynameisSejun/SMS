/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.control;

/**
 *
 * @author 915
 */
public class UserData {
    private static String ID;
    private static String PW;
    private static String name;
    private static String grade;
    private static UserData userdata;
    
    public UserData() {
        
    }
    
    public static UserData getInstance() {
        if(userdata == null) {
            userdata = new UserData();
        }
        return userdata;
    }

    public static void setID(String ID) {
        UserData.ID = ID;
    }

    public static void setPW(String PW) {
        UserData.PW = PW;
    }

    public static void setName(String name) {
        UserData.name = name;
    }

    public static void setGrade(String grade) {
        UserData.grade = grade;
    }

    public String getID() {
        return ID;
    }

    public static String getPW() {
        return PW;
    }

    public static String getName() {
        return name;
    }
    
    public static String getGrade(){
        return grade;
    }

}
