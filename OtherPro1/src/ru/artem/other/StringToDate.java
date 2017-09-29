package ru.artem.other;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class StringToDate {

    public static String getDate (XSSFSheet sheet) {
        String date = cellString(sheet.getRow(0).getCell(0));
        String $date = date.substring(15, 25);          //Получаем дату без знаков
        return $date;
    }
    public static String getEch (XSSFSheet sheet) {
        String echANDechk = cellString(sheet.getRow(3).getCell(36));
        String ech = echANDechk.substring(echANDechk.indexOf(',') + 1, echANDechk.length());
        String $ech = ech.substring(4, ech.indexOf(','));
        return $ech;
    }
    public static String getEchk (XSSFSheet sheet) {
        String echANDechk = cellString(sheet.getRow(3).getCell(36));
        String ech = echANDechk.substring(echANDechk.indexOf(',') + 1, echANDechk.length());
        String $echk = ech.substring(ech.indexOf(',') + 6, ech.length());       // get number ech and echk
        return $echk;
    }
    public static String getLot (XSSFSheet sheet) {
        String lot = cellString(sheet.getRow(5).getCell(36));      //название участка
        String $lot = lot.substring(0, lot.indexOf('№') - 6);
        return $lot;
    }
    public static String getWay (XSSFSheet sheet) {
        String way = cellString(sheet.getRow(5).getCell(36));
        String $wayt = way.substring(way.indexOf('№'), way.length());
        String $way = $wayt.substring(1, $wayt.indexOf('(') -1); // получаем номер пути
        return $way;
    }
    public static String cellString(Cell cell) {

        String result = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    result = cell.getRichStringCellValue().getString();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        result = Double.toString(cell.getNumericCellValue());
                    } else {
                        result = Double.toString(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    result = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    result = cell.getCellFormula();
                    break;
                case BLANK:
                    result = "";
                    break;
                default:
                    result = "";
                    break;
            }
            return result;


        } else return result;
    }
}

