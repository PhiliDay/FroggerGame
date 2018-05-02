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
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;


public class FroggerWelcomeScreen{

    public Text createWelcomeText(){
      Text welcome = new Text();

        welcome.setText("FROGGER");
        welcome.setFont(Font.loadFont("file:kirbyss.ttf", 100));
        welcome.setFill(Color.WHITE);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(10);

        KeyValue startKeyValue = new KeyValue(welcome.translateXProperty(), 600);
        KeyValue endKeyValue = new KeyValue(welcome.translateXProperty(), -1.0 * 50);
        KeyValue kv2 = new KeyValue(welcome.translateYProperty(), 250);

        KeyFrame startFrame = new KeyFrame(Duration.ZERO, startKeyValue, kv2);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(1), endKeyValue, kv2);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue, kv2);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue, kv2);

        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return welcome;
    }

    public Text createEnterText(){
      Text enter = new Text();

      enter.setText("Press Enter To Play");
      enter.setTranslateX(215);
      enter.setTranslateY(390);
      enter.setFont(Font.loadFont("file:polyfont.ttf", 30));
      enter.setFill(Color.WHITE);

      return enter;
    }

    public Text createQuitText(){
      Text quit = new Text();

      quit.setText("Press Q To Quit");
      quit.setTranslateX(250);
      quit.setTranslateY(440);
      quit.setFont(Font.loadFont("file:polyfont.ttf", 30));
      quit.setFill(Color.WHITE);

      return quit;
    }

}
