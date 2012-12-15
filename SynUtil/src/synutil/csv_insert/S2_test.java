/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

/**
 *
 * @author i1
 */
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class S2_test {

    @SuppressWarnings("unchecked")
    //    public static void main(String[] args) throws Exception {
    ////
    //// An excel file name. You can create a file name with a full
    //// path information.
    ////
    //        String fileName = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";
    //
    //
    //// Create an ArrayList to store the data read from excel sheet.
    ////
    //        List sheetData = new ArrayList();
    //
    //        FileInputStream fis = null;
    //        try {
    //            fis = new FileInputStream(fileName);
    //            HSSFWorkbook workbook = new HSSFWorkbook(fis);
    //            HSSFSheet sheet = workbook.getSheetAt(0);
    //            Iterator rows = sheet.rowIterator();
    ////            while (rows.hasNext()) {
    ////                HSSFRow row = (HSSFRow) rows.next();
    ////                Iterator cells = row.cellIterator();
    ////
    ////                List data = new ArrayList();
    ////                while (cells.hasNext()) {
    ////                    HSSFCell cell = (HSSFCell) cells.next();
    ////                    System.out.print(cell.getCellType());
    ////                }
    ////                sheetData.add(data);
    ////
    ////            }
    ////            for (Object a : sheetData) {
    ////                System.out.println(a.toString());
    ////            }
    //            Vector cellVectorHolder = new Vector();
    //
    //            Iterator rowIter = sheet.rowIterator();
    //
    //            while (rowIter.hasNext()) {
    //                HSSFRow myRow = (HSSFRow) rowIter.next();
    //                Iterator cellIter = myRow.cellIterator();
    //                Vector cellStoreVector = new Vector();
    //                while (cellIter.hasNext()) {
    //                    HSSFCell myCell = (HSSFCell) cellIter.next();
    //                    cellStoreVector.addElement(myCell);
    //                }
    //                cellVectorHolder.addElement(cellStoreVector);
    //            }
    //            Vector dataHolder = ReadCSV(fileName);
    //
    //            printCellDataToConsole(dataHolder);
    //
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        } finally {
    //            if (fis != null) {
    //                fis.close();
    //            }
    //        }
    //
    //    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";
        Vector dataHolder = ReadCSV(fileName);
//        printCellDataToConsole(dataHolder);

    }

    public static Vector ReadCSV(String fileName) {
        Vector cellVectorHolder = new Vector();

        try {
            FileInputStream myInput = new FileInputStream(fileName);

            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector cellStoreVector = new Vector();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    cellStoreVector.addElement(myCell);
                    String data="";
                    if (myCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {

                        System.out.print(myCell.getStringCellValue() + " ");
                    } else if (myCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        System.out.print(myCell.getNumericCellValue() + " ");
                    } else {
                        System.out.print(myCell.getDateCellValue());
                    }

                }
                cellVectorHolder.addElement(cellStoreVector);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }
//    public ArrayList<String> getColNames(int sheetIndex) {
//        
//    }
//    private static void printCellDataToConsole(Vector dataHolder) {
//
//        for (int i = 0; i < dataHolder.size(); i++) {
//            Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
//            for (int j = 0; j < cellStoreVector.size(); j++) {
//                HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
//                String stringCellValue = myCell.toString();
////                System.out.print(stringCellValue + "\t");
//            }
//            System.out.println();
//        }
//    }
}