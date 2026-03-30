/*
 * Justin Morrow | Date: 03/29/26
 * CSD-420 Module 1.3: Write a JavaFX program that displays four images randomly selected from a deck of 52 cards
 *
 * Card Images downloaded from the below since I couldn't fine the AssignmentCards.zip:
 * http://web2.acbl.org/documentlibrary/marketing/Clip_Art/cards_png_zip.zip
 *
 * Online References: ArrayList to store card images & Collections.shuffle() to randomize the cards & Lambda Expressions
 * https://stackoverflow.com/questions/46356033/javafx-displaying-multiple-images-in-grid-pane
 * https://coderanch.com/t/749849/java/Draw-cards-deck-card-images
 * https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/image/Image.html
 * https://www.tutorialspoint.com/javafx/javafx_event_handling.htm
 * https://www.geeksforgeeks.org/java/lambda-expressions-java-8/
 *
 * Professors Example Files:
 * Event Handling: Example_01.java
 * HBox Layout and ImageView: Example_12.java
 * Border Pane Layout: Example_15.java
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;


public class RandomFourCards extends Application {

    // Adapted from online example: Using ArrayList to store images
    private ArrayList<Image> cards = new ArrayList<>();

    // HBox to display cards: Example_12.java
    private HBox cardPane = new HBox(10);

    @Override
    public void start(Stage primaryStage) {

        // Align cards center: Example_01.java
        cardPane.setAlignment(Pos.CENTER);

        // Load all 52 card images into ArrayList: Adapted from online example
        for (int i = 1; i <= 52; i++) {
            Image image = new Image("file:cards/" + i + ".png");
            cards.add(image);
        }

        // Display first 4 cards
        showCards();

        // Button: Example_03.java
        Button btnRefresh = new Button("Draw 4");

        // Lambda Expression: Requirement and examples found on Tutorials Point & GeeksForGeeks
        btnRefresh.setOnAction(e -> {
            shuffleCards();
            showCards();
        });

        // Border Pane Layout: Example_15.java
        BorderPane root = new BorderPane();
        root.setCenter(cardPane);
        root.setBottom(btnRefresh);
        BorderPane.setAlignment(btnRefresh, Pos.CENTER);

        // Scene and Stage
        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Draw 4 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Shuffle cards: Adapted from online example
    private void shuffleCards() {
        Collections.shuffle(cards);
    }

    // Display 4 cards: Adapted from Example_12 ImageView and Online Example
    private void showCards() {
        cardPane.getChildren().clear();

        for (int i = 0; i < 4; i++) {
            ImageView cardView = new ImageView(cards.get(i));
            cardView.setFitWidth(100);
            cardView.setPreserveRatio(true);
            cardPane.getChildren().add(cardView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}