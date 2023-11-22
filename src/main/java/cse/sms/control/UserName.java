/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 915
 */
public class UserName {
    private String ID;
    private String name;
    private String filePath;
    
    public String getName(String filepath, String ID) {
        this.filePath = filepath;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                    String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                    String storedID = userInfo[0]; // txt파일에 있는 ID
                    String storedName = userInfo[2]; // txt파일에 있는 이름
                   
                    if(ID.equals(storedID)){
                        String name = storedName;
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        return name;
    }
}
