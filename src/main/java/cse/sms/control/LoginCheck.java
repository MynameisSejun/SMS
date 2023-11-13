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
public class LoginCheck {
    String file;
    String ID;
    String PW;
    
    public int LC(String file, String ID, String PW) {
        boolean check = false;
        boolean passwordcheck = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                    String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                    String storedID = userInfo[0]; // txt파일에 있는 ID
                    String storedPW = userInfo[1]; // txt파일에 있는 PW
                   
                    if(ID.equals(storedID)){
                        check = true;
                        if(PW.equals(storedPW)) {
                            passwordcheck = true;
                            break;
                        }
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }  
        if(check && passwordcheck) {
            return 1; //로그인 성공
        }else if(check) {
            return 2; //비밀번호 틀림
        }else {
            return 3; //아이디 틀림
        }
    }
}
