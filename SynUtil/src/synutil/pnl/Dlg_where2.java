/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
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
public class Dlg_where2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_where
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

        public final List<to_where> to_types;

        public OutputData(List<to_where> to_types) {
            this.to_types = to_types;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_where2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_where2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_where2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_where2 myRef;

    private void setThisRef(Dlg_where2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_where2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_where2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_where2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_where2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_where2((java.awt.Frame) parent, false);
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
            Dlg_where2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_where2((java.awt.Dialog) parent, false);
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_where2 dialog = Dlg_where2.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_list = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jl_sel = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_output = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jl_list.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jl_list);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jl_sel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_sel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_selMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jl_sel);

        tbl_output.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_output.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_outputMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_output);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jl_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_listMouseClicked
        // TODO add your handling code here:
//        choose();
        add_entry();
    }//GEN-LAST:event_jl_listMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jl_selMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_selMouseClicked
//        remove();
        add_entry();
    }//GEN-LAST:event_jl_selMouseClicked

    private void tbl_outputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_outputMouseClicked
        delete();
    }//GEN-LAST:event_tbl_outputMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList jl_list;
    private javax.swing.JList jl_sel;
    private javax.swing.JTable tbl_output;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
//        init_where();
        init_tbl_output();
//        datas.add("=");
//        datas.addElement("=");
//        jl_sel.setModel(datas);
    }

    private void init_where() {

        where.addElement("=");
        where.addElement("LIKE");
        where.addElement("NOT LIKE");
        where.addElement("BETWEEN");
        where.addElement(">");
        where.addElement(">=");

        where.addElement("<");
        where.addElement("<=");
        where.addElement("<>");
        jl_list.setModel(where);
    }
    String table_name = "";

    public void do_pass(List<String> data, String table_names) {
        datas.clear();
        where.clear();
        init_where();
        for (String s : data) {
            datas.addElement(s);
            jl_sel.setModel(datas);

        }
        table_name = table_names;
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
    DefaultListModel datas = new DefaultListModel();
    DefaultListModel where = new DefaultListModel();

    private void choose() {
        int row = jl_list.getSelectedIndex();
        if (row < 0) {
            return;
        }
        String type = jl_list.getModel().
                getElementAt(row).
                toString();
        datas.addElement(type);
        jl_sel.setModel(datas);

    }

    private void remove() {
        int row = jl_sel.getSelectedIndex();
        if (row < 0) {
            return;
        }
//        String type = jl_list.getModel().
//                getElementAt(row).
//                toString();
        datas.removeElementAt(row);
        jl_sel.setModel(datas);

    }

    private void ok1() {
        List<to_where> data = new ArrayList();

        int row = tbl_employee_payroll_ALM.size();
        for (int i = 0; i < row; i++) {
            String name = tbl_output.getModel().
                    getValueAt(i, 0).
                    toString();
            String name2 = tbl_output.getModel().
                    getValueAt(i, 1).
                    toString();
            toString();
            String output = tbl_output.getModel().
                    getValueAt(i, 2).
                    toString();
            to_where t = new to_where(name, name2, output);
            data.add(t);
        }

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(data));
        }
    }

    public static class to_where {

        public final String name;
        public final String name2;
        public final String output;

        public to_where(String name, String name2, String output) {
            this.name = name;
            this.name2 = name2;
            this.output = output;
        }
    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_output() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);

        tbl_output.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_output.setModel(tbl_employee_payroll_M);
        tbl_output.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_output.setRowHeight(25);

//        tbl_advances.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 100, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_output, i, tbl_widths_accounts[i]);

        }
        Dimension d = tbl_output.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_output.getTableHeader().
                setPreferredSize(d);
        tbl_output.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_output.setRowHeight(35);
        tbl_output.setFont(new java.awt.Font("Arial", 1, 14));
    }

    private void loadData_advances(List<to_where> acc) {
//        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "name1", "", "output"
        };

        public TblInvoicesModel(ListModel listmodel) {
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
            to_where tt = (to_where) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.name2;

            default:
                return tt.output;
            }
        }
    }

    private void add_entry() {
        int row = jl_sel.getSelectedIndex();
        if (row < 0) {
            return;
        }
        String column = datas.getElementAt(row).
                toString();

        int row2 = jl_list.getSelectedIndex();
        if (row2 < 0) {
            return;
        }

        String column2 = where.getElementAt(row2).
                toString();

        String output = "";
        List<to_where> acc = new ArrayList();
        String quote = "";
        if (tbl_employee_payroll_ALM.isEmpty()) {
            quote = "   +\" ";
        } else {
            quote = "   +\" and ";
        }
        if (column2.equals("=")) {
            output = quote + column + " ='\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals("LIKE")) {
            output = quote + column + " like'%\"+to_" + table_name + "." + column + "+\"%' \"";
        }
        if (column2.equals("NOT LIKE")) {
            output = quote + column + " not like'%\"+to_" + table_name + "." + column + "+\"%' \"";
        }
        if (column2.equals("BETWEEN")) {
            output = quote + column + " between '\"+to_" + table_name + "." + column + "+\"' and '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals(">")) {
            output = quote + column + " > '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals(">=")) {
            output = quote + column + " >= '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals("<")) {
            output = quote + column + " < '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals("<=")) {
            output = quote + column + " <= '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        if (column2.equals("<>")) {
            output = quote + column + " <> '\"+to_" + table_name + "." + column + "+\"' \"";
        }
        to_where to = new to_where(column2, column + " " + column2, output);
        acc.add(to);
//         JOptionPane.showMessageDialog(null,ad_id);
        loadData_advances(acc);
        tbl_employee_payroll_M.fireTableDataChanged();
//        jl_list.setSelectedIndex(-1);
//        jl_sel.setSelectedIndex(-1);
        jl_sel.removeSelectionInterval(row, row);
        jl_list.removeSelectionInterval(row2, row2);
//        jl_list.transferFocus();
//        tbl_output.grabFocus();
    }

    private void delete() {
        int row = tbl_output.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_employee_payroll_ALM.remove(row);
        tbl_employee_payroll_M.fireTableDataChanged();
//        loadData_advances(tbl_employee_payroll_ALM);
    }
}
