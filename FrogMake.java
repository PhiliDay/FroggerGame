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

public class FrogMake{

  private BackgroundImage myBI= new BackgroundImage(new Image("FroggerBackground.png",800,600,false,true),
    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
      BackgroundSize.DEFAULT);

  private List<Node> cars = new ArrayList<>();
  public  Pane root;
  private AnimationTimer timer;
  public Node froggy;
  private Node car;
  private Node bike;
  public int numLives = 5;
  private String ab = "Lives: ";
  private String sc = "Score: ";
  private int testNumber = 1;
  public boolean isDead = false;

  private FrogChild frog = new FrogChild();
  private FrogBehaviour frogBeh = new FrogBehaviour();
  private FrogMusic frogMusic = new FrogMusic();


  public Parent createDisplay(){
    numLives = 5;

    root = new Pane();
    root.setPrefSize(800, 600);
    froggy = frog.createFrog();

    root.getChildren().addAll(froggy);
    root.setBackground(new Background(myBI));
    root.getChildren().addAll(frogBeh.createLives(numLives, ab));

   timer = new AnimationTimer() {
       @Override
       public void handle(long now) {
           onUpdate();
       }
   };
    timer.start();


    return root;
  }

  /* This method creates the cars at random locations on the Y axis then updates the
  cars/bikes X axis so the nodes move along from left to right.  It also checks
  to see whether the person wins or loses*/

  private void onUpdate(){


    car = frog.createCar();
    bike = frog.createBike();

    for (Node car : cars)
        car.setTranslateX(car.getTranslateX() + Math.random() * 8);

    if (Math.random() < 0.05) {
        car.setTranslateY((int)(Math.random() * ((260 - 40) + 1) + 40));
        root.getChildren().addAll(car);
        cars.add(car);
    }

    if(Math.random() < 0.05){
      bike.setTranslateY((int)(Math.random() * ((519 - 300) + 1) + 300));
      root.getChildren().addAll(bike);
      cars.add(bike);
    }

    checkState();
  }


/*Checks whether the frog has hit the cars/bikes.  If it does hit - return to
beginning with one less life.  Only takes into consideration the edge of the picture
not the full contact */
  private void checkState(){
    for (Node indi : cars) {
        if (indi.getBoundsInParent().intersects(froggy.getBoundsInParent())) {
            froggy.setTranslateX(0);
            froggy.setTranslateY(600 - 39);
            loseLives();
            return;
        }
      }
      checkDisplay(numLives);
      checkWin();
  }



/*Ends game if run out of lives*/
  private void checkDisplay(int numLives){
    if(numLives <= 0){
      frogMusic.mediaBack.stop();
      frogMusic.mediaOver.play();
      root.getChildren().addAll(frogBeh.displayText("YOU LOSE"));
      yesPlay();
      timer.stop();
    }
}



/*If the frog reaches the water, tells the people theyve won*/
  private void checkWin(){
    if(froggy.getTranslateY() <= 0){
      frogMusic.mediaBack.stop();
      frogMusic.mediaWin.play();
      root.getChildren().addAll(frogBeh.displayText("YOU WIN"));
      yesPlay();
      timer.stop();
      isDead = true;
    }
  }


  private int loseLives(){
    checkLives();
    return --numLives;
  }

  private int getLives(){
    return numLives;
  }

  private void checkLives(){
    frogBeh.die();
  }

//Button
  private void yesPlay(){
    root.getChildren().add(frogBeh.yesPlay());
    root.getChildren().add(frogBeh.noStop());
  }

  public Button yesButton(){
    return frogBeh.yesPlay();
  }

  public Button noButton(){
    return frogBeh.noStop();
  }

//To control the movement of the frog
  public Node frogg(){
    return froggy;
  }

  public Node froggY(){
    froggy.setTranslateY(frogg().getTranslateY() - 40);
    return froggy;
  }

  public Node froggLX(){
    if(froggy.getTranslateX() > 0){
    froggy.setTranslateX(frogg().getTranslateX() - 40);
    }
    return froggy;
  }

  public Node froggRX(){
    if(froggy.getTranslateX() < 760){
    froggy.setTranslateX(frogg().getTranslateX() + 40);
    }
    return froggy;
  }

  public Node froggDY(){
    if(froggy.getTranslateY() < 560){
    froggy.setTranslateY(frogg().getTranslateY() + 40);
    }
    return froggy;
  }

//Testing

void claim(boolean b){
  if(!b) throw new Error("Test " + testNumber + "fails");
  testNumber++;
}

void testLoseLives(){
  numLives = 5;
  claim(loseLives() == 4);
  System.out.println("testLoseLives works!");
}

void testGetLives(){
  numLives = 5;
  claim(getLives() == 5);
  System.out.println("testGetLives works!");

}






}
