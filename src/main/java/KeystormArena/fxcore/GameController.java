
package KeystormArena.fxcore;

/*
By: <Your Name Here>
Date: 2026-01-16
Program Details: <Program Description Here>
*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.util.concurrent.ThreadLocalRandom;

public class GameController implements Initializable {
    @FXML
    private Label Akey1;
    @FXML
    private Label Akey2;

    @FXML
    private Line Bar;

    @FXML
    private Label Dkey1;

    @FXML
    private Label Dkey2;

    @FXML
    private Label Jkey1;

    @FXML
    private Label Jkey2;

    @FXML
    private Label Kkey1;

    @FXML
    private Label Kkey2;

    @FXML
    private Label Lkey1;

    @FXML
    private Label Lkey2;

    @FXML
    private Label Skey1;

    @FXML
    private Label Skey2;

    @FXML
    private Label lblAddScore;

    @FXML
    private Label lblScore;

    int score = 0;
    int random;
    Timeline fallingkeys = new Timeline(new KeyFrame(Duration.millis(5), ae -> keys()));
    Image test = new Image(getClass().getResource("/image.png").toString());
    Timeline Keychooser = new Timeline(new KeyFrame(Duration.millis(250), ae -> KeyChooser()));

    private void KeyChooser(){
        random = ThreadLocalRandom.current().nextInt(1,12+1);
    }
    private void keys() {

        if (score < 500) {

          


           if(random==12){
            Lkey1.setVisible(true);
 
           }
            if(random==11){
                Lkey2.setVisible(true);
 
            }
            if(random==10){
            Skey1.setVisible(true);    

            }
            if(random==9){
            Skey2.setVisible(true);    

            }
            if(random==8){
            Dkey1.setVisible(true);

            }

            if(random==7){
                Dkey2.setVisible(true);

            }

            if(random==6){
                Jkey1.setVisible(true);
         
            }
            if(random==5){
            Jkey2.setVisible(true);
          
            }
            if(random==4){
                Kkey1.setVisible(true);
                
            }
            if(random==3){
            Kkey2.setVisible(true);
           
            }
            if ( random==2){
                
                Akey2.setVisible(true);
            }
            if(random == 1){
            Akey1.setVisible(true);
            }
            // moving keys
            if(Akey1.isVisible()){
                
            Akey1.setTranslateY(Akey1.getTranslateY() + 0.3);
            }
            if(Akey2.isVisible()){
                
            Akey2.setTranslateY(Akey2.getTranslateY() + 0.3);
            }

            if(Jkey1.isVisible()){
                
            Jkey1.setTranslateY(Jkey1.getTranslateY() + 0.3);
            }
            if(Jkey2.isVisible()){
                
            Jkey2.setTranslateY(Jkey2.getTranslateY() + 0.3);
            }
            if(Lkey1.isVisible()){
                
            Lkey1.setTranslateY(Lkey1.getTranslateY() + 0.3);
            }
            if(Lkey2.isVisible()){
                
            Lkey2.setTranslateY(Lkey2.getTranslateY() + 0.3);
            }
            if(Dkey1.isVisible()){
                
            Dkey1.setTranslateY(Dkey1.getTranslateY() + 0.3);
            }
            if(Dkey2.isVisible()){
                
            Dkey2.setTranslateY(Dkey2.getTranslateY() + 0.3);
            }
            if(Skey1.isVisible()){
                
            Skey1.setTranslateY(Skey1.getTranslateY() + 0.3);
            }
             if(Skey2.isVisible()){
                
            Skey2.setTranslateY(Skey2.getTranslateY() + 0.3);
            }
             if(Kkey1.isVisible()){
                
            Kkey1.setTranslateY(Kkey1.getTranslateY() + 0.3);
            }
            if(Kkey2.isVisible()){
                
            Kkey2.setTranslateY(Kkey2.getTranslateY() + 0.3);
            }
             
           // reseting keys
            if (Lkey2.getLayoutY()>450) {
                Lkey2.setTranslateY(0);
                Lkey2.setVisible(false);
            }
             if (Lkey1.getLayoutY()>450) {
                Lkey1.setTranslateY(0);
                Lkey1.setVisible(false);
            }
             if (Kkey2.getLayoutY()>450) {
                Kkey2.setTranslateY(0);
               Kkey2.setVisible(false);
            }
             if (Kkey1.getLayoutY()>450) {
                Kkey1.setTranslateY(0);
                Kkey1.setVisible(false);
            }
             if (Skey2.getLayoutY()>450) {
                Skey2.setTranslateY(0);
                Skey2.setVisible(false);
            }
             if (Skey1.getLayoutY()>450) {
                Skey1.setTranslateY(0);
                Skey1.setVisible(false);
            }
             if (Dkey1.getLayoutY()>450) {
                Dkey1.setTranslateY(0);
                
                Dkey1.setVisible(false);
            }
             if (Dkey2.getLayoutY()>450) {
                Dkey2.setTranslateY(0);
                
                Dkey2.setVisible(false);
            }
             if (Jkey2.getLayoutY()>450) {
                Jkey2.setTranslateY(0);
                
                Jkey2.setVisible(false);
            }
             if (Jkey1.getLayoutY()>450) {
                Jkey1.setTranslateY(0);
                Jkey1.setVisible(false);
            }
             if (collision(Akey2, lblScore)) {
                Akey2.setTranslateY(0);
                Akey2.setVisible(false);
            }
            if (collision(Akey1, lblScore)) {
                Akey1.setTranslateY(0);
                Akey2.setVisible(false);
            }


        }
    }

    public boolean collision(Label block1, Label block2) {
        // returns true if the areas intersect, false if they dont
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    @FXML
    void LabelEntered(MouseEvent event) {

    }

    @FXML
    void LabelExited(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fallingkeys.setCycleCount(Timeline.INDEFINITE);
        fallingkeys.play();
         Keychooser.setCycleCount(Timeline.INDEFINITE);
        Keychooser.play();
        // make a animation of the score going up by having a timer add 1 until it
        // reaches the new score number
        // create 20 objects that fall and when they pass the bar it respawns at the top

    }
}
