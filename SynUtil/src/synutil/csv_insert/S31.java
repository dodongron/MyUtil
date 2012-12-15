/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author i1
 */
public class S31 {

    @SuppressWarnings("unchecked")

    public static void main(String[] args) throws Exception {

        String filename = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
                
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

//        showExcelData(sheetData);
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return cell.getNumericCellValue() + "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return cell.getBooleanCellValue() + "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            return cell.getErrorCellValue() + "";
        } else {
            return null;
        }
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

    public static class to_col {

        public final String id;
        public final String ref_id;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String bday;
        public final String place;
        public final String father;
        public final String mother;
        public final String address;
        public final String baptism;
        public final String priest;
        public final String sponsor;
        public final String remarks;

        public to_col(String id, String ref_id, String fname, String mi, String lname, String bday, String place, String father, String mother, String address, String baptism, String priest, String sponsor, String remarks) {
            this.id = id;
            this.ref_id = ref_id;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.bday = bday;
            this.place = place;
            this.father = father;
            this.mother = mother;
            this.address = address;
            this.baptism = baptism;
            this.priest = priest;
            this.sponsor = sponsor;
            this.remarks = remarks;
        }
    }
}
