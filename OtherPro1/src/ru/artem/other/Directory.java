package ru.artem.other;


import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import java.io.File;


class Directory extends Window{

    DirectoryChooser dc;
    Directory(String NameWindow) {
        dc = new DirectoryChooser();
        dc.setTitle(NameWindow);
    }
    public String getDirect() {
        File Direct;
        Direct = dc.showDialog(this);
        if (Direct == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Пользователь");
            alert.setHeaderText(null);
            alert.setContentText("Укажите директориию файлов!!!");
            alert.showAndWait();
            return null;
        }
        else return Direct.getPath();

    }
}
