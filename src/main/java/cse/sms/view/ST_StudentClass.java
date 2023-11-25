/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.NewJFrame;
import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        File file = new File("classopen.txt");  //강의파일
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                //번호 이름 학점 학과 교수 인원수 설명
                String[] input = new String[6];
                input[0] = dataRow[0];
                input[1] = dataRow[1];
                input[2] = dataRow[2];
                input[3] = dataRow[4];
                input[4] = dataRow[5];
                input[5] = dataRow[6];

                model.addRow(input);
            }

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
                if (dataRow[0].equals(loginUser.getID())) {
                    dataRow[5] = loginUser.getGrade();
                    temp = String.join(",", dataRow);
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void SaveCountstdInfo(int i) {    //현재 수강 인원 저장

        File file2 = new File("classopen.txt");   // 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "UTF-8"))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                if (dataRow[0].equals(jTable1.getValueAt(i, 0))) {  //선택한 강좌번호 = classopen 강좌번호
                    int currentstd = Integer.parseInt(dataRow[7]);
                    currentstd++;
                    dataRow[7] = Integer.toString(currentstd);
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void SaveStdclassInfo(int i) {    //학번, 이름, 수강 내역 저장

        File file = new File("studentclasses.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "utf-8"))) {
            String stdnum = loginUser.getID();
            String name = loginUser.getName();
            bw.write(stdnum + "," + name + ",");

            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                if (j != 5 || j!=3) {
                    bw.write(jTable1.getValueAt(i, j).toString() + ",");
                }
            }
            bw.newLine();
            bw.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

private void PrintStdInfo() {    //학생 수강 내역 띄우기
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    boolean tID = false;
    String inputStr[] = new String[6];

    String file = "studentclasses.txt";
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        model.setRowCount(0);    // RowCount를 0으로 설정하여 기존 내용을 초기화
        String temp;
        while ((temp = br.readLine()) != null) {
            String dataRow[] = temp.split(",");
            if (dataRow[0].equals(loginUser.getID())) { // id 동일
                tID = true;
                inputStr[0] = dataRow[2];    // 강좌번호
                inputStr[1] = dataRow[3];    // 강좌명
                inputStr[2] = dataRow[4];    // 학점
                inputStr[3] = dataRow[6];    // 교수
                inputStr[4] = "";            // 최대/최소 인원
                inputStr[5] = dataRow[7];    // 설명
                
                String classOpenFile = "classopen.txt";
                try (BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(classOpenFile), "UTF-8"))) {
                    String temp2;
                    while ((temp2 = br2.readLine()) != null) {
                        String[] dataRow2 = temp2.split(",");
                        if (dataRow2[0].equals(inputStr[0])) {  // 강좌번호 ==
                            inputStr[4] = dataRow2[5];   // 최대/최소 인원
                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                model.addRow(inputStr);
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
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

    private boolean maxPersonCheck(int i) {     //최대인원 수 체크
        TableModel model = jTable1.getModel();
        int max = 0, crrcount = 0;
        String currentstd;    //선택한 강의의 수강인원
        String classnum = (String) model.getValueAt(i, 0);  //수강번호

        String file2 = "classopen.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow[0].equals(classnum)) {
                    String[] maxmin2 = dataRow[5].split("/");
                    max = Integer.parseInt(maxmin2[0]);
                    crrcount = Integer.parseInt(dataRow[7]);
                    if (crrcount > max) {     //현재 수강 인원>최대보다 많으면
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
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
                "번호", "이름", "학점", "교수", "최대/촤소인원", "설명"
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
                "번호", "이름", "학점", "교수", "최대/최소인원", "설명"
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
            jTable2.getColumnModel().getColumn(0).setResizable(false);
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
        TableModel model = jTable1.getModel();

        boolean tDouble, tGrade, tMaxmin = false;
        tDouble = DoubleCheck(i); // 중복 수강 체크
        tGrade = gradeCheck(i);   //수강 학점 체크
        tMaxmin = maxPersonCheck(i);    //최대 최소 인원 체크

//        String file = "studenInfo.txt";
        int classnum = Integer.parseInt((String) model.getValueAt(i, 2));

        if (tDouble == false && tGrade == false && tMaxmin == false) {   //문제 없으면 수강내역 파일에 값저장, 아래에 내역 띄우기
            SaveStdclassInfo(i);      //수강내역 파일에 저장
            SaveGradeInfo();        //학생정보에 학점 저장
            SaveCountstdInfo(i);         //수강 인원 +1 해서 classopen에 저장
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
