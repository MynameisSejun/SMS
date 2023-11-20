/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.view.Login_Page;
import cse.sms.view.Login_Page.LoginData;
import cse.sms.control.Check;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;


/**
 *
 * @author 915
 */
public class PWChange extends javax.swing.JFrame {
    
    
    /**
     * Creates new form PWChange
     */
    public PWChange() {
        initComponents();
        setTitle("비밀번호 변경");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentPasswordTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        newPasswordTextField = new javax.swing.JTextField();
        confirmNewPasswordTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("현재 비밀번호");

        jLabel2.setText("새 비밀번호");

        jLabel3.setText("새 비밀번호 확인");

        jButton1.setText("확인");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(confirmNewPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(newPasswordTextField)
                        .addComponent(currentPasswordTextField)))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmNewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // 이전 로그인 창에서 받아온 아이디를 텍스트 필드에 설정
        
        // 누구인지 판별해서 읽을 파일 정하기
        char firstChar = LoginData.getUsername().charAt(0);
        
        System.out.println(LoginData.getUsername());
        
        String filename;

        if (firstChar == 'S') {
            filename = "studentInfo.txt";
        } else if (firstChar == 'P') {
            filename = "professorInfo.txt";
        } else if (firstChar == 'G') {
            filename = "classmanagerInfo.txt";
        } else if (firstChar == 'H') {
            filename = "schoolmanagerInfo.txt";
        } else {
            // 예외 처리: 다른 시작 문자에 대한 처리는 음~ 일단 패스
            return;
        }
        System.out.println(filename);
        
            String currentPassword = currentPasswordTextField.getText(); //현재 비번
            String newPassword = newPasswordTextField.getText(); // 새 비번
            String confirmNewPassword = confirmNewPasswordTextField.getText(); // 새 비번 확인
            
            System.out.println(currentPassword);
            System.out.println(newPassword);
            System.out.println(confirmNewPassword);
            System.out.println(LoginData.getPassword());
            
            
            // 현재 비번, 새 비번, 새 비번 확인이 모두 일치하는지 확인
            if (currentPassword.equals(LoginData.getPassword()) && newPassword.equals(confirmNewPassword)) {
                // BufferedReader를 사용하여 파일을 읽어 아이디를 비교하여 비밀번호를 변경
                List<String> lines = new ArrayList<>();
                try {
                    /*
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    writer.write(newPassword);
                    writer.close();
                    */
                    BufferedReader reader = new BufferedReader(new FileReader(filename));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        String savedID = data[0];
                        String savedPassword = data[1];
                        
                        if (LoginData.getUsername().equals(savedID)) {
                            data[1] = newPassword; // 새로운 비밀번호로 변경
                        }
                        lines.add(String.join(",", data)); // 변경된 데이터를 리스트에 추가
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                // 새 비밀번호를 파일에 저장
                
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    for (String line : lines) {
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(this, "비밀번호가 성공적으로 변경되었습니다.");
            } else {
                JOptionPane.showMessageDialog(this, "비밀번호 변경에 실패했습니다. 입력한 정보를 다시 확인해주세요.");
            }
         
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmNewPasswordTextField;
    private javax.swing.JTextField currentPasswordTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField newPasswordTextField;
    // End of variables declaration//GEN-END:variables
}