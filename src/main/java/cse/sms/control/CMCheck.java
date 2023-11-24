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
 * @author suk22
 */
public class CMCheck {
    public boolean emptyCheck2(String num, String name,  String pname, String grade, String infor) { //정보 저장할 때 빈칸 체크할려고 만들긴 햇는데 안돌아가는듯
        String[] check = {num, name, pname, grade, infor};
        boolean isEmpty = true;
        for(int i = 0; i < check.length; i++) {
            if(check[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty; 
    }
      public boolean emptyCheck2(String num, String name,  String pname, String infor) { //정보 저장할 때 빈칸 체크할려고 만들긴 햇는데 안돌아가는듯
        String[] check = {num, name, pname, infor};
        boolean isEmpty = true;
        for(int i = 0; i < check.length; i++) {
            if(check[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty; 
    }
    
    public boolean equalCehck2(String filePath, String ID) {
        boolean check = true;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                String storedID = userInfo[0];
                
                if(ID.equals(storedID)) {
                    check = false;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return check;
}
}