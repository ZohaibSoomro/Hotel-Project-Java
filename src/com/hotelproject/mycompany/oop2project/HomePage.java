/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hotelproject.mycompany.oop2project;

import com.hotelproject.dao.Connect;
import com.hotelproject.helper.BookingRoom;
import com.hotelproject.helper.Guest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Shahad Adel
 */
public class HomePage extends javax.swing.JFrame {

    private Guest guest;

    /**
     * Creates new form HomePage
     */
    public HomePage(Guest guest) {
        this.guest = guest;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelproject/icons/Green_and_Beige_Simple_Hotel_Logo-1_450x400_100x80.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 250, 234));

        jPanel2.setBackground(new java.awt.Color(250, 250, 234));

        jButton1.setBackground(new java.awt.Color(44, 70, 69));
        jButton1.setForeground(new java.awt.Color(250, 250, 234));
        jButton1.setText("Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(44, 70, 69));
        jButton2.setForeground(new java.awt.Color(250, 250, 234));
        jButton2.setText("Resevitions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(44, 70, 69));
        jButton3.setForeground(new java.awt.Color(250, 250, 234));
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelproject/icons/user_1_28x23.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelproject/icons/bedroom.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelproject/icons/home.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 234));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome ");
        jLabel5.setToolTipText("");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("We are honored that you choose to stay at our hotel.");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("I'd like to send a very warm greeting on behalf of the entire staff at The Hotel ");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("and I hope your stay will be both pleasant and pleasurable. The hotel offfers range of business facilities and services. ");

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel9.setText("Please do not hesitate to contact me at extension if you need any help or have any special needs ( 9999 ).");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel10.setText("To start your resevition please click the book button and thank you for choosing us.");

        jButton4.setBackground(new java.awt.Color(44, 70, 69));
        jButton4.setForeground(new java.awt.Color(250, 250, 234));
        jButton4.setText("Booking");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelproject/icons/without bg.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Account(this.guest).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Booking(this.guest).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (BookingRoom.isHaveBooking(this.guest.getUserID())) {
            if (this.guest.getCheckIn()) {
                this.dispose();
                new Reservation(this.guest).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Please Check In first!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "For using services you should have booking in Hotel. Please book room first!");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Index().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

//    public boolean requestBetweenGuestAndHotelServices(String userID, int bookingID) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO requestgandh(UserID, BookingID) Value(?,?);");
//            ps.setString(1, userID);
//            ps.setInt(2, bookingID);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestBetweenBookingRoomAndGymServices(int roomNo, int bookingID) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO requestrandg(RoomNo, BookingID) Value(?,?);");
//            ps.setInt(1, roomNo);
//            ps.setInt(2, bookingID);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestBetweenBookingRoomAndSpaServices(int roomNo, int bookingID) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO requestrands(RoomNo, BookingID) Value(?,?);");
//            ps.setInt(1, roomNo);
//            ps.setInt(2, bookingID);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestBetweenBookingRoomAndKitchenServices(int roomNo, int bookingID) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO requestrandk(RoomNo, BookingID) Value(?,?);");
//            ps.setInt(1, roomNo);
//            ps.setInt(2, bookingID);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestForHotelServices(int bookingID, double price, String item) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO hotelservices(BookingID, Price, Item) Value(?,?,?);");
//            ps.setInt(1, bookingID);
//            ps.setDouble(2, price);
//            ps.setString(3, item);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestForGYMServices(int bookingID, double price, String item) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO gymervices(BookingID, Price, Item) Value(?,?,?);");
//            ps.setInt(1, bookingID);
//            ps.setDouble(2, price);
//            ps.setString(3, item);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestForKitchenServices(int bookingID, double price, String item) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO kitchenservice(BookingID, Price, Item) Value(?,?,?);");
//            ps.setInt(1, bookingID);
//            ps.setDouble(2, price);
//            ps.setString(3, item);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
//
//    public boolean requestForSpaServices(int bookingID, double price, String item) {
//        try {
//            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO spaservices(BookingID, Price, Item) Value(?,?,?);");
//            ps.setInt(1, bookingID);
//            ps.setDouble(2, price);
//            ps.setString(3, item);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException exception) {
//
//        }
//        return false;
//    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomePage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
