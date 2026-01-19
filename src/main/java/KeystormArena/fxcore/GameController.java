
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
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;

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
    int random=0;
    Timeline fallingkeys = new Timeline(new KeyFrame(Duration.millis(5), ae -> keys()));
    Image test = new Image(getClass().getResource("/image.png").toString());
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Label> keysList = new ArrayList<>();
    ArrayList<Label> keysListCopy = new ArrayList<>();

    Timeline Keychooser = new Timeline(new KeyFrame(Duration.millis(500), ae -> KeyChooser()));

    private void KeyChooser() {
       try {
         random = ThreadLocalRandom.current().nextInt(0, keysList.size()+1);
         if (keysList.size()!=0){
            keysList.get(random).setVisible(true);
            keysList.get(random).setLayoutX(ThreadLocalRandom.current().nextInt(36, 534 + 1));
            keysList.remove(random);
            }
       } catch (Exception e) {
        // TODO: handle exception
       }
       
    }

    private void keys() {

        if (score < 500) {

           
            // moving keys

            for (Label name : keysListCopy) {
                if (name.isVisible()) {
                    name.setTranslateY(name.getTranslateY() + 0.3);
                }
                if (name.getTranslateY() > 500) {
                    name.setTranslateY(0);
                    name.setVisible(false);
                    keysList.add(name);

                }
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
        // make a animation of the score going up by having a timer add 1 until it
        // reaches the new score number
        // create 20 objects that fall and when they pass the bar it respawns at the top

    }
}
