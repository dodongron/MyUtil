/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_add_table extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_add_table
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

        public final String table_name;
        public final String text;
        public final String text2;

        public OutputData(String table_name, String text, String text2) {
            this.table_name = table_name;
            this.text = text;
            this.text2 = text2;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_add_table(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_add_table(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_add_table() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_add_table myRef;

    private void setThisRef(Dlg_add_table myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_add_table> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_add_table create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_add_table create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_add_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_table((java.awt.Frame) parent, false);
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
            Dlg_add_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_table((java.awt.Dialog) parent, false);
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


        Dlg_add_table dialog = Dlg_add_table.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_col_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tf_table_name = new javax.swing.JTextField();
        lbl_check = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TABLE NAME:");

        tbl_table.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_table);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TYPE:");

        tf_col_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_col_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_col_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_col_nameFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("COLUMN NAME:");

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "varchar(100)", "varchar(500)", "int", "double", "date", "datetime", "float" }));

        jButton3.setText("ADD");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("EDIT");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("DELETE");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CLEAR");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tf_table_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_table_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_table_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_table_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_table_nameFocusLost(evt);
            }
        });

        lbl_check.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_check.setText("X");
        lbl_check.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_col_name, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_table_name, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_check, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_table_name, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lbl_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_col_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_to_table();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tableMouseClicked
        get_click();
    }//GEN-LAST:event_tbl_tableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        edit_to_table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clear();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        delete_to_table();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_table_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_table_nameFocusLost
    }//GEN-LAST:event_tf_table_nameFocusLost

    private void tf_table_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_table_nameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_table_nameFocusGained

    private void tf_col_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_col_nameFocusGained
        check_table();
    }//GEN-LAST:event_tf_col_nameFocusGained
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_check;
    private javax.swing.JTable tbl_table;
    private javax.swing.JTextField tf_col_name;
    private javax.swing.JTextField tf_table_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();

        init_tbl_table();

        List<to_table> datas = new ArrayList();
        to_table to = new to_table("id", "int", "auto_increment primary key");
        datas.add(to);
        loadData_table(datas);
    }
    String database = "a";
    String user = "root";
    String password = "password";

    public void do_pass(String us, String pass, String db) {
        database = db;
        user = us;
        password = pass;
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

    public static class to_table {

        public String name;
        public String data_type;
        public String remarks;

        public to_table(String name, String data_type, String remarks) {
            this.name = name;
            this.data_type = data_type;
            this.remarks = remarks;
        }

        public String getData_type() {
            return data_type;
        }

        public void setData_type(String data_type) {
            this.data_type = data_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }
    private ArrayListModel tbl_table_ALM;
    private TbltableModel tbl_table_M;

    private void init_tbl_table() {
        tbl_table_ALM = new ArrayListModel();
        tbl_table_M = new TbltableModel(tbl_table_ALM);
        tbl_table.getTableHeader().
                setPreferredSize(new Dimension(100, 100));
        tbl_table.setModel(tbl_table_M);
        tbl_table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_table.setRowHeight(25);
        int[] tbl_widths_table = {100, 100, 0};
        for (int i = 0, n = tbl_widths_table.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_table, i, tbl_widths_table[i]);
        }
        Dimension d = tbl_table.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_table.getTableHeader().
                setPreferredSize(d);
        tbl_table.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_table.setRowHeight(35);
        tbl_table.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_table(List<to_table> acc) {
//        tbl_table_ALM.clear();
        tbl_table_ALM.addAll(acc);
    }

    public static class TbltableModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "NAME", "DATA TYPE", "remarks"
        };

        public TbltableModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_table tt = (to_table) getRow(row);
            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.data_type;
                default:
                    return tt.remarks;
            }
        }
    }

    private void data_cols() {
        loadData_table(new ArrayListModel());
    }

    private void add_to_table() {
        if (tf_col_name.getText().
                isEmpty()) {
            return;
        }
        List<to_table> datas = new ArrayList();
        List<to_table> my = tbl_table_ALM;
        String col_name = tf_col_name.getText();
        String type = cb_type.getSelectedItem().
                toString();
        for (to_table to : my) {
            if (to.name.equals(col_name)) {
                JOptionPane.showMessageDialog(null, "Column Already Exists");
                return;
            }
        }
        to_table to = new to_table(col_name, type, "");
        datas.add(to);
        loadData_table(datas);
        clear();
    }

    private void get_click() {
        int idx = tbl_table.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_table to = (to_table) tbl_table_ALM.get(tbl_table.
                convertRowIndexToModel(idx));
        tf_col_name.setText(to.name);
        cb_type.setSelectedItem(to.data_type);
    }

    private void edit_to_table() {
        int idx = tbl_table.getSelectedRow();
        if (idx < 0) {
            return;
        }
        String col_name = tf_col_name.getText();
        String type = cb_type.getSelectedItem().
                toString();

        final to_table to = (to_table) tbl_table_ALM.get(tbl_table.
                convertRowIndexToModel(idx));
        if (tf_col_name.getText().
                isEmpty()) {
            return;
        }
        to.setName(col_name);
        to.setData_type(type);
        tbl_table_M.fireTableDataChanged();
        clear();
    }

    private void delete_to_table() {
        int[] idx = tbl_table.getSelectedRows();
        List rem = new ArrayList();
        for (int ix : idx) {
            if (tbl_table.isRowSelected(ix)) {
                int mx = tbl_table.convertRowIndexToModel(ix);
                rem.add(tbl_table_ALM.get(mx));
            }
        }
        tbl_table_ALM.removeAll(rem);
        tbl_table_M.fireTableDataChanged();
    }

    private void clear() {
        tf_col_name.setText("");
    }

    private void ok1() {
        String table_name = tf_table_name.getText();
        String text = "";
        String text2 = "";
        text2 = text2 + "drop table if exists " + database + "." + table_name + "; \n";
        text = text + "create table " + database + "." + table_name + "( ";
        text2 = text2 + "create table " + database + "." + table_name + "( \n";

        String columns = "";
        String columns2 = "";
        List<to_table> my = tbl_table_ALM;

        int i = 0;
        for (to_table to : my) {
            if (i == 0) {
                columns = columns + "" + to.name + " " + to.data_type + " " + to.remarks + "";
                columns2 = columns2 + "" + to.name + " " + to.data_type + " " + to.remarks + "\n";
            } else {
                columns = columns + "," + to.name + " " + to.data_type + " " + to.remarks + "";
                columns2 = columns2 + "," + to.name + " " + to.data_type + " " + to.remarks + "\n";
            }
            i++;
        }
        text = text + columns + ");";
        text2 = text2 + columns2 + ");";
//        System.out.println(text);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(table_name, text, text2));
        }
    }

    private void check_table() {
        if (tf_table_name.getText().
                isEmpty()) {
            return;
        }
        boolean exists = S1_set.check_table(user, password, database, tf_table_name.
                getText());
        System.out.println(exists);
        if (exists == false) {
            lbl_check.setText("OK");
//            tf_table_name.grabFocus();
        } else {
            lbl_check.setText("X");
        }
    }
}
