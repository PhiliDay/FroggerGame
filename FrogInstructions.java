import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class FrogInstructions{

  public static void display()
  {
    Stage popUP=new Stage();

    popUP.initModality(Modality.APPLICATION_MODAL);
    popUP.setTitle("Frogger Instructions");

    Label label1= new Label("How To Play Frogger");
    label1.setFont(Font.loadFont("file:polyfont.ttf", 30));

    Label label2= new Label("Help Mr Frog get to the river by avoiding the cars and bikes");
    label2.setFont(Font.loadFont("file:polyfont.ttf", 20));

    Label label3= new Label("Use UP, DOWN, LEFT, RIGHT to move");
    label3.setFont(Font.loadFont("file:polyfont.ttf", 20));

    Label label4= new Label("Be careful, you only have 5 lives!");
    label4.setFont(Font.loadFont("file:polyfont.ttf", 20));

    Button thanks= new Button("Lets Go!!!!");
    thanks.setStyle("-fx-background-color: WHITE; ");
    thanks.setFont(Font.loadFont("file:kirbyss.ttf", 20));
    thanks.setMaxSize(200, 200);
    thanks.setTranslateY(50);
    thanks.setOnAction(e -> popUP.close());
    thanks.getStylesheets().add("layout.css");

    VBox layout= new VBox(0);
    layout.getStyleClass().addAll("layout");

    layout.getChildren().addAll(label1, label2, label3, label4, thanks);
    layout.setAlignment(Pos.CENTER);
    Scene scene1= new Scene(layout, 750, 400);
    scene1.getStylesheets().add("layout.css");

    popUP.setScene(scene1);
    popUP.showAndWait();
  }

}
