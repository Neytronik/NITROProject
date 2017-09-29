package ru.artem.other;
/*класс создающий папку и ведомости */
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import static ru.artem.other.Controller.*;

public class ExcelCreate {

        public static void main(String[] args) throws IOException {

            File myPath = new File(pathName + "/Отчет ВИКС " + new Date());
            myPath.mkdir();
            myPath.mkdirs(); // вроде проверяет существует ли такая папка и если нет то добавляет ее

            XSSFWorkbook wball = new XSSFWorkbook();
            Sheet sh1 = wball.createSheet("Полная ведомость");
            String allDoc = myPath + "/Полная ведомость отступлений.xlsx";// Все как в старом отчете
            FileOutputStream fil = new FileOutputStream(allDoc);
            wball.write(fil);
            fil.close();

            XSSFWorkbook wbsvod = new XSSFWorkbook();
            Sheet sh20 = wbsvod.createSheet("Сводная за проезд");
            Sheet sh21 = wbsvod.createSheet("ЭЧ-1");
            Sheet sh22 = wbsvod.createSheet("ЭЧ-2");
            Sheet sh24 = wbsvod.createSheet("ЭЧ-4");
            Sheet sh25 = wbsvod.createSheet("ЭЧ-5");
            Sheet sh26 = wbsvod.createSheet("ЭЧ-6");
            String svodDoc = myPath + "/Сводная ведомость отступлений.xlsx"; // Количество каждого плюс по степени
            FileOutputStream fil2 = new FileOutputStream(svodDoc);           // можно для каждого эч на отдельном листе
            wbsvod.write(fil2);
            fil2.close();

            XSSFWorkbook wbraport = new XSSFWorkbook();
            Sheet sh31 = wbraport.createSheet("Рапортная ведомость");
            String raportDoc = myPath + "/Рапортная ведомость отступлений.xlsx";// на первом листе нужно создать рапорт
            FileOutputStream fil3 = new FileOutputStream(raportDoc);             // а на последующих что то вроде зайцева
            wbraport.write(fil3);                                                // каждый лист эчк с километражом
            fil3.close();

        }

}
