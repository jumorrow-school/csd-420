/*
 * Justin Morrow | Date: 05/02/26
 * CSD-420 Module 7.2: JavaFX program displaying 4 circles & use mystyle.css and test code ensuring functionality
 * 
 * Class Material Resources:
 * Reading: Ch.31 referenced in the instructions but the digital book ends at Ch.30
 * Image: Instructions reference an image but not found in the resource materials for Module 7
 * Files: StyleSheetDemo.java, StrokeDemo.java, TranslationDemo.java, RotateDemo.java used for reference
 *
 * Online Reference:
 * https://www.tutorialspoint.com/javafx/javafx_css.htm
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class mod72CssCircles extends Application {

  /*
   * Override the start method in the Application class
   */
  @Override
  public void start(Stage primaryStage) {

    // Create the Horizontal Box (HBox to contain in the same row) with 5 pixels of spacing between elements
    HBox hBox = new HBox(5);

    // Set the size of the visible GUI window width: 400 and height: 250
    Scene scene = new Scene(hBox, 400, 250);

    //Load the CSS Style Sheet found in the same folder as this java program
    scene.getStylesheets().add("mystyle.css");

    // Create the first pane
    Pane pane1 = new Pane();

    // Creating circles 1 & 2 with the X-Coord., Y-Coord., Radius
    Circle circle1 = new Circle(60, 60, 30);
    Circle circle2 = new Circle(150, 60, 30);

    // Applies the White Circle default style class (white fill/black stroke) from the CSS Style Sheet to Circles 1 & 2
    circle1.getStyleClass().add("whitecircle");
    circle2.getStyleClass().add("whitecircle");

    // Assigning both circles 1 and 2 to the first pane
    pane1.getChildren().addAll(circle1, circle2);


    // Create the second pane
    Pane pane2 = new Pane();

    // Creating circles 3 & 4 with the X-Coord., Y-Coord., Radius
    Circle circle3 = new Circle(60, 150, 30);
    Circle circle4 = new Circle(150, 150, 30);

    // Assign the CSS style ID ‘redcircle’ to Circle 3
    circle3.setId("redcircle");

    // Assign the CSS style ID ‘greencircle’ to Circle 4
    circle4.setId("greencircle");

    // Assigning both circles 3 and 4 to the second pane
    pane2.getChildren().addAll(circle3, circle4);

    // Add both panes to the HBox which will put pane 1 on the left and pane 2 on the right
    hBox.getChildren().addAll(pane1, pane2);


    // Set the window title (Description seen at the top of the GUI)
    primaryStage.setTitle("CSD 420 Module 7.2 JavaFX CSS StyleSheet");

    // Place the scene in window
    primaryStage.setScene(scene);

    // Display the window
    primaryStage.show();
  }

  // Launch program from the command-line
  public static void main(String[] args) {
    launch(args);
  }
}