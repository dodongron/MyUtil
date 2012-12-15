/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellReference;

/**
 *
 * @author i1
 */
public class S311 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        String filename = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
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
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        showExcelData(sheetData);
    }

    public static List<to_encoded> showExcelData(List sheetData) {
        FileInputStream fis;
        List<to_encoded> datas = new ArrayList();
        try {
            fis = new FileInputStream("C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls");
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                List<String> record = new ArrayList();
                for (int j = 0; j < list.size(); j++) {
//              
                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        String mydata = cell.getStringCellValue();
                        data = data + "" + mydata + "";
                        record.add(data);
                    } else {
                        if (j == 4 || j == 8) {
                            data = data + DateType.defaults.format(getRoundedDate(cell.getNumericCellValue())) + "";
                            record.add(data);
                        } else {
                            data = data + cell.getNumericCellValue() + "";
                            record.add(data);
                        }
                    }

//                    System.out.print(data);
//                    if (j < list.size() - 1) {
//                        System.out.print("=");
//
//                    }
                    // </editor-fold>
                }
                String[] aw = new String[size];
                int jj = 0;
                for (String s : record) {
                    aw[jj] = s;
                    System.out.print(s);
                    jj++;
                }

                to_encoded t = new to_encoded(FitIn.toInt(aw[0]), aw[1], aw[2], aw[3], aw[4], aw[5], aw[6], aw[7], aw[8], aw[9], aw[10], aw[11], aw[12], aw[13]);
                datas.add(t);
                System.out.println("");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(S311.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;

    }

    public static Date getRoundedDate(double date) {
        int SECONDS_PER_DAY = 24 * 3600;

        int wholeDays = (int) Math.floor(date);
        double ms = date - wholeDays;

        /**
         * round the time part to seconds
         */
        int millisecondsInDay = (int) Math.round(SECONDS_PER_DAY * ms) * 1000;

        Calendar calendar = new GregorianCalendar(); // using default time-zone
        org.apache.poi.ss.usermodel.DateUtil.setCalendar(calendar, wholeDays,
                millisecondsInDay, false);
        return calendar.getTime();
    }

    public static class to_encoded {

        public final int id;
        public final String ref_id;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String b_day;
        public final String b_place;
        public final String father;
        public final String mother;
        public final String address;
        public final String baptism;
        public final String minister;
        public final String sponsor;
        public final String notes;

        public to_encoded(int id, String ref_id, String fname, String mi, String lname, String b_day, String b_place, String father, String mother, String address, String baptism, String minister, String sponsor, String notes) {
            this.id = id;
            this.ref_id = ref_id;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.b_day = b_day;
            this.b_place = b_place;
            this.father = father;
            this.mother = mother;
            this.address = address;
            this.baptism = baptism;
            this.minister = minister;
            this.sponsor = sponsor;
            this.notes = notes;
        }
    }
}
