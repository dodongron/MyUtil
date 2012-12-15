/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jdesktop.swingx.JXPanel;
import synutil.csv_insert.S3.to_encoded;

/**
 *
 * @author i1
 */
public class Dlg_csv extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_csv
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
    private Dlg_csv(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_csv(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_csv() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_csv myRef;

    private void setThisRef(Dlg_csv myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_csv> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_csv create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_csv create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_csv dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_csv((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_csv dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_csv((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
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


        Dlg_csv dialog = Dlg_csv.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
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
        tbl_encoded = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_file = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_book_no = new javax.swing.JTextField();
        pb_load = new javax.swing.JProgressBar();
        tf_years = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_encoded.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_encoded);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("SELECT FILE:");

        lbl_file.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_file.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EXCEL TO DATABASE (BETA - St. Catherine)");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("BOOK NO:");

        tf_book_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_book_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tf_years.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_years.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("YEARS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_file, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pb_load, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_book_no, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_years, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(tf_years, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(tf_book_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pb_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        popup();
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        show_dialog();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_file;
    private javax.swing.JProgressBar pb_load;
    private javax.swing.JTable tbl_encoded;
    private javax.swing.JTextField tf_book_no;
    private javax.swing.JTextField tf_years;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_encoded();

    }

    public void do_pass() {
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        ok1();   
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
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
    private ArrayListModel tbl_encoded_ALM;
    private TblencodedModel tbl_encoded_M;

    private void init_tbl_encoded() {
        tbl_encoded_ALM = new ArrayListModel();
        tbl_encoded_M = new TblencodedModel(tbl_encoded_ALM);
        tbl_encoded.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_encoded.setModel(tbl_encoded_M);
        tbl_encoded.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_encoded.setRowHeight(25);
        int[] tbl_widths_encoded = {50, 50, 200, 50, 200, 100, 100, 150, 150, 100, 100, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_encoded.length; i < n; i++) {
            if (i == 13) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_encoded, i, tbl_widths_encoded[i]);
        }
        Dimension d = tbl_encoded.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_encoded.getTableHeader().setPreferredSize(d);
        tbl_encoded.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_encoded.setRowHeight(35);
        tbl_encoded.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_encoded(List<to_encoded> acc) {
        tbl_encoded_ALM.clear();
        tbl_encoded_ALM.addAll(acc);
    }

    public static class TblencodedModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "page no", "index", "fname", "mi", "lname", "b_day", "b_place", "father", "mother", "address", "baptism", "minister", "sponsor", "notes", "ref_id"
        };

        public TblencodedModel(ListModel listmodel) {
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
            to_encoded tt = (to_encoded) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return FitIn.fmt_woc(tt.ref_id);
            case 2:
                return tt.fname;
            case 3:
                return tt.mi;
            case 4:
                return tt.lname;
            case 5:
                return tt.b_day;
            case 6:
                return tt.b_place;
            case 7:
                return tt.father;
            case 8:
                return tt.mother;
            case 9:
                return tt.address;
            case 10:
                return tt.baptism;
            case 11:
                return tt.minister;
            case 12:
                return tt.sponsor;
            case 13:
                return tt.notes;
            default:
                return tt.page_no;
            }
        }
    }

    private void add() {
        if (tbl_encoded_ALM.isEmpty() || tf_book_no.getText().isEmpty() || tf_years.getText().isEmpty()) {
            return;
        }


        List<S4_insert_to_db.to_parishioners_1> to_parishioners_1 = new ArrayList();
        List<S4_insert_to_db.to_baptism2> to_baptism2 = new ArrayList();
        List<S4_insert_to_db.to_baptism2_sponsors> to_baptism2_sponsors = new ArrayList();

        List<to_encoded> datas = tbl_encoded_ALM;
        int id = FitIn.toInt(S4_insert_to_db.increment_id_parishioners()) + 1;
        int spons_id = FitIn.toInt(S4_insert_to_db.increment_id_sponsors()) + 1;
        int i = 1;
        for (to_encoded to_encoded : datas) {
            int ref_id = to_encoded.page_no;
            String fname = to_encoded.fname;
            String mi = to_encoded.mi;
            if (mi.equals("^")) {
                mi = "";
            }
            String lname = to_encoded.lname;
            if (lname.equals("^")) {
                lname = "";
            }
            String date_of_baptism = to_encoded.baptism;
            if (date_of_baptism.equals("^")) {
                date_of_baptism = DateType.sf.format(new Date());
            }
            String date_of_birth = to_encoded.b_day;
            if (date_of_birth.equals("^")) {
                date_of_birth = DateType.sf.format(new Date());
            }
            String place_of_birth = to_encoded.b_place;
            if (place_of_birth.equals("^")) {
                place_of_birth = "";
            }
            String address1 = to_encoded.address;
            if (address1.equals("^")) {
                address1 = "";
            }
            String address2 = "";
            String city = "";
            String states = "";
            String zip_code = "";
            String father = to_encoded.father;
            if (father.equals("^")) {
                father = "";
            }
            String mother = to_encoded.mother;
            if (mother.equals("^")) {
                mother = "";
            }
            int is_baptized = 4;
            int is_comm = 0;
            int is_confirm = 0;
            int is_married = 0;
            int is_2nd_married = 0;
            int is_prof_faith = 0;
            int is_acceptance = 0;
            int is_death = 0;
            String date_added = DateType.datetime.format(new Date());
            int gender = 0;
            String bapt_place = "St. Catherine of Alexandia Parish";
            String b_date = to_encoded.baptism;
            if (b_date.equals("^")) {
                b_date = DateType.sf.format(new Date());
            }
            String b_book_no = tf_book_no.getText();
            int b_page_no = to_encoded.id;
            int b_index_no = i;
            String c_date = "1500-01-01";
            String c_book_no = "0";
            int c_page_no = 0;
            int c_index_no = 0;
            String m_date = "1500-01-01";
            String m_book_no = "0";
            int m_page_no = 0;
            int m_index_no = 0;
            String f_date = "1500-01-01";
            String f_book_no = "0";
            int f_page_no = 0;
            int f_index_no = 0;
            S4_insert_to_db.to_parishioners_1 to_parishioners_11 = new S4_insert_to_db.to_parishioners_1(ref_id, ref_id, fname, mi, lname, date_of_baptism, date_of_birth, place_of_birth, address1, address2, city, states, zip_code, father, mother, is_baptized, is_comm, is_confirm, is_married, is_2nd_married, is_prof_faith, is_acceptance, is_death, date_added, gender, bapt_place, b_date, b_book_no, b_page_no, b_index_no, c_date, c_book_no, c_page_no, c_index_no, m_date, m_book_no, m_page_no, m_index_no, f_date, f_book_no, f_page_no, f_index_no);
            to_parishioners_1.add(to_parishioners_11);

            int ref_no = to_encoded.page_no;
            String godfather = "";
            String p_godfather = "";
            String godmother = "";
            String p_godmother = "";
            String presider = "";
            String bapt_date = to_encoded.baptism;
            if (bapt_date.equals("^")) {
                bapt_date = DateType.sf.format(new Date());
            }

            String bapt_time = "8:00 am – 9:00 am";
            String bapt_church = "St. Catherine of Alexandia Parish";
            String priest = to_encoded.minister;
            String book_no = tf_book_no.getText();
            int page_no = to_encoded.id;
            String f_comm_date = "1500-01-01";
            String f_comm_church = "1500-01-01";
            String f_conf_date = "1500-01-01";
            String f_conf_church = "1500-01-01";
            int is_diaconate = 0;
            String diconate_date = "1500-01-01";
            int is_religious_prof = 0;
            String religious_prof_date = "1500-01-01";
            String remarks = to_encoded.notes;
            if (remarks.equals("^")) {
                remarks = "";
            }
            int status = 4;
            String years = tf_years.getText();
            int num = i;

            S4_insert_to_db.to_baptism2 to_baptism22 = new S4_insert_to_db.to_baptism2(ref_id, ref_no, fname, mi, lname, date_of_birth, place_of_birth, father, mother, godfather, p_godfather, godmother, p_godmother, presider, bapt_date, bapt_time, bapt_church, priest, book_no, page_no, f_comm_date, f_comm_church, f_conf_date, f_conf_church, is_diaconate, diconate_date, is_religious_prof, religious_prof_date, remarks, status, years, num);
            to_baptism2.add(to_baptism22);

            String sponsor = to_encoded.sponsor;
            S4_insert_to_db.to_baptism2_sponsors to_baptism2_sponsors1 = new S4_insert_to_db.to_baptism2_sponsors(spons_id, to_encoded.page_no, sponsor);
            to_baptism2_sponsors.add(to_baptism2_sponsors1);
            id++;
            i++;
            spons_id++;

        }

        S4_insert_to_db.add_data(to_parishioners_1, to_baptism2, to_baptism2_sponsors);

        tbl_encoded_ALM.clear();
        tbl_encoded_M.fireTableDataChanged();

        JOptionPane.showMessageDialog(null, "Successfully Added");
        tf_book_no.setText("");
        tf_years.setText("");
    }

    private void show_dialog() {
        FileDialog fd = new FileDialog(new JDialog(), "Choose .XLS FILE");
        fd.setVisible(true);
        String file = fd.getDirectory() + "" + fd.getFile();
        file = file.replace("\\", "\\\\");
        lbl_file.setText(file);
        if (file == null || file.isEmpty()) {
            return;
        }
        FileInputStream fis = null;
        List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unsupported Format");
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Dlg_csv.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        List<to_encoded> datas = S3.showExcelData(sheetData, file);
        loadData_encoded(datas);
    }

    private void popup() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        TransparentButton btn = new TransparentButton("");
        TransparentPopupMenu popup = new TransparentPopupMenu();
        popup.setLayout(new BorderLayout());
        popup.add(btn); // your component
        popup.setPopupSize(100, 100);
        popup.show(jButton2, 0, jButton2.getHeight());

//        PopupFactory factory = PopupFactory.getSharedInstance();

    }

    class TransparentButton extends JButton {

        public TransparentButton(String text) {
            super(text);
            setOpaque(false);
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            super.paint(g2);
            g2.dispose();
        }
    }

    class TransparentPopupMenu extends JPopupMenu {

        public TransparentPopupMenu() {
            super();
            setOpaque(false);
        }
    }

    class TransparentMenuItem extends JXPanel {

        public TransparentMenuItem(String text) {
            setOpaque(false);

        }

        private TransparentMenuItem(JXPanel jx_border) {
            jx_border.setAlpha(0.2F);
            jx_border.setBackground(new java.awt.Color(51, 51, 51));
            jx_border.setOpaque(true);


        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            super.paint(g2);
            g2.dispose();
        }
    }
}
