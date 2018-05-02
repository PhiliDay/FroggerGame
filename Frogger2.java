import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;


public class Frogger2 extends Application {

  FrogMake froggyMake = new FrogMake();
  FroggerWelcome froggyWelcome = new FroggerWelcome();
  FrogMusic froggyMusic = new FrogMusic();
  FrogBehaviour froggyBeh = new FrogBehaviour();
  FroggerWelcomeScreen fWS = new FroggerWelcomeScreen();

  boolean volume = true;

  @Override
  public void start(Stage stage) throws Exception {
      startGame(stage);
  }

  void startGame(Stage stage){
    testing();
    froggyMusic.mediaPlayer.play();

    stage.setScene(new Scene(froggyWelcome.createDisplay()));

    froggyMusic.mediaBack.stop();
    froggyMusic.mediaOver.stop();
    froggyMusic.mediaWin.stop();

    froggyWelcome.volOn.setOnAction(e1-> {
      froggyMusic.turnOnVol();
    });
    froggyWelcome.volOff.setOnAction(e->{
    froggyMusic.turnOffVol();
    });

    stage.getScene().setOnKeyPressed(event -> {
      switch(event.getCode()){
        case ENTER:
        froggyMusic.mediaPlayer.stop();
        stage.setScene(new Scene(froggyMake.createDisplay()));
        froggyMusic.mediaBack.play();
        froggyMake.yesButton().setOnAction(e1->{
          restart(stage);
        });
        froggyMake.noButton().setOnAction(e2->{
          stage.close();
        });

        //Controls the frogs movement
        stage.getScene().setOnKeyPressed(event2 -> {
            switch (event2.getCode()) {
                case UP :
                    froggyMusic.mediaHop.play();
                    froggyMake.froggY();
                    break;
                case DOWN:
                    froggyMusic.mediaHop.play();
                    froggyMake.froggDY();
                    break;
                case LEFT:
                  froggyMusic.mediaHop.play();
                  froggyMake.froggLX();
                    break;
                case RIGHT:
                    froggyMusic.mediaHop.play();
                    froggyMake.froggRX();
                    break;

                default:
                    break;
          }
        });
        break;
        case Q:
        stage.close();
        break;
        case S:
        froggyMusic.turnOffVol();
        break;
      }
    });
    stage.show();
  }

//Calls the main method again to make the game replay
  void restart(Stage stage) {
    startGame(stage);
  }

  void testing(){
    froggyMake.testLoseLives();
    froggyMake.testGetLives();
  }

  public static void main(String[] args){
    launch(args);
  }

}
