import javafx.scene.effect.DropShadow;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FrogBehaviour {
  Button yesPlay = new Button("Play Again?");
  Button noStop = new Button("Quit Game");
  private Text score = new Text();
  private int lives = 0;

  public HBox displayText(String argument){

//Effects for the text
      DropShadow ds = new DropShadow();
      ds.setOffsetY(3.0f);
      ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

      HBox hBox = new HBox();
      hBox.setTranslateX(280);
      hBox.setTranslateY(250);

      for (int i = 0; i < argument.toCharArray().length; i++) {
          char letter = argument.charAt(i);

          Text text = new Text(String.valueOf(letter));
          text.setEffect(ds);
          text.setCache(true);
          text.setX(10.0f);
          text.setY(270.0f);
          text.setFill(Color.RED);
          text.setOpacity(0);
          text.setFont(Font.loadFont("file:kirbyss.ttf", 50));

          hBox.getChildren().add(text);

          FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
          ft.setToValue(1);
          ft.setDelay(Duration.seconds(i * 0.15));
          ft.play();
    }
    return hBox;
  }

  public Button yesPlay(){
    yesPlay.setTranslateX(225);
    yesPlay.setTranslateY(350);
    buttonStyle(yesPlay);
    return yesPlay;
  }

  public Button noStop(){
    noStop.setTranslateX(400);
    noStop.setTranslateY(350);
    buttonStyle(noStop);
    return noStop;
  }

  public Text createLives(int  numLives, String a){
    lives = numLives;
      score.setText(a + lives);
      score.setTranslateX(30);
      score.setTranslateY(30);
      score.setFont(Font.loadFont("file:kirbyss.ttf", 20));
      return score;
  }

  public void die(){
    lives--;
    score.setText("Lives: " + Integer.toString(lives));
  }

  private void buttonStyle(Button buttonA){
    buttonA.setStyle("-fx-background-color: GREEN; ");
    buttonA.setFont(Font.loadFont("file:kirbyss.ttf", 20));
    buttonA.setMaxSize(200, 200);
  }

}
