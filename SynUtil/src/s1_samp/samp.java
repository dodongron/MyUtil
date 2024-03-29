/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s1_samp;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
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
public class samp extends javax.swing.JDialog {

    /**
     * Creates new form samp
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
    private samp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private samp(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public samp() {
        super();
        initComponents();
        myInit();

    }
    private samp myRef;

    private void setThisRef(samp myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, samp> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static samp create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static samp create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            samp dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new samp((java.awt.Frame) parent, false);
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
            samp dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new samp((java.awt.Dialog) parent, false);
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


        samp dialog = samp.create(new javax.swing.JFrame(), true);
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
        tbl_tangeble = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_tangeble.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_tangeble);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_tangeble;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_tangeble();
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

    public static class to_tangeble {

        public final String id;
        public final String tancat;
        public final String tandesc;
        public final String tanlife;

        public to_tangeble(String id, String tancat, String tandesc, String tanlife) {
            this.id = id;
            this.tancat = tancat;
            this.tandesc = tandesc;
            this.tanlife = tanlife;
        }
    }
    private ArrayListModel tbl_tangeble_ALM;
    private TbltangebleModel tbl_tangeble_M;

    private void init_tbl_tangeble() {
        tbl_tangeble_ALM = new ArrayListModel();
        tbl_tangeble_M = new TbltangebleModel(tbl_tangeble_ALM);
        tbl_tangeble.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_tangeble.setModel(tbl_tangeble_M);
        tbl_tangeble.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tangeble.setRowHeight(25);
        int[] tbl_widths_tangeble = {0, 100, 100, 100};
        for (int i = 0, n = tbl_widths_tangeble.length; i < n; i++) {
            if (i == 100) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tangeble, i, tbl_widths_tangeble[i]);
        }
        Dimension d = tbl_tangeble.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_tangeble.getTableHeader().
                setPreferredSize(d);
        tbl_tangeble.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_tangeble.setRowHeight(35);
        tbl_tangeble.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tangeble(List<to_tangeble> acc) {
        tbl_tangeble_ALM.clear();
        tbl_tangeble_ALM.addAll(acc);
    }

    public static class TbltangebleModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "tancat", "tandesc", "tanlife"
        };

        public TbltangebleModel(ListModel listmodel) {
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
            to_tangeble tt = (to_tangeble) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.tancat;
                case 2:
                    return tt.tandesc;
                default:
                    return tt.tanlife;
            }
        }
    }

    private void data_cols() {
        loadData_tangeble(new ArrayListModel());
    }
}