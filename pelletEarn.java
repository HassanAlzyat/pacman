package com.example.demo3;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class pelletEarn {

    public static boolean isCollected(Node pacman, Node nodes) {

        if (pacman.getBoundsInParent().intersects(nodes.getBoundsInParent())) {
            Media sPellete = new Media(new File("D:\\Voicy_Pac-Man Pellet Eaten.mp3").toURI().toString());
            MediaPlayer mPellete = new MediaPlayer(sPellete);
            
            Timeline delay=new Timeline(new KeyFrame(Duration.millis(20),e->{
                mPellete.play();
                
            }));
            delay.play();
            
            mPellete.stop();
            return true;
        }
        return false;

    }

}
