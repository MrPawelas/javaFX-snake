package SnakePackage;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    int width =800;
    int cubeCount = 20;
    int cubeWidth = width/cubeCount;
    int midX = cubeCount/2*cubeWidth;
    int midY = cubeCount/2*cubeWidth;
    Directon directon = Directon.RIGHT;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        StackPane stackPane = new StackPane();

        Canvas canvas = new Canvas(width,width);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Snake snake = new Snake(cubeWidth,midX,midY);
        Food food = new Food(cubeWidth, cubeCount);
        food.newPlace(width,width);

        stackPane.getChildren().add(canvas);
        root.getChildren().add(stackPane);
        String image = Main.class.getResource("grass.jpg").toExternalForm();

        stackPane.setStyle("-fx-background-image: url('" + image + "');  "
        + "-fx-background-repeat: stretch;"
        + "-fx-background-size: cover, auto;");


        primaryStage.setTitle("Snake");

        Scene scene = new Scene(root, width , width );
        DirectonKeyEvent directonKeyEvent = new DirectonKeyEvent(directon);
        scene.setOnKeyPressed(directonKeyEvent);

            new AnimationTimer() {
                long lastFrame =0;
                GameLoop gameLoop = new GameLoop(food,snake,width,gc,cubeWidth,midX,midY);
            @Override
            public void handle(long l) {
                if (lastFrame == 0) {
                    lastFrame = l;
                    return;
                }
                if (l - lastFrame > 100000000 / snake.getSpeed()) {
                    directon = directonKeyEvent.getDirecton();

                    lastFrame = l;
                    gameLoop.loop(directon);
                }
            }
        }.start();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
