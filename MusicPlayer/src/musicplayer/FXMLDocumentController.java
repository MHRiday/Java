
 
package musicplayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;


public class FXMLDocumentController implements Initializable {
    String totalTime;
    String pauseTime;
    private Media media;
    private MediaPlayer mediaPlayer;
    private String filePath;
    @FXML
    private MediaView mediaView;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleOpenAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("MP4 And MP3 Files","*.mp4","*.mp3","*.m4a");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
       
        if(filePath != null)
        {
            
            media = new Media(filePath);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            
                DoubleProperty width = mediaView.fitWidthProperty();
                DoubleProperty hight = mediaView.fitHeightProperty();
                
                //summary
                
                //i can open this file in windows but not in ubuntu!I didn't install scene builder in ubuntu!and after resume video can't work properly!
                
                
                
                //this two line for scaling the window!But when these lines are active i can't any song!
                
                // width.bind(Bindings.selectDouble(mediaView, "width"));
                //hight.bind(Bindings.selectDouble(mediaView, "hight"));
            
            //\summary:
            
            mediaPlayer.play();
            
        }
        
    }

    @FXML
    private void handleStopAction(ActionEvent event) {
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
            
        }
        
    }

    @FXML
    private void handleResumeAction(ActionEvent event) {
        mediaPlayer.play();
        
    }

    @FXML
    private void handlePauseAction(ActionEvent event) {
        if(mediaPlayer != null)
        {
           
            mediaPlayer.pause();
            
        }
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
    
}
