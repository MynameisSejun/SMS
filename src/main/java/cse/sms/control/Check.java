/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 915
 */
public class Check {

    public boolean emptyCheck(String name, String Id, String major, String secretNum, String secretNum2) { //정보 저장할 때 빈칸 체크할려고 만들긴 햇는데 안돌아가는듯
        String[] check = {name, Id, major, secretNum, secretNum2};
        boolean isEmpty = true;
        for (int i = 0; i < check.length; i++) {
            if (check[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public boolean equalCehck(String filePath, String ID) {
        boolean check = true;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                String storedID = userInfo[0];

                if (ID.equals(storedID)) {
                    check = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }

    public int loginCheck(String filePath, String ID, String PW) {
        boolean check = false;
        boolean passwordcheck = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                String storedID = userInfo[0]; // txt파일에 있는 ID
                String storedPW = userInfo[1]; // txt파일에 있는 PW

                if (ID.equals(storedID)) {
                    check = true;
                    if (PW.equals(storedPW)) {
                        passwordcheck = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (check && passwordcheck) {
            return 1; //로그인 성공
        } else if (check) {
            return 2; //비밀번호 틀림
        } else {
            return 3; //아이디 틀림
        }
    }
    
    public String getName(String filePath, String ID) {
        String name = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                    String[] userInfo = line.split(","); // txt파일에 저장되어있는 아이디와 비밀번호를 나눠서 저장.
                    String storedID = userInfo[0]; // txt파일에 있는 ID
                    String storedName = userInfo[2]; // txt파일에 있는 이름
                   
                    if(ID.equals(storedID)){
                        name = storedName;
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        return name;
    }
    
}
