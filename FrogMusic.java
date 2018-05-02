import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.media.AudioClip;

public class FrogMusic{

   boolean volume = false;

//  FroggerWelcomeScreen fWScreen = new FroggerWelcomeScreen();
  String musicFile = "frogger-ringtone.mp3";
  Media sound = new Media(new File(musicFile).toURI().toString());
  MediaPlayer mediaPlayer = new MediaPlayer(sound);

  String musicHop = "frogger-hop.wav";
  Media hop = new Media(new File(musicHop).toURI().toString());
  AudioClip mediaHop = new AudioClip(hop.getSource());
  //MediaPlayer mediaHop = new MediaPlayer(hop);

  String musicGameover = "frogger-gameover.mp3";
  Media gameOver = new Media(new File(musicGameover).toURI().toString());
  AudioClip mediaOver = new AudioClip(gameOver.getSource());

  String musicBack = "frogger-back.mp3";
  Media background = new Media(new File(musicBack).toURI().toString());
  MediaPlayer mediaBack = new MediaPlayer(background);
  // mediaBack.setVolume(0.5f);

  String musicWin = "frogger-win.mp3";
  Media win = new Media(new File(musicWin).toURI().toString());
  AudioClip mediaWin = new AudioClip(win.getSource());


  public void turnOffVol(){
    mediaOver.setVolume(0);
    mediaHop.setVolume(0);
    mediaPlayer.setMute(true);
    mediaBack.setVolume(0);
    mediaWin.setVolume(0);
    volume = false;
  }

  public void turnOnVol(){
    mediaOver.setVolume(100);
    mediaHop.setVolume(100);
    mediaPlayer.setMute(false);
    mediaBack.setVolume(100);
    volume = true;
  }





}
