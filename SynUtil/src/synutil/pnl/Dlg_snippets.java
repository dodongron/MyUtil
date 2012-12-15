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
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synutil.test.S2_snippets;
import synutil.test.S2_snippets.to_codes;

/**
 *
 * @author i1
 */
public class Dlg_snippets extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_snippets
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
    private Dlg_snippets(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_snippets(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_snippets() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_snippets myRef;

    private void setThisRef(Dlg_snippets myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_snippets> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_snippets create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_snippets create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_snippets dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_snippets((java.awt.Frame) parent, false);
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
            Dlg_snippets dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_snippets((java.awt.Dialog) parent, false);
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


        Dlg_snippets dialog = Dlg_snippets.create(new javax.swing.JFrame(), true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_codes = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_code = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_codes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_codes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_codesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_codes);

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel1.setText("SEARCH:");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tf_code.setColumns(20);
        tf_code.setLineWrap(true);
        tf_code.setRows(5);
        jScrollPane3.setViewportView(tf_code);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_snippet();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_codesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_codesMouseClicked
        click();
    }//GEN-LAST:event_tbl_codesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_snippet();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       delete_snippet();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_codes;
    private javax.swing.JTextArea tf_code;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_codes();
        data_cols();
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
    private ArrayListModel tbl_codes_ALM;
    private TblcodesModel tbl_codes_M;

    private void init_tbl_codes() {
        tbl_codes_ALM = new ArrayListModel();
        tbl_codes_M = new TblcodesModel(tbl_codes_ALM);
        tbl_codes.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_codes.setModel(tbl_codes_M);
        tbl_codes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_codes.setRowHeight(25);
        int[] tbl_widths_codes = {0, 100, 0};
        for (int i = 0, n = tbl_widths_codes.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_codes, i, tbl_widths_codes[i]);
        }
        Dimension d = tbl_codes.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_codes.getTableHeader().
                setPreferredSize(d);
        tbl_codes.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_codes.setRowHeight(35);
        tbl_codes.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_codes(List<to_codes> acc) {
        tbl_codes_ALM.clear();
        tbl_codes_ALM.addAll(acc);
    }

    public static class TblcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "name", "code"
        };

        public TblcodesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//            if (column == 1) {
//                return true;
//            }
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
            to_codes tt = (to_codes) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.name;
                default:
                    return tt.code;
            }
        }
    }

    private void data_cols() {
        loadData_codes(S2_snippets.ret_data(tf_search.getText()));
    }

    private void add_snippet() {
        Window p = (Window) this;
        Dlg_add_snippet nd = Dlg_add_snippet.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_add_snippet.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_snippet.OutputData data) {
                closeDialog.ok();
                to_codes to = new to_codes(0, data.name, data.code);
                S2_snippets.add_data(to);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void click() {
        int row = tbl_codes.getSelectedRow();
        if (row < 0) {
            return;
        }
        int id = FitIn.toInt(tbl_codes.getModel().
                getValueAt(row, 0).
                toString());
        String name = (tbl_codes.getModel().
                getValueAt(row, 1).
                toString());
        String code = (tbl_codes.getModel().
                getValueAt(row, 2).
                toString());
        tf_code.setText(code);
    }

    private void edit_snippet() {
        int row = tbl_codes.getSelectedRow();
        if (row < 0) {
            return;
        }
        final int id = FitIn.toInt(tbl_codes.getModel().
                getValueAt(row, 0).
                toString());
        String name = (tbl_codes.getModel().
                getValueAt(row, 1).
                toString());
        String code = (tbl_codes.getModel().
                getValueAt(row, 2).
                toString());
        final to_codes to = new to_codes(id, name, code);
        Window p = (Window) this;
        Dlg_add_snippet nd = Dlg_add_snippet.create(p, true);
        nd.setTitle("");
        nd.do_pass(name, code);
        nd.setCallback(new Dlg_add_snippet.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_snippet.OutputData data) {
                closeDialog.ok();
                to_codes to = new to_codes(id, data.name, data.code);
                tf_code.setText(data.code);
                S2_snippets.edit_data(to);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void delete_snippet() {
        int row = tbl_codes.getSelectedRow();
        if (row < 0) {
            return;
        }
        final int id = FitIn.toInt(tbl_codes.getModel().
                getValueAt(row, 0).
                toString());
        String name = (tbl_codes.getModel().
                getValueAt(row, 1).
                toString());
        String code = (tbl_codes.getModel().
                getValueAt(row, 2).
                toString());
        final to_codes to = new to_codes(id, name, code);
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
        nd.do_pass("Sure Bah");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();
            }
            @Override
            public void cont(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();
                to_codes to = new to_codes(id, "", "");
                tf_code.setText("");
                S2_snippets.delete_data(to);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
