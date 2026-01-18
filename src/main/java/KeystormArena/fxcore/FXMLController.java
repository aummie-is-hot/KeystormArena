
package KeystormArena.fxcore;
/*
By: Aum Markandey
Date: 2026-01-15
Program Details: A key press timing game with falling letters that you must type as they fall
*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.concurrent.ThreadLocalRandom;
public class FXMLController implements Initializable {
     @FXML
    private Label Akey;

    @FXML
    private Label Dkey;

    @FXML
    private Label Jkey;

    @FXML
    private Label Kkey;

    @FXML
    private Label Lkey;

    @FXML
    private Label Skey;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnStart;

    @FXML
    private Label lblTitle;

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), ae -> hover()));
    int hovertimer = 0;
    private void hover(){
        hovertimer = hovertimer + 1;
        if (hovertimer <= 50) {
            lblTitle.setTranslateY(lblTitle.getTranslateY() + 0.2);
            Kkey.setTranslateY(Kkey.getTranslateY() + 0.2);
            Akey.setTranslateY(Kkey.getTranslateY() + 0.2);
            Skey.setTranslateY(Kkey.getTranslateY() + 0.2);
            Dkey.setTranslateY(Kkey.getTranslateY() + 0.2);
            Jkey.setTranslateY(Kkey.getTranslateY() + 0.2);
            Lkey.setTranslateY(Kkey.getTranslateY() + 0.2);
        } else if (hovertimer >= 50 && hovertimer < 100) {
            lblTitle.setTranslateY(lblTitle.getTranslateY() - 0.2);
            Kkey.setTranslateY(Kkey.getTranslateY() - 0.2);
            Akey.setTranslateY(Kkey.getTranslateY() - 0.2);
            Skey.setTranslateY(Kkey.getTranslateY() - 0.2);
            Dkey.setTranslateY(Kkey.getTranslateY() - 0.2);
            Jkey.setTranslateY(Kkey.getTranslateY() - 0.2);
            Lkey.setTranslateY(Kkey.getTranslateY() - 0.2);
        } else if (hovertimer >= 100) {
            hovertimer = 0;
        }

    }
    @FXML
    void ButtonEntered(MouseEvent event) {
        Button sourcebtn = (Button) event.getSource();
       sourcebtn.setStyle("-fx-text-fill: #E63946;"+"-fx-background-color: transparent;");
       
    }

    @FXML
    void ButtonExited(MouseEvent event) {
       Button sourcebtn = (Button) event.getSource();
       sourcebtn.setStyle("-fx-text-fill: #eaeaea;"+"-fx-background-color: transparent;");
       
       
    }


     @FXML
    void LabelEntered(MouseEvent event) {
      Label sourcelbl = (Label) event.getSource();
       sourcelbl.setStyle("-fx-text-fill: #E63946;");
       
    }

    @FXML
    void LabelExited(MouseEvent event) {
    Label sourcelbl = (Label) event.getSource();
       sourcelbl.setStyle("-fx-text-fill: #eaeaea;");
       
       
    }
    



    @FXML
    void btnExitA(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnStartA(ActionEvent event) {
        try {
            System.out.println("1");
            MainApp.setRoot("game","Game");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();
// make it so when a key is pressed on time and correctly it adds to the score by a radom number
//  between 30 and 60 and have little text say +30 for example and fade out 
// check with duesome if me and hassan can use same hover code animation
// add like a black flash transition from the homescreen to the main game when start is pressed
    }    
}
