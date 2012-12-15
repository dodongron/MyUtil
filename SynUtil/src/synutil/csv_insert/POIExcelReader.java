/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package synutil.csv_insert;

/**
 *
 * @author i1
 */
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Iterator;

/**
 * This java program is used to read the data from a Excel file and display them
 * on the console output.
 * 
* @author dhanago
 */
public class POIExcelReader {

    /**
     * Creates a new instance of POIExcelReader
     */
    public POIExcelReader() {
    }

    /**
     * This method is used to display the Excel content to command line.
     *     
* @param xlsPath
     */
    @SuppressWarnings("unchecked")
    public void displayFromExcel(String xlsPath) {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(xlsPath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the specified path.");
            e.printStackTrace();
        }

        POIFSFileSystem fileSystem = null;

        try {
            fileSystem = new POIFSFileSystem(inputStream);

            HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workBook.getSheetAt(0);
            Iterator<HSSFRow> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = rows.next();
                String val = "";
//                System.out.println("Row No.: " + row.getRowNum());
                Iterator<HSSFCell> cells = row.cellIterator();
                for (int i = 0; i < 14; i++) {
                    HSSFCell cell = cells.next();
                    switch (cell.getCellType()) {
                    case HSSFCell.CELL_TYPE_NUMERIC: {
                        val = val + cell.getNumericCellValue() + "=";
                        break;
                    }
                    case HSSFCell.CELL_TYPE_STRING: {
                        val = val + cell.getStringCellValue() + "=";
                        break;
                    }
                    case HSSFCell.CELL_TYPE_BLANK: {
                        val = val + " " + "=";
                        break;
                    }
                    default: {
                        System.out.println("Type not supported.");
                        break;
                    }
                    }
                }



                System.out.println(val);
//                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        POIExcelReader poiExample = new POIExcelReader();
        String xlsPath = "C:\\Users\\i1\\Desktop\\csv\\books\\onprocess\\bk69\\Book69.xls";

        poiExample.displayFromExcel(xlsPath);
    }
}
