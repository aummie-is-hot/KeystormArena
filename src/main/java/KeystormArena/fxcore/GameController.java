
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    private MediaView MediaViewIntro;
    @FXML
    private Label lblAddScore;

    @FXML
    private Label lblScore;
    boolean addscore = false;
    int score = 0;
    int random = 0;
    Timeline fallingkeys = new Timeline(new KeyFrame(Duration.millis(5), ae -> keys()));
    Image test = new Image(getClass().getResource("/image.png").toString());
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Label> keysList = new ArrayList<>();
    ArrayList<Label> keysListCopy = new ArrayList<>();
    Media media = new Media(getClass().getResource("/Intro.mp4").toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    Timeline Keychooser = new Timeline(new KeyFrame(Duration.millis(500), ae -> KeyChooser()));
    int introtime = 0;
   
    private void KeyChooser() {
        if(score<0){
            System.exit(0);
        }
        try {
            random = ThreadLocalRandom.current().nextInt(0, keysList.size() + 1);
            if (keysList.size() != 0) {
                keysList.get(random).setVisible(true);
                keysList.get(random).setLayoutX(ThreadLocalRandom.current().nextInt(36, 534 + 1));
                keysList.remove(random);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void keys() {
        if(addscore){
           
            lblAddScore.setOpacity(lblAddScore.getOpacity()-0.005);
        }
        lblScore.setText("Score: " + score);
        introtime += 1;
        if (introtime > 260) {
            MediaViewIntro.setVisible(false);
        }
       

            // moving keys

            for (Label name : keysListCopy) {
                if (name.isVisible()) {
                    if(score<=1000){
                        
                    name.setTranslateY(name.getTranslateY() + 0.3);
                    }
                    if(score>=1000&&score<2000){
                        name.setTranslateY(name.getTranslateY() + 0.4);
                    }
                    if(score>=2000){
                        name.setTranslateY(name.getTranslateY() + 0.5);
                    }
                    if(score>3000){
                        name.setTranslateY(name.getTranslateY() + 0.7);
                    }
                }
                if (name.getTranslateY() > 500) {
                  
                 
                    name.setTranslateY(0);
                    name.setVisible(false);
                    keysList.add(name);
                    score-=50;

                }

            }

        

    }

    public boolean collision(Label block1, Line block2) {
        // returns true if the areas intersect, false if they dont
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    @FXML
    void LabelEntered(MouseEvent event) {

    }

    @FXML
    void LabelExited(MouseEvent event) {

    }

    @FXML
    void KeyPressed(KeyEvent event) {
        score-=50;
        if (collision(Lkey2, Bar) && event.getCode() == KeyCode.L) {
            score += 100;
            Lkey2.setVisible(false);
            Lkey2.setTranslateY(0);
            keysList.add(Lkey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Lkey1, Bar) && event.getCode() == KeyCode.L) {
            score += 100;
            Lkey1.setVisible(false);
            Lkey1.setTranslateY(0);
            keysList.add(Lkey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Kkey2, Bar) && event.getCode() == KeyCode.K) {
            score += 100;
            Kkey2.setVisible(false);
            Kkey2.setTranslateY(0);
            keysList.add(Kkey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Kkey1, Bar) && event.getCode() == KeyCode.K) {
            score += 100;
            Kkey1.setVisible(false);
            Kkey1.setTranslateY(0);
            keysList.add(Kkey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Jkey2, Bar) && event.getCode() == KeyCode.J) {
            score += 100;
            Jkey2.setVisible(false);
            Jkey2.setTranslateY(0);
            keysList.add(Jkey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Jkey1, Bar) && event.getCode() == KeyCode.J) {
            score += 100;
            Jkey1.setVisible(false);
            Jkey1.setTranslateY(0);
            keysList.add(Jkey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Dkey2, Bar) && event.getCode() == KeyCode.D) {
            score += 100;
            Dkey2.setVisible(false);
            Dkey2.setTranslateY(0);
            keysList.add(Dkey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Dkey1, Bar) && event.getCode() == KeyCode.D) {
            score += 100;
            Dkey1.setVisible(false);
            Dkey1.setTranslateY(0);
            keysList.add(Dkey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Skey1, Bar) && event.getCode() == KeyCode.S) {
            score += 100;
            Skey1.setVisible(false);
            Skey1.setTranslateY(0);
            keysList.add(Skey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Skey2, Bar) && event.getCode() == KeyCode.S) {
            score += 100;
            Skey2.setVisible(false);
            Skey2.setTranslateY(0);
            keysList.add(Skey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Akey2, Bar) && event.getCode() == KeyCode.A) {
            score += 100;
            Akey2.setVisible(false);
            Akey2.setTranslateY(0);
            keysList.add(Akey2);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
        if (collision(Akey1, Bar) && event.getCode() == KeyCode.A) {
            score += 100;
            Akey1.setVisible(false);
            Akey1.setTranslateY(0);
            keysList.add(Akey1);
            addscore = true;
            lblAddScore.setOpacity(1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        keysList.add(Akey1);
        keysList.add(Akey2);
        keysList.add(Skey1);
        keysList.add(Skey2);
        keysList.add(Dkey1);
        keysList.add(Dkey2);
        keysList.add(Jkey1);
        keysList.add(Jkey2);
        keysList.add(Kkey1);
        keysList.add(Kkey2);
        keysList.add(Lkey1);
        keysList.add(Lkey2);
        keysListCopy.add(Akey1);
        keysListCopy.add(Akey2);
        keysListCopy.add(Skey1);
        keysListCopy.add(Skey2);
        keysListCopy.add(Dkey1);
        keysListCopy.add(Dkey2);
        keysListCopy.add(Jkey1);
        keysListCopy.add(Jkey2);
        keysListCopy.add(Kkey1);
        keysListCopy.add(Kkey2);
        keysListCopy.add(Lkey1);
        keysListCopy.add(Lkey2);
        Keychooser.setCycleCount(Timeline.INDEFINITE);
        Keychooser.play();
        fallingkeys.setCycleCount(Timeline.INDEFINITE);
        fallingkeys.play();
        MediaViewIntro.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        

    }
}
