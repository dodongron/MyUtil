/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.HelpScrollToView;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import synutil.output.S1_to;

/**
 *
 * @author Dummy
 */
public class Dashboard extends javax.swing.JDialog {

    /**
     * Creates new form Dashboard
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dashboard(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dashboard(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dashboard() {
        super();
        initComponents();
        myInit();

    }
    private Dashboard myRef;

    private void setThisRef(Dashboard myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dashboard> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dashboard create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dashboard create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dashboard dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dashboard((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dashboard dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dashboard((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dashboard dialog = Dashboard.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);
//        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
            initComponents();
            myInit();
            repaint();
        }


    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_columns = new javax.swing.JTable();
        cb_database = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_select = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        tf_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_code = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        tbl_columns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_columns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_columnsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_columns);

        cb_database.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_database.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_databaseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHOOSE DATABASE");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_password.setText("password");

        jLabel2.setText("PASSWORD:");

        tf_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_username.setText("root");

        jLabel3.setText("USER:");

        cb_select.setSelected(true);
        cb_select.setText("UNCHECK ALL");
        cb_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selectActionPerformed(evt);
            }
        });

        jButton7.setText("CONNECT");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cb_database, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(tf_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(tf_username))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(cb_select)
                        .addGap(13, 13, 13)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_database, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_select)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("INSERT");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SELECT- LIST");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("TABLE");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("TO");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setText("SELECT- TO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("TABLE DATA");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));

        tf_code.setColumns(20);
        tf_code.setLineWrap(true);
        tf_code.setRows(5);
        jScrollPane3.setViewportView(tf_code);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        set_database();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cb_databaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_databaseActionPerformed
        // TODO add your handling code here:
        data_tables();
    }//GEN-LAST:event_cb_databaseActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_tables();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_tbl_tablesMouseClicked

    private void tbl_columnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_columnsMouseClicked
        do_check();
    }//GEN-LAST:event_tbl_columnsMouseClicked

    private void cb_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selectActionPerformed
        do_uncheck();
    }//GEN-LAST:event_cb_selectActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        set_to();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        set_insert();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        set_edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        set_delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        set_table();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        set_select();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        set_select_to();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        table_data();
    }//GEN-LAST:event_jButton9ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_database;
    private javax.swing.JCheckBox cb_select;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_columns;
    private javax.swing.JTable tbl_tables;
    private javax.swing.JTextArea tf_code;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_database();
        init_tbl_tables();
        init_tbl_columns();
    }

    public void do_pass() {
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    private void set_database() {
        String user = tf_username.getText();
        String password = tf_password.getText();
        cb_database.setModel(new ListComboBoxModel(S1_set.get_databases(user, password)));
        AutoCompleteDecorator.decorate(cb_database);
    }
    private ArrayListModel tbl_table_ALM;
    private TbltableModel tbl_table_M;
////    

    private void init_tbl_tables() {
        tbl_table_ALM = new ArrayListModel();
        tbl_table_M = new TbltableModel(tbl_table_ALM);

        tbl_tables.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_tables.setModel(tbl_table_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables.setRowHeight(25);

//        tbl_advances.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_accounts[i]);

        }
        Dimension d = tbl_tables.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_tables.getTableHeader().
                setPreferredSize(d);
        tbl_tables.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_tables.setRowHeight(35);
        tbl_tables.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tables(List<S1_set.to_tables> acc) {
        tbl_table_ALM.clear();
        tbl_table_ALM.addAll(acc);
    }

    public static class TbltableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "TABLE"
        };

        public TbltableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_set.to_tables tt = (S1_set.to_tables) getRow(row);

            switch (col) {

                default:
                    return tt.name;
            }
        }
    }

    private void data_tables() {
        if (cb_database.getItemCount() == 0) {
            return;
        }
        String database = cb_database.getSelectedItem().
                toString();
        String user = tf_username.getText();
        String password = tf_password.getText();
        String search = tf_search.getText();
//         JOptionPane.showMessageDialog(null,ad_id);
        loadData_tables(S1_set.get_tables(user, password, database, search));
    }
    private ArrayListModel tbl_colll_ALM;
    private TblcolModel tbl_col_M;
////    

    private void init_tbl_columns() {
        tbl_colll_ALM = new ArrayListModel();
        tbl_col_M = new TblcolModel(tbl_colll_ALM);

        tbl_columns.getTableHeader().
                setPreferredSize(new Dimension(100, 40));

        tbl_columns.setModel(tbl_col_M);
        tbl_columns.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_columns.setRowHeight(25);

//        tbl_advances.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {100, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_columns, i, tbl_widths_accounts[i]);

        }
        Dimension d = tbl_columns.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_columns.getTableHeader().
                setPreferredSize(d);
        tbl_columns.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));

        tbl_columns.setRowHeight(35);
        tbl_columns.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_advances(List<S1_set.to_col> acc) {
        tbl_colll_ALM.clear();
        tbl_colll_ALM.addAll(acc);
    }

    public static class TblcolModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "NAME", "TYPE", "STATUS"
        };

        public TblcolModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            if (col == 2) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_set.to_col tt = (S1_set.to_col) getRow(row);

            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.type;


                default:
                    return tt.check;
            }
        }
    }

    private void data_cols() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        String database = cb_database.getSelectedItem().
                toString();
        String user = tf_username.getText();
        String password = tf_password.getText();
        String search = tf_search.getText();
        loadData_advances(S1_set.get_columns(user, password, database, table_name));
    }

    private void do_check() {
        int row = tbl_columns.getSelectedRow();
        if (row < 0) {
            return;
        }
        boolean check = Boolean.parseBoolean(tbl_columns.getModel().
                getValueAt(row, 2).
                toString());

        if (check == false) {
            check = true;
        } else {
            check = false;
        }

        S1_set.to_col order = (S1_set.to_col) tbl_colll_ALM.get(tbl_columns.
                convertRowIndexToModel(row));
        order.setCheck(check);

        tbl_col_M.fireTableDataChanged();

        tbl_columns.getSelectionModel().
                setSelectionInterval(row, row);
        HelpScrollToView.view(row, tbl_columns);

    }

    private void do_uncheck() {

        int row = tbl_columns.getRowCount();
        if (row == 0) {
            return;
        }
        boolean check = false;
        if (cb_select.getText().
                equals("UNCHECK ALL")) {
            check = false;
            cb_select.setText("CHECK ALL");
        } else {
            check = true;
            cb_select.setText("UNCHECK ALL");
        }
        for (int i = 0; i < row; i++) {

            S1_set.to_col order = (S1_set.to_col) tbl_colll_ALM.get(tbl_columns.
                    convertRowIndexToModel(i));
            order.setCheck(check);

            tbl_col_M.fireTableDataChanged();
        }
    }

    private void set_to() {
        List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        String database = cb_database.getSelectedItem().
                toString();

        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }
        String text = S1_to.set_to(datas2, database, table_name);
        tf_code.setText(text);
    }

    private void set_insert() {
        List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        String database = cb_database.getSelectedItem().
                toString();

        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }

        String text = S1_to.insert(datas2, database, table_name);
        tf_code.setText(text);
    }

    private void set_edit() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();

        List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }

        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }

        Window p = (Window) this;
        Dlg_where2 nd = Dlg_where2.create(p, true);
        nd.setTitle("");
        nd.do_pass(pass, table_name);
        nd.setCallback(new Dlg_where2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_where2.OutputData data) {
                String text = S1_to.edit(datas2, database, table_name, data.to_types);
                tf_code.setText(text);
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void set_delete() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();
        final List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }

        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }

        Window p = (Window) this;
        Dlg_where2 nd = Dlg_where2.create(p, true);
        nd.setTitle("");
        nd.do_pass(pass, table_name);
        nd.setCallback(new Dlg_where2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_where2.OutputData data) {
                String text = S1_to.delete(datas2, database, table_name, data.to_types);
                tf_code.setText(text);
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void set_table() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();
        final List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }
        String text = S1_to.table(datas, database, table_name, new ArrayList());
        tf_code.setText(text);
    }

    private void set_select() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();
        final List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }
        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }
        Window p = (Window) this;
        Dlg_where2 nd = Dlg_where2.create(p, true);
        nd.setTitle("");
        nd.do_pass(pass, table_name);
        nd.setCallback(new Dlg_where2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_where2.OutputData data) {
                String text = S1_to.select_list(datas, database, table_name, data.to_types);
                tf_code.setText(text);
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void set_select_to() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();
        final List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }
        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }
        Window p = (Window) this;
        Dlg_where2 nd = Dlg_where2.create(p, true);
        nd.setTitle("");
        nd.do_pass(pass, table_name);
        nd.setCallback(new Dlg_where2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_where2.OutputData data) {
                String text = S1_to.select_to(datas, database, table_name, data.to_types);
                tf_code.setText(text);
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void table_data() {
        final List<S1_set.to_col> datas = tbl_colll_ALM;
        if (datas.isEmpty()) {
            return;
        }
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String table_name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String database = cb_database.getSelectedItem().
                toString();
        final List<String> pass = new ArrayList();
        for (S1_set.to_col t : datas) {
//            if (t.check == true) {
            pass.add(t.name);
//            }

        }
        final List<S1_set.to_col> datas2 = new ArrayList();
        for (S1_set.to_col t : datas) {
            if (t.check == true) {
                S1_set.to_col t1 = new S1_set.to_col(t.name, t.type, true);
                datas2.add(t1);
            }
        }
        String text = S1_to.data_table(datas, database, table_name);
        tf_code.setText(text);


    }
}
