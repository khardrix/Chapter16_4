/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                         Chapter 16: Problem 4                                            *****
 *****__________________________________________________________________________________________________________*****
 *****                                   4.  Create a GUI with two Panes.                                       *****
 *****                                  In the bottom Pane, draw a Circle.                                      *****
 *****                                 In the top Pane, insert two Sliders.                                     *****
 *****               One Slider moves the X coordinate of the Circle, the other the Y coordinate.               *****
 *****                                   Start both Sliders in the middle.                                      *****
 *****                Have both Sliders be horizontal even though one adjusts the Y coordinate.                 *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Chapter16_4 extends Application {

    // CLASS VARIABLE(s) declaration(s)
    private Circle circle;
    private Slider slider1, slider2;
    private double xCor = 250;
    private double yCor = 125;
    private double radius = 50;
    private Pane pane1;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        // Initialize both Sliders
        slider1 = new Slider(50, 450, 250);
        slider2 = new Slider(50, 450, 250);

        // Initialize the Circle
        circle = new Circle(xCor, yCor, radius);

        // Initialize the Pane
        pane1 = new Pane();

        // Add the Circle to the Pane
        pane1.getChildren().add(circle);

        // Slider slider1 EventHandler Inner Nested Class
        slider1.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val,
                                             Number new_val) -> {
            // Remove the old Circle
            pane1.getChildren().remove(circle);
            // Get the value from the Slider and downcast it to an int and assign it to the x-coordinate
            xCor = (int)new_val.doubleValue();
            // Initialize a new Circle
            circle = new Circle(xCor, yCor, radius);
            // Add the new Circle to the Pane
            pane1.getChildren().add(circle);
        });

        // Slider slider2 EventHandler Inner Nested Class
        slider2.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val,
                                             Number new_val) -> {
            // Remove the old Circle
            pane1.getChildren().remove(circle);
            // Get the value from the Slider and downcast it to an int and assign it to the y-coordinate
            yCor = (int)new_val.doubleValue();
            // Initialize a new Circle
            circle = new Circle(xCor, yCor, radius);
            // Add the new Circle to the Pane
            pane1.getChildren().add(circle);
        });

        // Create and Initialize a second Pane, a FlowPane
        FlowPane pane2 = new FlowPane();
        // Set the Orientation of the FlowPane to VERTICAL
        pane2.setOrientation(Orientation.VERTICAL);
        // Add both Sliders to the FlowPane
        pane2.getChildren().add(slider1);
        pane2.getChildren().add(slider2);
        // Set the Width and Height of the FlowPane
        pane2.setPrefWidth(500);
        pane2.setPrefHeight(250);

        // Create and Initialize the main Pane, a StackPane
        StackPane mainPane = new StackPane();
        // Add both Panes to the StackPane
        mainPane.getChildren().add(pane1);
        mainPane.getChildren().add(pane2);

        // Create and Initialize the Scene, Set the Title of the Stage, Set the Scene to the Stage and Show the Stage
        Scene scene = new Scene(mainPane, 500, 500);
        primaryStage.setTitle("Chapter 16: Problem 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
