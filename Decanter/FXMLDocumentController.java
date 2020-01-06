package decanter;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;



public class FXMLDocumentController implements Initializable {
    @FXML
    private Rectangle rectangle_popUpTop_red;
    @FXML
    private Rectangle rectangle_popUpTop_green;
    @FXML
    private Rectangle rectangle_popUpBottom;
    @FXML
    private Button btn_popUP_OK;
    @FXML
    private Button btn_decant;
    @FXML
    private Button btn_popUp_Close_red;
    @FXML
    private Button btn_popUp_Close_green;
    @FXML
    private Label label;
    @FXML 
    private Label label_popUpTitle;
    @FXML
    private Pane pane_main;
    @FXML
    private Pane pane_popUp_green;
    @FXML
    private Pane pane_popUp_red;
    @FXML
    private Label label_PopUpMessage;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        CopyingFiles();
    }
    @FXML
    private void PopUpClose(ActionEvent event) {
        PopUpWindow_Close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    private void PopUpWindow_Open(String popUpMessage, String popUpTitle, String popUpColor){
        pane_main.setVisible(false);
        if (popUpColor == "RED" || popUpColor == "Red" || popUpColor == "red") {
            pane_popUp_green.setVisible(false); pane_popUp_red.setVisible(true);
        }
        if (popUpColor == "GREEN" || popUpColor == "Green" || popUpColor == "green") {
            pane_popUp_green.setVisible(true); pane_popUp_red.setVisible(false);
        }
        else{
            System.out.println("popUpWindow = ColorError!");
        }
        label_popUpTitle.setText(popUpTitle);
        label_PopUpMessage.setText(popUpMessage);
    }
    
    private void PopUpWindow_Close(){
        pane_main.setVisible(true);  pane_popUp_green.setVisible(false); pane_popUp_red.setVisible(false);
    }
    
    private void CopyingFiles(){
        try {
            File phonePath = new File("");
            File hardDrive_Path = new File("");
            Files.copy(phonePath.toPath(), hardDrive_Path.toPath());
        } catch (IOException exception) {
            PopUpWindow_Open(exception.toString(), "Hiba", "RED");
        }
        PopUpWindow_Open("A fájlok sikeresen át lettek másolva!", "Kész", "GREEN");
    }
}
