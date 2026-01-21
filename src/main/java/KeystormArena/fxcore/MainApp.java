
package KeystormArena.fxcore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class MainApp extends Application {
    private static Stage stage;
public static int score;
MediaPlayer player;
int song;
private final String[] songs = {
    "/Dj.mp3",
    "/Jelous.mp3",
    "/MyType.mp3",
    "/VivaLaVida.mp3",
    "/Timber.mp3",
    "/Vicetone.mp3",
    "/Vers.mp3"
};
private void PlayRandomSong() {
    // stop and delete old player cuz the old one cant be set to a new song for sum reason
    if (player != null) {
        player.stop();
        player.dispose();
    }

    // pick a random song
    int index = ThreadLocalRandom.current().nextInt(0, songs.length);

    // create new MediaPlayer
    player = new MediaPlayer(
        new Media(getClass().getResource(songs[index]).toString())
    );

   
    player.setVolume(1);

    // when song ends do ts again its called a lambda or smth and it
    //  basically says dont run the function now only later otherwise it would just run
    player.setOnEndOfMedia(() -> PlayRandomSong());

    
    player.play();
}

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        
       
  PlayRandomSong();
        setRoot("primary","KeyStorm Arena");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
        stage.setOnCloseRequest(e -> System.exit(0));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
