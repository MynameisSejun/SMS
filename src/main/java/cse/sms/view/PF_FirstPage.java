/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author LG
 */
public class PF_FirstPage extends javax.swing.JFrame {
    UserData loginUser = UserData.getInstance();
    
    /**
     * Creates new form PF_LectureList
     */
    public PF_FirstPage() {
        initComponents();
        setTitle("교수 " + loginUser.getID() + " " + loginUser.getName());
        setLocationRelativeTo(null);
        fillTable();
    }
    
    private void fillTable() {
        try {
            File file = new File("classopen.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            String[] data;
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            // model.setRowCount(0);  // 테이블 초기화

            while ((line = br.readLine()) != null) {
                data = line.split(",");
                if (data[2].equals(loginUser.getName())) {
                    model.addRow(new Object[]{data[0], data[1]});
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButt_StudentList = new javax.swing.JButton();
        jButt_Input_Grade = new javax.swing.JButton();
        jButt_AttendanceList = new javax.swing.JButton();
        jButt_Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("강의 목록");

        jButt_StudentList.setText("수강생 목록");
        jButt_StudentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_StudentListActionPerformed(evt);
            }
        });

        jButt_Input_Grade.setText("성적 입력");
        jButt_Input_Grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_Input_GradeActionPerformed(evt);
            }
        });

        jButt_AttendanceList.setText("출석부");
        jButt_AttendanceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_AttendanceListActionPerformed(evt);
            }
        });

        jButt_Back.setText("뒤로");
        jButt_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_BackActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "강의 번호", "강의명"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("비밀번호 변경");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButt_StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButt_Input_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButt_AttendanceList, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButt_Back)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButt_StudentList, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButt_Input_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButt_AttendanceList, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButt_Back)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButt_StudentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_StudentListActionPerformed

        int selectedRow = jTable1.getSelectedRow(); // 사용자가 선택한 행의 인덱스를 가져옴.
        if (selectedRow != -1) { // 행이 선택되었는지 확인합니다.
        String lectureNumber = (String) jTable1.getValueAt(selectedRow, 0); // 선택한 행의 첫 번째 열의 값을 가져옴.
        String lectureName = (String) jTable1.getValueAt(selectedRow, 1); // 선택한 행의 두 번째 열의 값을 가져옴.
        
        // 수강생 목록 페이지를 생성하고, 선택한 강의의 정보를 전달.
        PF_StudentList pf = new PF_StudentList(lectureNumber, lectureName);
        pf.fillTable(lectureNumber);
        pf.setVisible(true);
        dispose();
    } else {
        // 행이 선택되지 않았다면, 사용자에게 알림을 표시.
        JOptionPane.showMessageDialog(this, "강의를 선택해주세요.");
    }
    }//GEN-LAST:event_jButt_StudentListActionPerformed

    private void jButt_Input_GradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_Input_GradeActionPerformed

        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
        String lectureNumber = (String) jTable1.getValueAt(selectedRow, 0);
        String lectureName = (String) jTable1.getValueAt(selectedRow, 1);
        PF_Input_Grade pf = new PF_Input_Grade(lectureNumber, lectureName);
        pf.fillTable(lectureNumber);
        pf.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "강의를 선택해주세요.");
    }
    }//GEN-LAST:event_jButt_Input_GradeActionPerformed

    private void jButt_AttendanceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_AttendanceListActionPerformed
        
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String lectureNumber = (String) jTable1.getValueAt(selectedRow, 0);
        String lectureName = (String) jTable1.getValueAt(selectedRow, 1);
        PF_AttendanceList pf = new PF_AttendanceList(lectureNumber, lectureName);
        pf.fillTable(lectureNumber);
        pf.setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "강의를 선택해주세요.");
    }
    }//GEN-LAST:event_jButt_AttendanceListActionPerformed

    private void jButt_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_BackActionPerformed
        Login_Page pf = new Login_Page();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButt_BackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PWChange pw = new PWChange();
        pw.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButt_AttendanceList;
    private javax.swing.JButton jButt_Back;
    private javax.swing.JButton jButt_Input_Grade;
    private javax.swing.JButton jButt_StudentList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
