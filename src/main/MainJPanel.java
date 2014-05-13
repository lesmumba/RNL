/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import rnl.*;

/**
 *
 * @author clough
 */
public class MainJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    JFrame mainJFrame; 
    public MainJPanel(JFrame mainJFrame) {
        initComponents();
        this.mainJFrame = mainJFrame;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        passwordJField = new javax.swing.JPasswordField();
        emailJFrield = new javax.swing.JTextField();

        jLabel1.setText("Email");

        jLabel2.setText("Password");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RNL Login");

        loginJButton.setText("Login");
        loginJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginJButtonMouseClicked(evt);
            }
        });

        passwordJField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordJFieldKeyPressed(evt);
            }
        });

        emailJFrield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailJFrieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordJField)
                            .addComponent(emailJFrield, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailJFrield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(loginJButton)
                .addContainerGap(254, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginJButtonMouseClicked
        /*
        *If the login button is clicked then collect data entered in form and
        *login user.
        */
        String email = emailJFrield.getText();
        String password = new String(passwordJField.getPassword());
        
        int user_id = Auth.login(email,password);
        if(user_id == -1)  {
            JOptionPane.showMessageDialog(mainJFrame, 
                    "Username or password is not correct.",
                    "Login Error",  JOptionPane.ERROR_MESSAGE);
        }
        else {
        /*
        * From the user id get the user type and redirect them to the correct
        * main page
        */        
            String user_type = User.getType(user_id);
            switch(user_type){
                case "admin":
                    break;
                case "csa":
                    RegularCSA csaUser = new RegularCSA(user_id);
                    
                    //if its a CSA then destroy the current pannel and open another
                    mainJFrame.getContentPane().remove(this);

                    CSAMainMenu csaMainMenu = new CSAMainMenu(mainJFrame,csaUser);
                    mainJFrame.getContentPane().add(csaMainMenu);

                    mainJFrame.getContentPane().invalidate();
                    mainJFrame.getContentPane().revalidate();
                    mainJFrame.getContentPane().repaint();
                    break;
                case "customer":
                    break;
                case "merchant":
                    break;
            }            
        }               
    }//GEN-LAST:event_loginJButtonMouseClicked

    private void emailJFrieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailJFrieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.loginJButtonMouseClicked(null);
        } 
    }//GEN-LAST:event_emailJFrieldKeyPressed

    private void passwordJFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.loginJButtonMouseClicked(null);
        } 
    }//GEN-LAST:event_passwordJFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailJFrield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPasswordField passwordJField;
    // End of variables declaration//GEN-END:variables
}
