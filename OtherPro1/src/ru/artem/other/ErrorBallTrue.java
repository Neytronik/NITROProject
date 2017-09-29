package ru.artem.other;

import javafx.scene.control.Alert;
import javafx.stage.Window;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static ru.artem.other.StringToDate.cellString;


public class ErrorBallTrue extends Window {

        public static void errorFind(File pathSourse) throws IOException {

            int i = 0;
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(pathSourse));
            XSSFSheet sheet;
            boolean p0;
            boolean b;
            boolean br;
            boolean pubB;
            boolean pb;

            while (i <= wb.getNumberOfSheets() - 1) {

                String power = "";
                String $ball = null;
                String $repeatBall = null;
                double ball = 0;
                double repeatBall = 0;
                double pubball = 0;
                p0 = false;     // пустая степень
                br = false;     // несоответсвие балла замечания повторному балу
                pubB = false;   // суммарный бал по замечаниям не равен итоговому баллу ведомости
                pb = false;     // балл замечания не равен степени


                sheet = wb.getSheetAt(i);
                int r = 9,c=53,p=56,s=61,g=39,k=17;

                for (; !cellString(sheet.getRow(r).getCell(c)).equals(""); r++) {
                    /////////////Получаем значение баллов и их сумму//////////////////////
                    if (cellString(sheet.getRow(r).getCell(c)).equals("")) {
                        ball += 0;
                    } else {
                        ball += Double.parseDouble(cellString(sheet.getRow(r).getCell(c)));
                        $ball = cellString(sheet.getRow(r).getCell(c));
                        power = cellString(sheet.getRow(r).getCell(p));

                    }
                    //////////////Получаем значение повторных баллов и их сумму///////////
                    if (cellString(sheet.getRow(r).getCell(s)).equals("")) {
                        repeatBall += 0;
                    } else {
                        repeatBall += Double.parseDouble(cellString(sheet.getRow(r).getCell(s)));
                        $repeatBall = cellString(sheet.getRow(r).getCell(s));
                    }
                    ////////////////////////////////ОШИБКИ//////////////////////////////////
                    if (power == "") {
                        p0 = true;
                    }
                    if ($ball.equals("10.0") && !power.equals("2.0") || $ball.equals("100.0") &&
                        !power.equals("3.0") || $ball.equals("400.0") && !power.equals("4.0")){
                        pb = true;
                    }
                    if (!$ball.equals($repeatBall) && $repeatBall!=null) {
                        br = true;
                    }

                }
                ///////////////Получим итоговый балл независимо от количества строк////////////
                for (; !cellString(sheet.getRow(k).getCell(g)).equals("Оценка участка:"); k++) {
                    if (cellString(sheet.getRow(k).getCell(g)).equals("")) {
                        continue;
                    } else if (cellString(sheet.getRow(k).getCell(g)).equals("Итог по участку:")) {
                        pubball = Double.parseDouble(cellString(sheet.getRow(k).getCell(c)));
                        break;
                    }

                }
                ////////////////////////Проверка по итоговому баллу///////////////////////////////
                if ((ball+repeatBall) != pubball) {
                    pubB = true;
                }
                /////////////////////////////////////////////////////////////////////////////////
                if (p0) {
                    System.out.println(sheet.getSheetName()+ ",пустая степень");
                }
                if (br) {
                    System.out.println(sheet.getSheetName()+ ",балл не равен повторному");
                }
                if (pubB) {
                    System.out.println(sheet.getSheetName()+ ",итоговый не равен сумме");
                }
                if (pb) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Пользователь");
                    alert.setHeaderText(null);
                    alert.setContentText("несоответсвие балла степени");
                    alert.showAndWait();
                    System.out.println(sheet.getSheetName()+ ",несоответсвие балла степени");
                }
                i++;
            }
        }


    public static void main(String[] args) throws IOException {

    }
}
