/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.Check;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author suk22
 */
public class Login_Page extends javax.swing.JFrame {

    /**
     * Creates new form Frametest
     */
    
    
    public Login_Page() {
        initComponents();
        setTitle("로그인");
        setLocationRelativeTo(null);
    }
    
    public class LoginData { // 비밀번호 변경 창에 아이디랑 비번 넘겨줄 메소드
    private static String username;
    private static String password;

    public static String getUsername() {
        return "S123"; // 임의로 테스트해보기 위해서 한거임. return username;으로 고치기
    }

    public static void setUsername(String username) {
        LoginData.username = username;
    }

    public static String getPassword() {
        return "1234567"; // 임의로 테스트하기 위한 코드. return password; 로 고치기
    }

    public static void setPassword(String password) {
        LoginData.password = password;
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LOGIN_BUTT = new javax.swing.JButton();
        ID_INPUT = new javax.swing.JTextField();
        PW_INPUT = new javax.swing.JPasswordField();
        SHOW_PW = new javax.swing.JCheckBox();
        PW_CHANGE = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("대학 정보 시스템");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("아이디");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setText("비밀번호");

        LOGIN_BUTT.setText("로그인");
        LOGIN_BUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN_BUTTActionPerformed(evt);
            }
        });

        ID_INPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_INPUTActionPerformed(evt);
            }
        });

        PW_INPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PW_INPUTActionPerformed(evt);
            }
        });

        SHOW_PW.setText("암호 가리기");
        SHOW_PW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SHOW_PWActionPerformed(evt);
            }
        });

        PW_CHANGE.setText("비밀번호 변경");
        PW_CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PW_CHANGEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SHOW_PW)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PW_INPUT, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ID_INPUT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(LOGIN_BUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PW_CHANGE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PW_INPUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SHOW_PW)
                .addGap(12, 12, 12)
                .addComponent(LOGIN_BUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PW_CHANGE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ID_INPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_INPUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_INPUTActionPerformed

    private void LOGIN_BUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN_BUTTActionPerformed
        // 앞자리 문자 판별 후 학생,교수,학사담당자,수업담당자 화면 나타내기 P 교수, S 학생, H 학사 담당자, G 수업 담당자
        //txt파일에 들어가는 내용은 아이디,비밀번호 로 입력해야함
        String ID = ID_INPUT.getText(); // 입력한 ID
        String PW = new String(PW_INPUT.getPassword()); // 입력한 PW        Jpasswordfield는 이렇게 받아야함.
        Check checknum = new Check();
        char first_munja = ID_INPUT.getText().charAt(0); // 첫 번째 글자 판별 후 페이지 이동
        int num;
        
        LoginData.setUsername(ID);
        LoginData.setPassword(PW); // ID와 PW를 LoginData 클래스에 저장
        
        switch (first_munja) {
            case 'S':
                String file = "studentInfo.txt";
                num = checknum.loginCheck(file, ID, PW);
                if(num == 1) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    //학생 페이지 창 띄우기
                    ST_FirstPage St = new ST_FirstPage(); // 매개변수로 학생 정보 넘겨야 할 듯
                    St.setVisible(true);
                    setVisible(false); // 이전 창 안 보이게 함
                    dispose(); // 창 끄게 하는건데 넣어야 하나??,,,
                    break;
                }else if(num == 2){
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다."); // 로그인 실패 -> 비밀번호 불일치
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "아이디가 일치하지 않습니다."); // 로그인 실패 -> 아이디 불일치
                    break;
                }
                
            case 'P':
                file = "professorInfo.txt";
                num = checknum.loginCheck(file, ID, PW);
                if(num == 1) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    //교수 페이지 창 띄우기 -> 교수 페이지 만들어야함
                    PF_FirstPage pf = new PF_FirstPage();
                    pf.setVisible(true);
                    setVisible(false);
                    dispose();
                    break;
                }else if(num == 2){
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다."); // 로그인 실패 -> 비밀번호 불일치
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "아이디가 일치하지 않습니다."); // 로그인 실패 -> 아이디 불일치
                    break;
                }
                
            case 'G':
                //수업 관리자 화면이랑 정보저장 만들어야함
                file = "classmanagerInfo.txt";
                num = checknum.loginCheck(file, ID, PW);
                if(num == 1) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    CM_FirstPage cf = new CM_FirstPage();
                    cf.setVisible(true);
                    setVisible(false);
                    break;
                    //교수 페이지 창 띄우기 -> 교수 페이지 만들어야함
                }else if(num == 2){
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다."); // 로그인 실패 -> 비밀번호 불일치
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "아이디가 일치하지 않습니다."); // 로그인 실패 -> 아이디 불일치
                    break;
                }
                
            case 'H':
                //학사 관리자 화면이랑 정보저장 만들어야함
                file = "schoolmanagerInfo.txt";
                num = checknum.loginCheck(file, ID, PW);
                if(num == 1) {
                    JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
                    SM_FirstPage sf = new SM_FirstPage();
                    sf.setVisible(true);
                    setVisible(false);
                    break;
                    //교수 페이지 창 띄우기 -> 교수 페이지 만들어야함
                }else if(num == 2){
                    JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다."); // 로그인 실패 -> 비밀번호 불일치
                    break;
                }else {
                    JOptionPane.showMessageDialog(null, "아이디가 일치하지 않습니다."); // 로그인 실패 -> 아이디 불일치
                    break;
                }
        }  
        
    }//GEN-LAST:event_LOGIN_BUTTActionPerformed

    private void PW_INPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PW_INPUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PW_INPUTActionPerformed

    private void SHOW_PWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SHOW_PWActionPerformed
       if(SHOW_PW.isSelected()){ // 암호 가리기
           PW_INPUT.setEchoChar((char)0);
       }
       else {
            PW_INPUT.setEchoChar(('*'));
       }
    }//GEN-LAST:event_SHOW_PWActionPerformed

    private void PW_CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PW_CHANGEActionPerformed
        
    }//GEN-LAST:event_PW_CHANGEActionPerformed

    /**
     * @param args the command line arguments
     */
    public void run() {
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_INPUT;
    private javax.swing.JButton LOGIN_BUTT;
    private javax.swing.JButton PW_CHANGE;
    private javax.swing.JPasswordField PW_INPUT;
    private javax.swing.JCheckBox SHOW_PW;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
