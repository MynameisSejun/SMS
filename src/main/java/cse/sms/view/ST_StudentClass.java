/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Arrays;

/**
 *
 * @author 원채연
 */
public class ST_StudentClass extends javax.swing.JFrame {

    UserData loginUser = UserData.getInstance();

    /**
     * Creates new form StdClasses
     */
    public ST_StudentClass() {
        initComponents();
        setTitle("수강 신청" + loginUser.getID() + loginUser.getName());
        PrintclassInfo();   //개설 강의 보이기
        PrintStdInfo();     //현재 신청 내역 보이기
        setLocationRelativeTo(null);

    }

    private void PrintclassInfo() {  //강의 가능 수업 목록

        File file = new File("classes.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                model.addRow(dataRow);
            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void SaveStdInfo() {    //학번,이름 저장
        File file = new File("studentclasses.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"))) {
            String stdnum = loginUser.getID();
            String name = loginUser.getName();
            bw.write(stdnum + "," + name + ",");

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void SaveGradeInfo() {    //학점 저장

        File file2 = new File("studentInfo.txt");   //학점 저장
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "UTF-8"))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");

                System.out.println(Arrays.toString(dataRow) + "======");

                if (dataRow[0].equals(loginUser.getID())) {
                    dataRow[5] = loginUser.getGrade(); // 성적 업데이트

                    System.out.println("성적 업데이트 : " + dataRow[5]);

                    temp = String.join(",", dataRow);
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void SaveStdclassInfo(int i) {    //수강 내역 저장

        File file = new File("studentclasses.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"))) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                bw.write(jTable1.getValueAt(i, j).toString() + ",");
            }
            bw.newLine();
            bw.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void PrintStdInfo() {    //학생 수강 내역 띄우기
        String file = "studentclasses.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);    //Row 0해서 리셋

            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                String inputStr[] = new String[6];
                if (dataRow[1].equals(loginUser.getName())) {

                    inputStr[0] = dataRow[2];    //강좌번호
                    inputStr[1] = dataRow[3];    //강좌명
                    inputStr[2] = dataRow[4];    //학점
                    inputStr[3] = dataRow[5];    //학과
                    inputStr[4] = dataRow[6];    //교수
                    inputStr[5] = dataRow[7];    //설명

                    model.addRow(inputStr);
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private boolean gradeCheck(int i) {     //학점 체크
        TableModel model = jTable1.getModel();
        String file = "studentInfo.txt";

        int storedscore;
        int classnum = Integer.parseInt((String) model.getValueAt(i, 2));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                storedscore = Integer.parseInt(userInfo[5]);
                String storedID = userInfo[0];
                if (storedID.equals(loginUser.getID())) {
                    storedscore += classnum;
                }
                if (storedscore > 18) {   //현재 수강 학점 + 신청하려는 수강 학점 > 18
                    return true;
                }
            }

        } catch (IOException ex) {
            ex.getStackTrace();
        }
        return false;

    }

    public boolean DoubleCheck(int selectedline) {
        String file = "studentclasses.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            TableModel model = jTable1.getModel();
            String selectedclassnum = (model.getValueAt(selectedline, 0).toString()); //선택한 줄의 classnumber
            String line;
            while ((line = br.readLine()) != null) {
                String[] classInfo = line.split(",");
                String storedID = classInfo[0];
                String storedclassnum = classInfo[2];
                if (storedID.equals(loginUser.getID()) && storedclassnum.equals(selectedclassnum)) {
                    return true; // 이미 수강한 강의임
                }
            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "이름", "학점", "학과", "교수", "설명"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setLabel("신청");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "이름", "학점", "학과", "교수", "설명"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton2.setText("뒤로 가기");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(297, 297, 297)
                                    .addComponent(jButton1))))
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int i = jTable1.getSelectedRow();   //몇번째 줄인지
        boolean tDouble, tGrade = false;
        tDouble = DoubleCheck(i); // 중복 수강 체크
        tGrade = gradeCheck(i);   //수강 학점 체크

        TableModel model = jTable1.getModel();
        String file = "studenInfo.txt";
        int classnum = Integer.parseInt((String) model.getValueAt(i, 2));
        if (tDouble == false && tGrade == false) {   //문제 없으면 수강내역 파일에 값저장, 아래에 내역 띄우기
            SaveStdInfo();            //학번,이름 저장
            SaveStdclassInfo(i);      //수강내역 파일에 저장
            SaveGradeInfo();
            PrintStdInfo();             //화면에 보이기

            String filePath = "studentInfo.txt";
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");
            BufferedReader reader;
            BufferedWriter writer;

            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));

                String line;
                boolean changed = false;
                while ((line = reader.readLine()) != null) {
                    String[] userInfo = line.split(",");
                    String ID = userInfo[0];
                    String pw = userInfo[1];
                    String name = userInfo[2];
                    String major = userInfo[3];
                    String num = userInfo[4];
                    String grade = userInfo[5];

                    int storedscore = Integer.parseInt(grade);

                    if (ID.equals(loginUser.getID())) {
                        storedscore += classnum;
                        grade = Integer.toString(storedscore);
                        System.out.println(grade);
                        line = ID + "," + pw + "," + name + "," + major + "," + num + "," + grade;
                        changed = true;
                    }
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
                reader.close();
                if (changed) {
                    // 기존 파일 삭제하고 임시 파일 이름 변경
                    inputFile.delete();
                    tempFile.renameTo(inputFile);

                } else {
                    // 수정할 학생 정보가 없는 경우 임시 파일 삭제
                    tempFile.delete();
                }
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        } else if (tDouble == true) {   //문제 없으면 수강내역 파일에 값저장, 아래에 내역 띄우기
            JOptionPane.showMessageDialog(null, "이미 수강한 강의 입니다.");
        } else if (tGrade == true) {   //문제 없으면 수강내역 파일에 값저장, 아래에 내역 띄우기
            JOptionPane.showMessageDialog(null, "수강 가능 학점을 초과하였습니다.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        ST_FirstPage st = new ST_FirstPage();
        st.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
