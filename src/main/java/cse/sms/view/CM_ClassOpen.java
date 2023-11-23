/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import javax.swing.JOptionPane;
import cse.sms.control.CMCheck;
import cse.sms.control.UserData;
import cse.sms.model.ClassCourse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 원채연
 */
public class CM_ClassOpen extends javax.swing.JFrame {

     private DefaultTableModel tableModel;
         UserData loginUser = UserData.getInstance();
    /**
     * Creates new form CM_ClassOpen
     */
    public CM_ClassOpen() {
        initComponents();
        setTitle("수업담당자 - 강의개설" + loginUser.getID());
        setLocationRelativeTo(null);
        
        // 초기화하는 작업
        tableModel = new DefaultTableModel();
        tableModel.addColumn("강좌번호");
        tableModel.addColumn("강의명");
        tableModel.addColumn("학점");
        tableModel.addColumn("강좌계획내용");
        jTable2.setModel(tableModel);

        // classes.txt 파일에서 데이터 불러오기
        loadClassData();
    }
    private void loadClassData() {
        String filePath = "classes.txt";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] classInfo = line.split(",");
                tableModel.addRow(classInfo);
            }

            reader.close();
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

        jLabel4 = new javax.swing.JLabel();
        cNum = new javax.swing.JTextField();
        classInfo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mPeople = new javax.swing.JTextField();
        pName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel4.setText("최대/최소인원");

        cNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNumActionPerformed(evt);
            }
        });

        classInfo.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        classInfo.setText("등록");
        classInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classInfoActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "강의번호", "강의명", "학점", "강좌계획내용"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("뒤로 가기");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("강의번호");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setText("교수명");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addComponent(classInfo)
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(classInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)))
                        .addGap(57, 57, 57))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classInfoActionPerformed
    String filePath = "classopen.txt";
    String classFilePath = "classes.txt";
    ClassCourse classCourse = new ClassCourse(cNum.getText(), pName.getText(), mPeople.getText());
    CMCheck ck = new CMCheck();

    boolean emCheck = ck.emptyCheck2(cNum.getText(),  pName.getText(), mPeople.getText());

    if (emCheck) {
        boolean classExists = false;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(classFilePath, StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                String[] classInfo = line.split(",");
                if (classInfo.length > 0 && classInfo[0].equals(cNum.getText())) {
                    classExists = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (classExists) {
             try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {
            String classInfo = classCourse.getNum() + "," + classCourse.getGrade() + "," + classCourse.getInfor();
            writer.write(classInfo);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "저장되었습니다!");
            dispose();
<<<<<<< HEAD
            CM_FirstPage sf = new CM_FirstPage();
=======
            SM_FirstPage sf = new SM_FirstPage();
>>>>>>> 1b5b4acbd29635979b2bdd80957839390e5905cb
            sf.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        } else {
            JOptionPane.showMessageDialog(null, "유효한 강의 번호가 아닙니다. 다른 강의 번호를 선택해주세요.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "빈칸이 있습니다. 마저 입력해주세요.");
    }
    }//GEN-LAST:event_classInfoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 뒤로 가기
        CM_FirstPage cf = new CM_FirstPage();
        cf.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNumActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cNum;
    private javax.swing.JButton classInfo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField mPeople;
    private javax.swing.JTextField pName;
    // End of variables declaration//GEN-END:variables
}
