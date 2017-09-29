package ru.artem.other;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Window;

import java.io.IOException;
import java.time.LocalDate;

import static org.apache.poi.sl.usermodel.PresetColor.Window;
import static ru.artem.other.Catalog.filesFolder;

public class Controller extends Window {

    public static LocalDate ld;
    public static LocalDate ld1;

    @FXML
    private DatePicker startData;
    @FXML
    private DatePicker dateEnd;
    @FXML
    private void dateStart(ActionEvent event) {
        ld = startData.getValue();
    }
    @FXML
    public void dateEnd(ActionEvent actionEvent) {
        ld1 = dateEnd.getValue();
    }

    public void detectError(ActionEvent actionEvent) throws IOException {
            filesFolder(pathName);

    }
    static String pathName = null;
    public void directStart(ActionEvent actionEvent) {
        Directory dir1 = new Directory("Выберите директорию файлов бальности");
        pathName = dir1.getDirect();
    }
    static String pathSourse = null;
    public void directEnd(ActionEvent actionEvent) {
        Directory dir = new Directory("Выберите директорию отчетности");
        pathSourse = dir.getDirect();

    }
}
