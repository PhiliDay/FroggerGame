import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.layout.Pane;

/*In this class the images of the frog/car/bike are loaded into the nodes*/
public class FrogChild{

  public Node createFrog(){
    Image photo = new Image("frog.png");
    ImageView image = new ImageView(photo);
    image.setFitHeight(38);
    image.setFitWidth(38);
    image.setTranslateY(600 - 39);
      return image;
  }

  public Node createCar() {
    Image photo = new Image("car.png");
    ImageView image = new ImageView(photo);
    image.setFitHeight(40);
    image.setFitWidth(40);
      return image;
  }

  public Node createBike() {
    Image photo = new Image("motorcycle.png");
    ImageView image = new ImageView(photo);
    image.setFitHeight(40);
    image.setFitWidth(40);
      return image;
  }

}
