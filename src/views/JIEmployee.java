/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AccountController;
import controllers.EmployeeController;
import icontrollers.IAccountController;
import icontrollers.IEmployeeController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author ACER
 */
public class JIEmployee extends javax.swing.JInternalFrame {

    SessionFactory factory = HibernateUtil.getSessionFactory();
    IEmployeeController iec = new EmployeeController(factory);
    IAccountController iac = new AccountController(factory);
    
    public JIEmployee() {
        initComponents();
        showTableEmp("");
        resetTextEmp();
    }
    
    private void resetTextEmp(){
        textEmpId.setText("");
        textFirstName.setText("");
        textLastName.setText("");
        textEmpMail.setText("");
        textEmpPhone.setText("");
        textEmpManager.setText("");
        textSearch.setText("");
        lblEmpStatus.setText("");
        lblClick.setText("");
    }
    
    private void showTableEmp(String s){
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        Object[] row = new Object[7];
        List<Employee> emp = new ArrayList<>();
        
        if (s == "") {
            emp = iec.getAll();
        } else {
            emp = iec.search(s);
        }
        
        for (int i = 0; i < emp.size(); i++) {
            row[0] = i + 1;
            row[1] = emp.get(i).getId();
            row[2] = emp.get(i).getFirstName();
            row[3] = emp.get(i).getLastName();
            row[4] = emp.get(i).getEmail();
            row[5] = emp.get(i).getPhoneNumber();
            row[6] = emp.get(i).getManager().getFirstName()+" "+emp.get(i).getManager().getLastName();
            model.addRow(row);
        }
    }
    
    private void updateTableEmp(String s){
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        model.setRowCount(0);
        
        if (s == "") {
            showTableEmp("");
        }
            
        showTableEmp(s);
    }
    
    private void checkUser(String id){
        List<Employee> employees = new ArrayList<>();
        employees = iec.search(id);
        
        if (!employees.isEmpty()) {
           Account account = iac.getById(id);
            if (account != null) {
                lblEmpStatus.setText("Employee already have an account");
                lblClick.setText("Manage Account");
            }else{
                lblEmpStatus.setText("Employee does not have an account");
                lblClick.setText("Add an Account");
            }
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

        jLayerEmp = new javax.swing.JLayeredPane();
        lblEmpPhone = new javax.swing.JLabel();
        textEmpPhone = new javax.swing.JTextField();
        textEmpId = new javax.swing.JTextField();
        lblEmpId = new javax.swing.JLabel();
        textFirstName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        lblEmpMail = new javax.swing.JLabel();
        textEmpMail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        textSearch = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEmpManager = new javax.swing.JLabel();
        textEmpManager = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        lblEmpStatus = new javax.swing.JLabel();
        lblClick = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);

        lblEmpPhone.setText("Phone");

        lblEmpId.setText("Employee ID");

        lblFirstName.setText("First Name");

        lblLastName.setText("Last Name");

        lblEmpMail.setText("Email");

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "Employee ID", "First Name", "Last Name", "Email", "Phone", "Manager"
            }
        ));
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmp);

        textSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textSearch.setText("Search");
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employees");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoMiiOk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(89, 89, 89))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        lblEmpManager.setText("Manager");

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        lblEmpStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEmpStatus.setText("Employee_Status");

        lblClick.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblClick.setForeground(new java.awt.Color(0, 102, 204));
        lblClick.setText("Click_account");
        lblClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickMouseClicked(evt);
            }
        });

        jLayerEmp.setLayer(lblEmpPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textEmpPhone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textEmpId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblEmpId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblLastName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textLastName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblEmpMail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textEmpMail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblEmpManager, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(textEmpManager, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(buttonSave, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(buttonReset, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(buttonDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblEmpStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayerEmp.setLayer(lblClick, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayerEmpLayout = new javax.swing.GroupLayout(jLayerEmp);
        jLayerEmp.setLayout(jLayerEmpLayout);
        jLayerEmpLayout.setHorizontalGroup(
            jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayerEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textEmpId, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(lblEmpId)
                    .addComponent(textFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(lblFirstName)
                    .addComponent(textLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(lblLastName)
                    .addComponent(textEmpMail, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(lblEmpMail)
                    .addComponent(textEmpPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(lblEmpPhone)
                    .addComponent(lblEmpManager)
                    .addComponent(textEmpManager, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addGroup(jLayerEmpLayout.createSequentialGroup()
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonReset)
                        .addGap(58, 58, 58)
                        .addComponent(buttonDelete)))
                .addGap(82, 82, 82))
            .addGroup(jLayerEmpLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(lblEmpStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lblClick, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jLayerEmpLayout.setVerticalGroup(
            jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayerEmpLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayerEmpLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayerEmpLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpStatus)
                            .addComponent(lblClick, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayerEmpLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jLayerEmpLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblEmpId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFirstName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLastName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmpMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEmpMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmpPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEmpPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmpManager)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEmpManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayerEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSave)
                            .addComponent(buttonReset)
                            .addComponent(buttonDelete))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayerEmp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayerEmp)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        int SelectedRowIndex = tableEmp.getSelectedRow();
        textEmpId.setEditable(false);
        textEmpId.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        textFirstName.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        textLastName.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        textEmpMail.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        textEmpPhone.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        textEmpManager.setText(model.getValueAt(SelectedRowIndex, 6).toString());
        checkUser(model.getValueAt(SelectedRowIndex, 1).toString());
    }//GEN-LAST:event_tableEmpMouseClicked

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        updateTableEmp(textSearch.getText());
    }//GEN-LAST:event_textSearchKeyReleased

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        updateTableEmp(textSearch.getText());
    }//GEN-LAST:event_textSearchKeyTyped

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if (textEmpId.getText().trim().isEmpty() || textFirstName.getText().trim().isEmpty() || textLastName.getText().trim().isEmpty() || textEmpMail.getText().trim().isEmpty() || textEmpPhone.getText().trim().isEmpty() || textEmpManager.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silahkan isi semua data terlebih dahulu");

            //        } else if (jCountry.getSelectedIndex() == 0) {
            //            JOptionPane.showMessageDialog(null, "Anda belum memilih Country");
            //
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menyimpan data? ", "confirm Save ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, iec.save(textEmpId.getText(), textFirstName.getText(), textLastName.getText(), textEmpMail.getText(), textEmpPhone.getText(), textEmpManager.getText()));
                //updateTableEmp("");
                resetTextEmp();
            }
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        resetTextEmp();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin melakukan delete? ", "confirm delete ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, iec.delete(textEmpId.getText()));
            updateTableEmp("");
            resetTextEmp();
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void lblClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickMouseClicked
        String username = textFirstName.getText()+" "+textLastName.getText();
        String iduser = textEmpId.getText();
        JIAccount jIAccount = new JIAccount(username, iduser);
        this.jLayerEmp.add(jIAccount);
        jIAccount.show();
    }//GEN-LAST:event_lblClickMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayerEmp;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClick;
    private javax.swing.JLabel lblEmpId;
    private javax.swing.JLabel lblEmpMail;
    private javax.swing.JLabel lblEmpManager;
    private javax.swing.JLabel lblEmpPhone;
    private javax.swing.JLabel lblEmpStatus;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTextField textEmpId;
    private javax.swing.JTextField textEmpMail;
    private javax.swing.JTextField textEmpManager;
    private javax.swing.JTextField textEmpPhone;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
