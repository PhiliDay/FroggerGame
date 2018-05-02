import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.util.List;
import java.util.ArrayList;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;


public class FroggerWelcome{

  FroggerWelcomeScreen fWScreen = new FroggerWelcomeScreen();
  FrogMusic frogMusic = new FrogMusic();

  Button volOff = new Button("Volume Off");
  Button letsPlay = new Button("Lets Play");
  Button volOn = new Button("Volume On");
  Button instructions = new Button("Instructions");


  BackgroundImage myBI= new BackgroundImage(new Image("homeFrog.png",800,600,false,true),
    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
      BackgroundSize.DEFAULT);

  public Pane root;
  private AnimationTimer timer;

//Creates the Pane and adds all the nodes to the parent
  public Parent createDisplay(){

    root = new Pane();
    root.setPrefSize(800, 600);
    root.setBackground(new Background(myBI));
    root.getChildren().addAll(fWScreen.createWelcomeText(),
                  fWScreen.createEnterText(),
                  fWScreen.createQuitText());
    volumeOff();
    volumeOn();
    instructions();

   timer = new AnimationTimer() {
       @Override
       public void handle(long now) {
       }
   };
    return root;
  }

//Creates the buttons for the volume and instructions on the welcome screen
    public void volumeOff(){
      volOff.setTranslateX(200);
      volOff.setTranslateY(525);
      style(volOff);
    //  root.getChildren().add(volOff);
    }

    public void volumeOn(){
      volOn.setTranslateX(400);
      volOn.setTranslateY(525);
      style(volOn);
      //root.getChildren().add(volOn);
    }

    public void instructions(){
      instructions.setTranslateX(290);
      instructions.setTranslateY(475);
      style(instructions);
      instructions.setOnAction(e -> FrogInstructions.display());
    //  root.getChildren().add(instructions);
    }

    public void style(Button buttonA){
      buttonA.setStyle("-fx-background-color: WHITE; ");
      buttonA.setFont(Font.loadFont("file:kirbyss.ttf", 20));
      buttonA.setMaxSize(200, 200);
      root.getChildren().add(buttonA);
    }
}
