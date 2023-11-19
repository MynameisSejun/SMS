/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.sms.control;

/**
 *
 * @author 915
 */
public class MCheck extends Check{
    
    public boolean emptyMCheck(String ID, String PW) {
        String[] check = {ID, PW};
        boolean isEmpty = true;
        for(int i = 0; i < check.length; i++) {
            if(check[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty; 
    }
    
}
