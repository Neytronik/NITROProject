package ru.artem.other;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;
import static ru.artem.other.Controller.pathSourse;

/**
 * Created by artem on 20.05.17.
 */
public class FullDoc  {


    public void fullDoc(File file)throws IOException

    {
        XSSFWorkbook findError = new XSSFWorkbook(new FileInputStream(pathSourse));

        int i = 0;
        XSSFSheet findSheet = null;
        XSSFRow row = null;
        String value = null;
        XSSFCell cell;

        // здесь будет строковое значение
        while (i <= findError.getNumberOfSheets() - 1)                              // Метод показывает количество листов в книге
        {
            findSheet = findError.getSheetAt(i);
            row = findError.getSheetAt(i).getRow(9);

            for (int r = 9; row.getCell(0).getCellType() != CELL_TYPE_BLANK; r++) {

                row = findError.getSheetAt(i).getRow(r);

                for (int c = 0; c <= 82; c++) {

                    cell = row.getCell(c);

                    if (cell != null) {
                        if (cell.getCellType() == CELL_TYPE_BLANK) {
                            //continue;
                            value = "";
                        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                            value = Boolean.toString(cell.getBooleanCellValue());
                        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                            value = Byte.toString(cell.getErrorCellValue());
                        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                            value = cell.getCellFormula();
                        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            value = Integer.toString((int) cell.getNumericCellValue());
                        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            value = cell.getStringCellValue();
                        }
                        System.out.print(value + " ");
                    }

                }
                System.out.println();
            }
            //System.out.println();
            i++;
        }

    }
}

