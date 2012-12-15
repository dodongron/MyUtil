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
public class S3 {

    @SuppressWarnings("unchecked")
//    public static void main(String[] args) throws Exception {
//        String filename = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";
//        List sheetData = new ArrayList();
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(filename);
//            HSSFWorkbook workbook = new HSSFWorkbook(fis);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator rows = sheet.rowIterator();
//            while (rows.hasNext()) {
//                HSSFRow row = (HSSFRow) rows.next();
//                Iterator cells = row.cellIterator();
//
//                List data = new ArrayList();
//                while (cells.hasNext()) {
//                    HSSFCell cell = (HSSFCell) cells.next();
//                    data.add(cell);
//                }
//                sheetData.add(data);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                fis.close();
//            }
//        }
//        showExcelData(sheetData,String path);
//    }

    public static List<to_encoded> showExcelData(List sheetData,String path) {

        int[] range = {24, 48, 72, 96, 120, 144, 168, 192, 216, 240, 264, 288, 312, 336, 360, 384, 408, 432, 456, 480, 504, 528, 552, 576, 600, 624, 648, 672, 696, 720, 744, 768, 792, 816, 840, 864, 888, 912, 936, 960, 984, 1008, 1032, 1056, 1080, 1104, 1128, 1152, 1176, 1200, 1224, 1248, 1272, 1296, 1320, 1344, 1368, 1392, 1416, 1440, 1464, 1488, 1512, 1536, 1560, 1584, 1608, 1632, 1656, 1680, 1704, 1728, 1752, 1776, 1800, 1824, 1848, 1872, 1896, 1920, 1944, 1968, 1992, 2016, 2040, 2064, 2088, 2112, 2136, 2160, 2184, 2208, 2232, 2256, 2280, 2304, 2328, 2352, 2376, 2400, 2424, 2448, 2472, 2496, 2520, 2544, 2568, 2592, 2616, 2640, 2664, 2688, 2712, 2736, 2760, 2784, 2808, 2832, 2856, 2880, 2904, 2928, 2952, 2976, 3000};
        FileInputStream fis;
        List<to_encoded> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = FitIn.toInt(S4_insert_to_db.increment_id_parishioners()) + 1;
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
                        if (j == 5 || j == 10) {
                            data = data + DateType.sf.format(getRoundedDate(cell.getNumericCellValue())) + "";
                            record.add(data);
                        } else {
                            data = data + cell.getNumericCellValue() + "";
                            record.add(data);
                        }
                    }
                }
                String[] aw = new String[size];
                int jj = 0;
                for (String s : record) {
                    aw[jj] = s;
                    jj++;
                }


                if(r==24){
                    r_set++;
                }

                to_encoded t = new to_encoded(FitIn.toInt(aw[0]), aw[1], aw[2], aw[3], aw[4], aw[5], aw[6], aw[7], aw[8], aw[9], aw[10], aw[11], aw[12], aw[13], id);
                datas.add(t);
                r++;
                id++;
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(S3.class.getName()).log(Level.SEVERE, null, ex);
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
        public final int page_no;

        public to_encoded(int id, String ref_id, String fname, String mi, String lname, String b_day, String b_place, String father, String mother, String address, String baptism, String minister, String sponsor, String notes, int page_no) {
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
            this.page_no = page_no;
        }
    }
}
